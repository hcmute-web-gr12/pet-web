package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cloudinary.Cloudinary;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.util.MathUtils;

public class AdminPetController extends HttpServlet {
	private final PetDao petDao;
	private final Cloudinary cloudinary;
	private final MathUtils mathUtils;

	public AdminPetController(PetDao petDao, Cloudinary cloudinary, MathUtils mathUtils) {
		this.petDao = petDao;
		this.cloudinary = cloudinary;
		this.mathUtils = mathUtils;
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int pageSize;
		int page;
		page = mathUtils.clampLow(mathUtils.parseIntOrDefault(request.getParameter("page"), 0), 1);
		pageSize = mathUtils.clampLow(mathUtils.parseIntOrDefault(request.getParameter("page"), 10), 1);
		final var pets = petDao.findSomeOffset((page - 1) * pageSize, pageSize);
		for(final var pet : pets) {
			pet.setImagePublicId(cloudinary.url().secure(true).publicId(pet.getImagePublicId()).generate());
		}
		final var props = new HashMap<String, Object>();
		props.put("url", "/WEB-INF/templates/admin/Pet.jsp");
		props.put("pets", pets);
		props.put("page", page);
		props.put("pageSize", pets.length);
		props.put("total", petDao.countAll());
		request.setAttribute("props", props);
		request.getSession(false).setAttribute("admin.pets", pets);
		request.getRequestDispatcher("/WEB-INF/views/Admin.jsp").forward(request, response);
	}
}
