package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.model.Pet;

public class AdminPetController extends HttpServlet {
	public AdminPetController() {
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("props", new HashMap<String, Object>() {{
			put("url", "/WEB-INF/templates/admin/Pet.jsp");
			put("pets", new Pet[] {
				new Pet() {{ setName("Pet A"); setImageUrl("https://via.placeholder.com/70"); }},
				new Pet() {{ setName("Pet B"); setImageUrl("https://via.placeholder.com/70"); }},
				new Pet() {{ setName("Pet C"); setImageUrl("https://via.placeholder.com/70"); }},
				new Pet() {{ setName("Pet D"); setImageUrl("https://via.placeholder.com/70"); }},
				new Pet() {{ setName("Pet E"); setImageUrl("https://via.placeholder.com/70"); }},
				new Pet() {{ setName("Pet F"); setImageUrl("https://via.placeholder.com/70"); }},
			});
		}});
		final var dispatcher = request.getRequestDispatcher("/WEB-INF/views/Admin.jsp");
		dispatcher.forward(request, response);
	}
}
