package com.group12.petweb.controller.api;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cloudinary.Cloudinary;
import com.google.gson.Gson;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.model.Pet;

public class AdminPetApiController extends HttpServlet {
	private final PetDao petDao;
	private final Cloudinary cloudinary;

	public AdminPetApiController(PetDao petDao, Cloudinary cloudinary) {
		this.petDao = petDao;
		this.cloudinary = cloudinary;
	}

	@Override()
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
		response.setContentType("application/json");
		response.getWriter().print(new Gson().toJson(pets));
		request.getSession(false).setAttribute("admin.pets", pets);
	}

	@Override()
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var part = request.getPart("imageFile");
		final var fileName = part.getSubmittedFileName();
		final var index = fileName.indexOf('.');
		final var name = fileName.substring(0, index);
		final var ext = fileName.substring(index);
		final var temp = File.createTempFile(name + '-', ext, new File("/tmp"));
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

			Files.copy(is, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
			final var res = cloudinary.uploader().upload(
					temp,
					new HashMap<String, String>() {
						{
							put("public_id", "pet-" + model.getId().toString());
						}
					});
			temp.delete();
			model.setImageUrl((String) res.get("secure_url"));
			petDao.update(model);
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().print(HttpServletResponse.SC_OK);
		} catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().print(ex.getMessage());
		}
	}
}
