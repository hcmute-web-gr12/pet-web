package com.group12.petweb.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductsController extends HttpServlet {
	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final String type = request.getParameter("type");
		if (type == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		RequestDispatcher dispatcher;
		if (type.equalsIgnoreCase("dog")) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/Products_Dog.jsp");
		} else if (type.equalsIgnoreCase("cat")) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/Products_Cat.jsp");
		} else if (type.equalsIgnoreCase("acc")) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/views/Products_Acc.jsp");
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		dispatcher.forward(request, response);
	}
}
