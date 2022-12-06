package com.group12.petweb.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group12.petweb.dao.PetDao;
import com.group12.petweb.service.Redirector;
import com.group12.petweb.util.CloudinaryUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class ProductController extends HttpServlet {
	private final PetDao petDao;
	private final Redirector redirector;
	private final CloudinaryUtils cloudinaryUtils;

	public ProductController(PetDao petDao, Redirector redirector, CloudinaryUtils cloudinaryUtils) {
		this.petDao = petDao;
		this.redirector = redirector;
		this.cloudinaryUtils = cloudinaryUtils;
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
			pet.setImagePublicId(cloudinaryUtils.generateImageUrl(
					pet,
					url -> url.format("webp"),
					transform -> transform.quality("auto").width(1000).crop("fill")));
			props.put("pet", optional.get());
			request.setAttribute("props", props);
			request.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(request, response);
		} catch (IllegalArgumentException ex) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
