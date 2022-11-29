package com.group12.petweb.controller.api;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cloudinary.Cloudinary;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.model.Pet;
import com.group12.petweb.util.MathUtils;

public class AdminPetApiController extends HttpServlet {
	private final PetDao petDao;
	private final Cloudinary cloudinary;
	private final MathUtils mathUtils;

	public AdminPetApiController(PetDao petDao, Cloudinary cloudinary, MathUtils mathUtils) {
		this.petDao = petDao;
		this.cloudinary = cloudinary;
		this.mathUtils = mathUtils;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int pageSize;
		int page;
		page = mathUtils.clampLow(mathUtils.parseIntOrDefault(request.getParameter("page"), 1), 1);
		pageSize = mathUtils.clampLow(mathUtils.parseIntOrDefault(request.getParameter("pageSize"), 10), 1);
		final var pets = petDao.findSomeOffset((page - 1) * 10, pageSize);
		for (final var pet : pets) {
			pet.setImagePublicId(cloudinary.url().secure(true).publicId(pet.getImagePublicId()).generate());
		}
		request.getSession(false).setAttribute("admin.pets", pets);
		final var props = new HashMap<String, Object>();
		props.put("pets", pets);
		props.put("page", page);
		props.put("pageSize", pets.length);
		props.put("total", petDao.countAll());
		request.setAttribute("props", props);
		request.getRequestDispatcher("/WEB-INF/templates/admin/pet/TableSlot.jsp").forward(request, response);
	}

	@Override()
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var part = request.getPart("imageFile");
		try (final var is = part.getInputStream()) {
			final var model = new Pet();
			model.setId(UUID.randomUUID());
			model.setName(request.getParameter("name"));
			model.setDescription(request.getParameter("description"));
			try {
				model.setPrice(Integer.parseUnsignedInt(request.getParameter("price")));
				model.setStock(Integer.parseUnsignedInt(request.getParameter("stock")));
			} catch (NumberFormatException ex) {
				model.setPrice(0);
				model.setStock(0);
			}

			final var fileName = part.getSubmittedFileName();
			if (fileName != null && !fileName.isEmpty()) {
				final var index = fileName.indexOf('.');
				final var name = fileName.substring(0, index);
				final var ext = fileName.substring(index);
				final var temp = File.createTempFile(name + '-', ext, new File("/tmp"));
				final var publicId = "pet/" + model.getId().toString();
				Files.copy(is, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
				cloudinary.uploader().upload(
						temp,
						new HashMap<String, String>() {
							{
								put("public_id", publicId);
							}
						});
				temp.delete();
				model.setImagePublicId(publicId);
			} else {
				model.setImagePublicId("pet/default.jpg");
			}
			petDao.update(model);
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().print(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().print(ex.getMessage());
		}
	}
}
