package com.group12.petweb.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.UserDao;
import com.group12.petweb.model.UserSession;
import com.group12.petweb.service.Redirector;

public class UserProfileController extends HttpServlet {
	private final UserDao userDao;
	private final Redirector redirector;

	public UserProfileController(UserDao userDao, Redirector redirector) {
		this.userDao = userDao;
		this.redirector = redirector;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var userSession = (UserSession) request.getSession(false).getAttribute("user");
		final var user = userDao.findById(userSession.getId());
		if (user.isEmpty()) {
			redirector.redirect(request, response, "/login", "Phiên làm việc đã hết hạn.", 1);
			return;
		}

		request.setAttribute("username", user.get().getName());
		final var dispatcher = request.getRequestDispatcher("/WEB-INF/views/user/Profile.jsp");
		dispatcher.forward(request, response);
	}
}
