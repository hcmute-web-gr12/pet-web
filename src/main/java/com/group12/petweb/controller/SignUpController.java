package com.group12.petweb.controller;

import com.group12.petweb.dao.UserDao;
import com.group12.petweb.model.SignUpValidationError;
import com.group12.petweb.model.User;
import com.group12.petweb.service.Redirector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.PersistenceException;

public class SignUpController extends HttpServlet {
	private final UserDao userDao;
	private final Redirector redirector;

	public SignUpController(UserDao userDao, Redirector redirector) {
		this.userDao = userDao;
		this.redirector = redirector;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/SignUp.jsp");
		dispatcher.forward(request, response);
	}

	@Override()
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var error = validatePost(request);
		if (error.isPresent()) {
			request.setAttribute("error", error.get());
			request.getRequestDispatcher("/WEB-INF/views/SignUp.jsp").forward(request, response);
			return;
		}

		try {
			final User user = new User();
			{
				user.setEmail(request.getParameter("email"));
				user.setPassword(
						BCrypt.withDefaults().hashToString(12, request.getParameter("password").toCharArray()));
				user.setName(request.getParameter("username"));
			}
			userDao.create(user);
		} catch (PersistenceException ex) {
			request.setAttribute("error", new SignUpValidationError() {
				{
					setEmail("Địa chỉ Email đã tồn tại.");
				}
			});
			request.getRequestDispatcher("/WEB-INF/views/SignUp.jsp").forward(request, response);
			return;
		}
		redirector.redirect(request, response, "/login", "Đăng ký thành công!", 1);
	}

	public final Optional<SignUpValidationError> validatePost(HttpServletRequest request) {
		final var error = new SignUpValidationError();
		final var map = request.getParameterMap();
		if (!map.containsKey("username")) {
			error.setUsername("Tên tài khoản là bắt buộc.");
		} else {
			final var username = map.get("username")[0];
			if (username.length() < 6) {
				error.setUsername("Tên tài khoản cần ít nhất 6 ký tự.");
			} else {
				final var pattern = Pattern.compile("^[a-zA-Z0-9_\\-]+$");
				if (!pattern.matcher(username).matches()) {
					error.setUsername("Tên tài khoản không hợp lệ.");
				}
			}
		}

		if (!map.containsKey("email")) {
			error.setEmail("Địa chỉ Email là bắt buộc.");
		} else {
			Pattern pattern = Pattern.compile(
					"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
			if (!pattern.matcher(map.get("email")[0]).matches()) {
				error.setEmail("Địa chỉ Email không hợp lệ.");
			}
		}

		if (!map.containsKey("password")) {
			error.setPassword("Mật khẩu là bắt buộc.");
		} else {
			final var password = map.get("password")[0];
			if (password.length() < 8) {
				error.setPassword("Mật khẩu cần ít nhất 8 ký tự.");
			} else {
				if (!map.containsKey("passwordVerify")) {
					error.setPasswordVerify("Xác nhận mật khẩu là bắt buộc.");
				} else if (!map.get("passwordVerify")[0].equals(password)) {
					error.setPassword("Xác nhận mật khẩu không trùng khớp.");
					error.setPasswordVerify("Xác nhận mật khẩu không trùng khớp.");
				}
			}
		}
		return (error.getUsername() == null
				&& error.getEmail() == null
				&& error.getPassword() == null
				&& error.getPasswordVerify() == null)
						? Optional.empty()
						: Optional.of(error);
	}
}
