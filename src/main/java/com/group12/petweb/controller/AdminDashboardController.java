package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdminDashboardController extends HttpServlet {
	public AdminDashboardController() {
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("props", new HashMap<String, Object>() {{
			put("url", "/WEB-INF/templates/admin/Dashboard.jsp");
		}});
		final var dispatcher = request.getRequestDispatcher("/WEB-INF/views/Admin.jsp");
		dispatcher.forward(request, response);
	}
}
