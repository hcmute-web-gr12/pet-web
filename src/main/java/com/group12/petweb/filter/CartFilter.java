package com.group12.petweb.filter;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.group12.petweb.dao.CartDao;
import com.group12.petweb.model.UserSession;

public class CartFilter implements Filter {
	private final CartDao cDao;

	public CartFilter(CartDao cDao) {
		this.cDao = cDao;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final var httpRequest = (HttpServletRequest) request;
		final var session = httpRequest.getSession(false);
		if (session == null || session.getAttribute("cartId") != null) {
			chain.doFilter(request, response);
			return;
		}
		final var userSession = (UserSession)session.getAttribute("user");
		if (userSession == null) {
			chain.doFilter(request, response);
			return;
		}
		final var optional = cDao.findByUserId(userSession.getId());
		if (optional.isEmpty()) {
			session.setAttribute("cartId", UUID.randomUUID());
		} else {
			session.setAttribute("cartId", optional.get().getId());
		}
		chain.doFilter(request, response);
	}
}
