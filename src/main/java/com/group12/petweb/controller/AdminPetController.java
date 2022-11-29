package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.PetDao;

public class AdminPetController extends HttpServlet {
	private final PetDao petDao;
	public AdminPetController(PetDao petDao) {
		this.petDao = petDao;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int pageSize;
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception ex) {
			page = 1;
		}
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		} catch (Exception ex) {
			pageSize = 10;
		}
		final var pets = petDao.findSomeOffset((page - 1) * 10, pageSize);
		final var props = new HashMap<String, Object>();
		props.put("url", "/WEB-INF/templates/admin/Pet.jsp");
		props.put("pets", pets);
		props.put("page", page);
		props.put("pageSize", pets.length);
		props.put("total", petDao.countAll());
		request.setAttribute("props", props);
		request.getRequestDispatcher("/WEB-INF/views/Admin.jsp").forward(request, response);
	}
}
