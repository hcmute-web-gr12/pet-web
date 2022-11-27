package com.group12.petweb.controller.api;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AdminPetApiController extends HttpServlet {
	@Override()
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().print(HttpServletResponse.SC_OK);
	}
}
