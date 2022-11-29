package com.group12.petweb.controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name="detailServlet", value="/detail")
public class ProductsDetailController extends HttpServlet {
	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Detail.jsp");
		dispatcher.forward(request, response);
	}
}
