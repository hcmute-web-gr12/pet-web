package com.group12.petweb.controller;

import java.io.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.dao.CartDao;
import com.group12.petweb.model.UserSession;
import com.group12.petweb.util.CloudinaryUtils;

public class CartController extends HttpServlet {
	private final CartDao cartDao;
	private final CloudinaryUtils cUtils;

	public CartController(CartDao cartDao, CloudinaryUtils cUtils) {
		this.cartDao = cartDao;
		this.cUtils = cUtils;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var optional = cartDao.findByUserId(((UserSession) request.getSession().getAttribute("user")).getId());
		if (optional.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/views/Cart.jsp").forward(request, response);
			return;
		}

		final var props = new HashMap<String, Object>();
		final var cart = optional.get();
		props.put("cart", cart);
		for (final var item : cart.getItems()) {
			item.getPet().setImagePublicId(
					cUtils.generateImageUrl(
							item.getPet(),
							url -> url.format("webp"),
							transform -> transform.quality("auto").width(300).height(300).crop("fit")));
		}
		request.setAttribute("props", props);
		request.getRequestDispatcher("/WEB-INF/views/Cart.jsp").forward(request, response);
	}
}
