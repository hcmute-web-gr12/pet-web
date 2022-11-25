package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.UserCredentialsDao;
import com.group12.petweb.model.UserSession;
import com.group12.petweb.service.Redirector;

public class UserProfileController extends HttpServlet {
	private final UserCredentialsDao userCredentialsDao;
	private final Redirector redirector;

	public UserProfileController(UserCredentialsDao userCredentialsDao, Redirector redirector) {
		this.userCredentialsDao = userCredentialsDao;
		this.redirector = redirector;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var userSession = (UserSession) request.getSession(false).getAttribute("user");
		final var user = userCredentialsDao.findById(userSession.getId());
		if (user.isEmpty()) {
			redirector.redirect(request, response, "/login", "Xin vui lòng đăng nhập lại.", 1);
			return;
		}

		request.setAttribute("username", user.get().getName());
		request.setAttribute("props", new HashMap<String, Object>() {{
			put("url", "/WEB-INF/templates/user/Profile.jsp");
			put("user", user.get());
		}});
		final var dispatcher = request.getRequestDispatcher("/WEB-INF/views/User.jsp");
		dispatcher.forward(request, response);
	}
}
