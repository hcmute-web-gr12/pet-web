package com.group12.petweb.controller.api;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.PetDao;
import com.group12.petweb.model.Pet;

import jakarta.persistence.PersistenceException;

public class AdminPetApiController extends HttpServlet {
	private final PetDao petDao;

	public AdminPetApiController(PetDao petDao) {
		this.petDao = petDao;
	}

	@Override()
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO: upload imageFile part to Cloudimage
		try {
			final var model = new Pet();
			model.setName(request.getParameter("name"));
			model.setDescription(request.getParameter("description"));
			model.setImageUrl(request.getParameter("imageFile"));
			try {
				model.setPrice(Integer.parseUnsignedInt(request.getParameter("price")));
				model.setStock(Integer.parseUnsignedInt(request.getParameter("stock")));
			} catch (NumberFormatException ex) {
				model.setPrice(0);
				model.setStock(0);
			}
			petDao.create(model);
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().print(HttpServletResponse.SC_OK);
		} catch (PersistenceException ex) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().print(ex.getMessage());
		}
	}
}
