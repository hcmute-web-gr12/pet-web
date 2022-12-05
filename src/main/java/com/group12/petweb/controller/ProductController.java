package com.group12.petweb.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloudinary.Cloudinary;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.service.Redirector;
import com.group12.petweb.util.MathUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class ProductController extends HttpServlet {
	private final PetDao petDao;
	private final MathUtils mUtils;
	private final Cloudinary cloudinary;
	private final Redirector redirector;

	public ProductController(PetDao petDao, MathUtils mUtils, Cloudinary cloudinary, Redirector redirector) {
		this.petDao = petDao;
		this.mUtils = mUtils;
		this.cloudinary = cloudinary;
		this.redirector = redirector;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var path = request.getPathInfo().substring(1);
		if (path == null || path.length() == 0) {
			redirector.redirect(request, response, "/product", 1);
			return;
		}
		try {
			final var id = UUID.fromString(path);
			final var optional = petDao.findById(id);
			if (optional.isEmpty()) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			final var pet = optional.get();
			final var props = new HashMap<String, Object>();
			pet.setImagePublicId(cloudinary.url().secure(true).publicId(pet.getImagePublicId()).generate());
			props.put("pet", optional.get());
			request.setAttribute("props", props);
			request.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(request, response);
		} catch(IllegalArgumentException ex) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
