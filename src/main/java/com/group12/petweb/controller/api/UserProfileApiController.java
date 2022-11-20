package com.group12.petweb.controller.api;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.UserDao;
import com.group12.petweb.service.Redirector;

public class UserProfileApiController extends HttpServlet {
	private final UserDao userDao;
	private final Redirector redirector;

	public UserProfileApiController(UserDao userDao, Redirector redirector) {
		this.userDao = userDao;
		this.redirector = redirector;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.getWriter().write("OK");
	}
}
