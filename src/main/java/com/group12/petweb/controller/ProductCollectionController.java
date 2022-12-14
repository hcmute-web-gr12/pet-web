package com.group12.petweb.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;

import com.group12.petweb.dao.PetDao;
import com.group12.petweb.model.Pet;
import com.group12.petweb.util.CloudinaryUtils;
import com.group12.petweb.util.MathUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductCollectionController extends HttpServlet {
	private final PetDao petDao;
	private final MathUtils mUtils;
	private final CloudinaryUtils cloudinaryUtils;

	public ProductCollectionController(PetDao petDao, MathUtils mUtils, CloudinaryUtils cloudinaryUtils) {
		this.petDao = petDao;
		this.mUtils = mUtils;
		this.cloudinaryUtils = cloudinaryUtils;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var categories = request.getParameterValues("category");
		final var page = mUtils.clampLow(mUtils.parseIntOrDefault(request.getParameter("page"), 1), 1);
		final var pageSize = mUtils.clampLow(mUtils.parseIntOrDefault(request.getParameter("pageSize"), 15), 1);
		Pet[] pets;
		if (categories == null) {
			pets = petDao.findSomeOffset((page - 1) * pageSize, pageSize);
		} else {
			final var bCategories = new ArrayList<Byte>();
			for (final var c : categories) {
				try {
					bCategories.add(Byte.parseByte(c));
				} catch (NumberFormatException ex) { }
			}
			pets = petDao.findCategoriesOffset(ArrayUtils.toPrimitive(bCategories.stream().toArray(Byte[]::new)),
					(page - 1) * pageSize, pageSize);
		}
		for (final var pet : pets) {
			pet.setImagePublicId(cloudinaryUtils.generateImageUrl(
					pet,
					url -> url.format("webp"),
					transform -> transform.quality("auto").width(450).height(450).crop("fit")));
		}
		final var props = new HashMap<String, Object>();
		props.put("pets", pets);
		props.put("page", page);
		props.put("pageSize", pageSize);
		request.setAttribute("props", props);
		request.getRequestDispatcher("/WEB-INF/views/ProductCollection.jsp").forward(request, response);
	}
}
