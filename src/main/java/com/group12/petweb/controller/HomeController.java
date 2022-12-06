package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.PetDao;
import com.group12.petweb.model.Pet;
import com.group12.petweb.util.CloudinaryUtils;

public class HomeController extends HttpServlet {
	private final PetDao petDao;
	private final CloudinaryUtils cloudinaryUtils;

	public HomeController(PetDao petDao, CloudinaryUtils cloudinaryUtils) {
		this.petDao = petDao;
		this.cloudinaryUtils = cloudinaryUtils;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var dogs = petDao.findCategoryOffset(Pet.CATEGORY_DOG, 0, 5);
		final var cats = petDao.findCategoryOffset(Pet.CATEGORY_CAT, 0, 5);
		for (final var pet : dogs) {
			pet.setImagePublicId(cloudinaryUtils.generateImageUrl(
					pet,
					url -> url.format("webp"),
					transform -> transform.quality("auto").width(300).height(300).crop("fill")));
		}
		for (final var pet : cats) {
			pet.setImagePublicId(cloudinaryUtils.generateImageUrl(
					pet,
					url -> url.format("webp"),
					transform -> transform.quality("auto").width(300).height(300).crop("fill")));
		}
		final var props = new HashMap<String, Object>();
		props.put("dogs", dogs);
		props.put("cats", cats);
		request.setAttribute("props", props);
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
	}
}
