package com.group12.petweb.controller.api;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group12.petweb.dao.CartDao;
import com.group12.petweb.dao.CartItemDao;
import com.group12.petweb.dao.PetDao;
import com.group12.petweb.dao.UserCredentialsDao;
import com.group12.petweb.model.Cart;
import com.group12.petweb.model.CartItem;
import com.group12.petweb.model.CartItemId;

public class CartApiController extends HttpServlet {
	private final CartDao cartDao;
	private final PetDao petDao;
	private final UserCredentialsDao uDao;
	private final CartItemDao ciDao;

	public CartApiController(CartDao cartDao, PetDao petDao, UserCredentialsDao uDao, CartItemDao ciDao) {
		this.cartDao = cartDao;
		this.petDao = petDao;
		this.uDao = uDao;
		this.ciDao = ciDao;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		final var user = uDao.findByEmail("duydang2412@gmail.com");
		final var pets = petDao.findSomeOffset(0, 3);
		final var cart = new Cart();
		final var item1 = new CartItem();
		final var item2 = new CartItem();
		final var item3 = new CartItem();
		final var items = new ArrayList<CartItem>();
		cart.setUser(user.get());
		System.out.println(cart);
		cartDao.create(cart);
		item1.setPet(pets[0]);
		item1.setQuantity(100);
		item1.setCart(cart);
		item1.setCartItemId(new CartItemId(){{
			setPetId(pets[0].getId());
			setCartId(cart.getId());
		}});
		item2.setPet(pets[1]);
		item2.setQuantity(300);
		item2.setCart(cart);
		item2.setCartItemId(new CartItemId(){{
			setPetId(pets[1].getId());
			setCartId(cart.getId());
		}});
		item3.setPet(pets[2]);
		item3.setQuantity(500);
		item3.setCart(cart);
		item3.setCartItemId(new CartItemId(){{
			setPetId(pets[2].getId());
			setCartId(cart.getId());
		}});
		items.add(item1);
		items.add(item2);
		items.add(item3);
		ciDao.update(item1);
		ciDao.update(item2);
		ciDao.update(item3);
		cart.setItems(items);
		System.out.println(cart);
		cartDao.update(cart);

		final var cart2 = cartDao.findById(cart.getId());
		System.out.println(cart2);
	}
}
