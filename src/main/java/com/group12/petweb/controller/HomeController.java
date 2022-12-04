package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cloudinary.Cloudinary;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.model.Pet;

public class HomeController extends HttpServlet {
	private final PetDao petDao;
	private final Cloudinary cloudinary;

	public HomeController(PetDao petDao, Cloudinary cloudinary) {
		this.petDao = petDao;
		this.cloudinary = cloudinary;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var dogs = petDao.findCategoryOffset(Pet.CATEGORY_DOG, 0, 5);
		final var cats = petDao.findCategoryOffset(Pet.CATEGORY_CAT, 0, 5);
		for (final var pet : dogs) {
			pet.setImagePublicId(cloudinary.url().secure(true).publicId(pet.getImagePublicId()).generate());
		}
		for (final var pet : cats) {
			pet.setImagePublicId(cloudinary.url().secure(true).publicId(pet.getImagePublicId()).generate());
		}
		final var props = new HashMap<String, Object>();
		props.put("dogs", dogs);
		props.put("cats", cats);
		request.setAttribute("props", props);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
	}
}
