package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdminPetController extends HttpServlet {
	public AdminPetController() {
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("props", new HashMap<String, Object>() {{
			put("url", "/WEB-INF/templates/admin/Pet.jsp");
		}});
		final var dispatcher = request.getRequestDispatcher("/WEB-INF/views/Admin.jsp");
		dispatcher.forward(request, response);
	}
}
