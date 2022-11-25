package com.group12.petweb.controller;

import com.group12.petweb.dao.UserCredentialsDao;
import com.group12.petweb.model.LoginValidationError;
import com.group12.petweb.model.UserCredentials;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.group12.petweb.model.UserSession;
import com.group12.petweb.service.Redirector;

public class LoginController extends HttpServlet {
	private final UserCredentialsDao userCredentialsDao;
	private final Redirector redirector;

	public LoginController(UserCredentialsDao userCredentialsDao, Redirector redirector) {
		this.userCredentialsDao = userCredentialsDao;
		this.redirector = redirector;
	}

	@Override()
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		dispatcher.forward(request, response);
	}

	@Override()
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		final Optional<LoginValidationError> error = validatePost(request);
		if (error.isPresent()) {
			request.setAttribute("error", error.get());
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
			return;
		}

		Optional<UserCredentials> credentials = userCredentialsDao.findByEmail(request.getParameter("email"));

		if (credentials.isEmpty()) {
			request.setAttribute("error", new LoginValidationError() {
				{
					setEmail("Địa chỉ Email không tồn tại.");
				}
			});
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
			return;
		}

		BCrypt.Result result = BCrypt
				.verifyer()
				.verify(request.getParameter("password").toCharArray(), credentials.get().getPassword());
		if (!result.verified) {
			request.setAttribute("error", new LoginValidationError() {
				{
					setPassword("Mật khẩu không chính xác.");
				}
			});
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
			return;
		}
		final var userSession = new UserSession();
		{
			userSession.setId(credentials.get().getId());
		}
		request.getSession(true).setAttribute("user", userSession);
		redirector.redirect(request, response, "/", "Đăng nhập thành công!", 1);
	}

	private Optional<LoginValidationError> validatePost(HttpServletRequest request) {
		final LoginValidationError error = new LoginValidationError();
		final Map<String, String[]> parameterMap = request.getParameterMap();
		if (!parameterMap.containsKey("email")) {
			error.setEmail("Địa chỉ Email là bắt buộc.");
		} else {
			Pattern pattern = Pattern.compile(
					"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
			if (!pattern.matcher(parameterMap.get("email")[0]).matches()) {
				error.setEmail("Địa chỉ Email không hợp lệ.");
			}
		}

		if (!parameterMap.containsKey("password")) {
			error.setPassword("Mật khẩu là bắt buộc.");
		}

		return (error.getEmail() == null && error.getPassword() == null)
				? Optional.empty()
				: Optional.of(error);
	}
}
