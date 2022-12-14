package com.group12.petweb.controller;

import com.group12.petweb.dao.UserCredentialsDao;
import com.group12.petweb.model.SignUpValidationError;
import com.group12.petweb.model.UserCredentials;
import com.group12.petweb.service.Mail;
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
	private final UserCredentialsDao userCredentialsDao;
	private final Redirector redirector;
	private final Mail mail;

	public SignUpController(UserCredentialsDao userCredentialsDao, Redirector redirector, Mail mail) {
		this.userCredentialsDao = userCredentialsDao;
		this.redirector = redirector;
		this.mail = mail;
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
			final var credentials = new UserCredentials();
			{
				credentials.setEmail(request.getParameter("email"));
				credentials.setPassword(
						BCrypt.withDefaults().hashToString(12, request.getParameter("password").toCharArray()));
				credentials.setName(request.getParameter("username"));
			}
			userCredentialsDao.create(credentials);
		} catch (PersistenceException ex) {
			request.setAttribute("error", new SignUpValidationError() {
				{
					setEmail("?????a ch??? Email ???? t???n t???i.");
				}
			});
			request.getRequestDispatcher("/WEB-INF/views/SignUp.jsp").forward(request, response);
			return;
		}
		try {
			mail.sendTo(request.getParameter("email"), "????ng k?? t??i kho???n t???i Pet Web!",
					"Xin ch??o " + (String) request.getParameter("username") + "!\n" +
							"T??i kho???n c???a b???n ???? ???????c ????ng k?? th??nh c??ng.");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		redirector.redirect(request, response, "/login", "????ng k?? th??nh c??ng!", 1);
	}

	public final Optional<SignUpValidationError> validatePost(HttpServletRequest request) {
		final var error = new SignUpValidationError();
		final var map = request.getParameterMap();
		if (!map.containsKey("username")) {
			error.setUsername("T??n t??i kho???n l?? b???t bu???c.");
		} else {
			final var username = map.get("username")[0];
			if (username.length() < 6) {
				error.setUsername("T??n t??i kho???n c???n ??t nh???t 6 k?? t???.");
			} else {
				final var pattern = Pattern.compile("^[a-zA-Z0-9_\\-]+$");
				if (!pattern.matcher(username).matches()) {
					error.setUsername("T??n t??i kho???n kh??ng h???p l???.");
				}
			}
		}

		if (!map.containsKey("email")) {
			error.setEmail("?????a ch??? Email l?? b???t bu???c.");
		} else {
			Pattern pattern = Pattern.compile(
					"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
			if (!pattern.matcher(map.get("email")[0]).matches()) {
				error.setEmail("?????a ch??? Email kh??ng h???p l???.");
			}
		}

		if (!map.containsKey("password")) {
			error.setPassword("M???t kh???u l?? b???t bu???c.");
		} else {
			final var password = map.get("password")[0];
			if (password.length() < 8) {
				error.setPassword("M???t kh???u c???n ??t nh???t 8 k?? t???.");
			} else {
				if (!map.containsKey("passwordVerify")) {
					error.setPasswordVerify("X??c nh???n m???t kh???u l?? b???t bu???c.");
				} else if (!map.get("passwordVerify")[0].equals(password)) {
					error.setPassword("X??c nh???n m???t kh???u kh??ng tr??ng kh???p.");
					error.setPasswordVerify("X??c nh???n m???t kh???u kh??ng tr??ng kh???p.");
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
