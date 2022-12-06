package com.group12.petweb.controller.api;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.cloudinary.Cloudinary;
import com.google.gson.Gson;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.model.Pet;
import com.group12.petweb.util.CloudinaryUtils;
import com.group12.petweb.util.MathUtils;
import com.group12.petweb.util.PaginationUtils;

public class AdminPetApiController extends HttpServlet {
	private final PetDao petDao;
	private final Cloudinary cloudinary;
	private final MathUtils mathUtils;
	private final PaginationUtils pUtils;
	private final CloudinaryUtils cloudinaryUtils;

	public AdminPetApiController(PetDao petDao, Cloudinary cloudinary, MathUtils mathUtils, PaginationUtils pUtils, CloudinaryUtils cloudinaryUtils) {
		this.petDao = petDao;
		this.cloudinary = cloudinary;
		this.mathUtils = mathUtils;
		this.pUtils = pUtils;
		this.cloudinaryUtils = cloudinaryUtils;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var index = request.getParameter("index");
		if (index != null) {
			try {
				final var i = Integer.parseInt(index);
				final var pets = (Pet[]) request.getSession(false).getAttribute("admin.pets");
				if (i < 0 || i >= pets.length) {
					return;
				}
				final var optional = petDao.findById(pets[i].getId());
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("application/json");
				if (optional.isEmpty()) {
					response.getWriter().print("{}");
				} else {
					final var pet = optional.get();
					pet.setImagePublicId(cloudinaryUtils.generateImageUrl(pet));
					response.getWriter().print(new Gson().toJson(pet));
				}
			} catch (NumberFormatException ex) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.setContentType("text/plain");
				response.getWriter().print("");
			}
			return;
		}

		int pageSize;
		int page;
		page = mathUtils.clampLow(mathUtils.parseIntOrDefault(request.getParameter("page"), 1), 1);
		pageSize = mathUtils.clampLow(mathUtils.parseIntOrDefault(request.getParameter("pageSize"), 10), 1);
		final var pets = petDao.findSomeOffset((page - 1) * pageSize, pageSize);
		for (final var pet : pets) {
			pet.setImagePublicId(cloudinaryUtils.generateImageUrl(pet));
		}
		request.getSession(false).setAttribute("admin.pets", pets);
		final var props = new HashMap<String, Object>();
		final var total = petDao.countAll();
		props.put("pets", pets);
		props.put("page", page);
		props.put("pageSize", pageSize);
		props.put("total", total);
		props.put("pages", pUtils.generatePageStrings(total, page, pageSize));
		request.setAttribute("props", props);
		request.getRequestDispatcher("/WEB-INF/templates/admin/pet/TableSlot.jsp").forward(request, response);
	}

	@Override()
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var part = request.getPart("imageFile");
		try (final var is = part.getInputStream()) {
			final var model = new Pet();
			model.setId(UUID.randomUUID());
			model.setName(new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1),
					StandardCharsets.UTF_8));
			model.setDescription(new String(request.getParameter("description").getBytes(StandardCharsets.ISO_8859_1),
					StandardCharsets.UTF_8));
			model.setCategory(Byte.parseByte(request.getParameter("category")));
			model.setPrice(Integer.parseUnsignedInt(request.getParameter("price")));
			model.setStock(Integer.parseUnsignedInt(request.getParameter("stock")));

			final var fileName = part.getSubmittedFileName();
			if (fileName != null && !fileName.isEmpty()) {
				final var index = fileName.indexOf('.');
				final var name = fileName.substring(0, index);
				final var ext = fileName.substring(index);
				final var temp = File.createTempFile(name + '-', ext, new File("/tmp"));
				final var publicId = "pet/" + model.getId().toString();
				Files.copy(is, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
				final var result = cloudinary.uploader().upload(
						temp,
						new HashMap<String, String>() {
							{
								put("public_id", publicId);
							}
						});
				temp.delete();
				model.setImagePublicId(publicId);
				model.setImageFormat((String) result.get("format"));
				model.setImageVersion((Integer)result.get("version"));
			} else {
				model.setImagePublicId("pet/default.jpg");
			}
			petDao.update(model);
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().print(HttpServletResponse.SC_OK);
		} catch (NumberFormatException ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(ex.getMessage());
		} catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().print(ex.getMessage());
		}
	}

	@Override()
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		final var indexes = request.getParameterValues("index");
		if (indexes == null || indexes.length == 0) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		final var pets = (Pet[]) request.getSession(false).getAttribute("admin.pets");
		if (pets == null || pets.length == 0) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().print(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		final var length = pets.length;
		final var ids = new ArrayList<UUID>(indexes.length);
		for (final var index : indexes) {
			try {
				final var i = Integer.parseInt(index);
				if (i < 0 || i >= length) {
					continue;
				}
				ids.add(pets[i].getId());
			} catch (NumberFormatException ex) {
			}
		}
		petDao.deleteById(ids);
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().print(HttpServletResponse.SC_OK);
	}

	@Override()
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var index = request.getParameter("index");
		if (index == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		final var attr = request.getSession(false).getAttribute("admin.pets");
		if (attr == null) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().print(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		final var pets = (Pet[]) attr;
		try {
			final var i = Integer.parseInt(index);
			if (i < 0 || i >= pets.length) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().print(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			final var optional = petDao.findById(pets[i].getId());
			if (optional.isEmpty()) {
				response.setStatus(HttpServletResponse.SC_GONE);
				response.getWriter().print(HttpServletResponse.SC_GONE);
				return;
			}
			final var pet = optional.get();
			pet.setName(new String(request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1),
					StandardCharsets.UTF_8));
			pet.setDescription(new String(request.getParameter("description").getBytes(StandardCharsets.ISO_8859_1),
					StandardCharsets.UTF_8));
			pet.setPrice(Integer.parseUnsignedInt(request.getParameter("price")));
			pet.setStock(Integer.parseUnsignedInt(request.getParameter("stock")));

			final var part = request.getPart("imageFile");
			final var is = part.getInputStream();
			final var fileName = part.getSubmittedFileName();
			if (fileName != null && !fileName.isEmpty()) {
				final var idx = fileName.indexOf('.');
				final var name = fileName.substring(0, idx);
				final var ext = fileName.substring(idx);
				final var temp = File.createTempFile(name + '-', ext, new File("/tmp"));
				final var publicId = "pet/" + pet.getId().toString();
				Files.copy(is, temp.toPath(), StandardCopyOption.REPLACE_EXISTING);
				final var result = cloudinary.uploader().upload(
						temp,
						new HashMap<String, String>() {
							{
								put("public_id", publicId);
								put("overwrite", "true");
							}
						});
				temp.delete();
				pet.setImagePublicId(publicId);
				pet.setImageFormat((String) result.get("format"));
				pet.setImageVersion((Integer)result.get("version"));
				response.setStatus(HttpServletResponse.SC_OK);
				response.getWriter().print(HttpServletResponse.SC_OK);
			}
			petDao.update(pet);
		} catch (NumberFormatException ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(ex.getMessage());
		} catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().print(ex.getMessage());
		}
	}
}
