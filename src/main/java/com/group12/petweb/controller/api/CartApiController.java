package com.group12.petweb.controller.api;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonSyntaxException;
import com.group12.petweb.dao.CartDao;
import com.group12.petweb.dao.CartItemDao;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.dao.UserCredentialsDao;
import com.group12.petweb.model.Cart;
import com.group12.petweb.model.CartItem;
import com.group12.petweb.model.UserSession;

public class CartApiController extends HttpServlet {
	private final CartDao cartDao;
	private final PetDao petDao;
	private final UserCredentialsDao ucDao;
	private final CartItemDao ciDao;

	public CartApiController(CartDao cartDao, PetDao petDao, UserCredentialsDao uDao, CartItemDao ciDao) {
		this.cartDao = cartDao;
		this.petDao = petDao;
		this.ucDao = uDao;
		this.ciDao = ciDao;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}

	@Override()
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String idString;
		try {
			idString = request.getParameter("id");
			if (idString == null || idString.isEmpty()) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().print("missing id parameter");
				return;
			}
		} catch (JsonSyntaxException ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(ex.getMessage());
			return;
		}
		UUID id;
		try {
			id = UUID.fromString(idString);
		} catch (Exception ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print(ex.getMessage());
			return;
		}
		final var session = request.getSession(false);
		final var cartId = (UUID) session.getAttribute("cartId");
		if (cartId == null) {
			setCartSession(session, id);
		} else {
			final var optional = cartDao.findById(cartId);
			if (optional.isEmpty()) {
				setCartSession(session, id);
			} else {
				final var cart = optional.get();
				var duplicated = false;
				for(var item : cart.getItems()) {
					if (item.getPet().getId().equals(id)) {
						item.setQuantity(item.getQuantity() + 1);
						duplicated = true;
						ciDao.update(item);
						break;
					}
				}
				if (!duplicated) {
					final var item = new CartItem(cart, petDao.getReference(id), 1);
					ciDao.update(item);
				}
			}
		}
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().print("");
	}

	private void setCartSession(HttpSession session, UUID petId) {
		final var userSession = (UserSession) session.getAttribute("user");
		System.out.println((UUID)session.getAttribute("cartId"));
		final var cart = new Cart(ucDao.getReference(userSession.getId()));
		final var item = new CartItem(cart, petDao.getReference(petId), 1);
		cartDao.create(cart);
		ciDao.update(item);
		session.setAttribute("cartId", cart.getId());
	}
}
