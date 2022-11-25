package com.group12.petweb.controller.api;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.UserCredentialsDao;
import com.group12.petweb.model.UserSession;

public class UserProfileApiController extends HttpServlet {
	private final UserCredentialsDao userCredentialsDao;

	public UserProfileApiController(UserCredentialsDao userCredentialsDao) {
		this.userCredentialsDao = userCredentialsDao;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var userSession = (UserSession) request.getSession(false).getAttribute("user");
		final var user = userCredentialsDao.findById(userSession.getId());
		if (user.isEmpty()) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		request.setAttribute("props", new HashMap<String, Object>() {{
			put("url", "/WEB-INF/templates/user/Profile.jsp");
			put("user", user.get());
		}});
		final var dispatcher = request.getRequestDispatcher("/WEB-INF/templates/user/Profile.jsp");
		dispatcher.forward(request, response);
	}
}

