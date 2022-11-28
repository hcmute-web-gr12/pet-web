package com.group12.petweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.group12.petweb.service.Redirector;

public class AuthorizationFilter implements Filter {
	private final Redirector redirector;

	public AuthorizationFilter(Redirector redirector) {
		this.redirector = redirector;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final var httpRequest = (HttpServletRequest) request;
		final var httpResponse = (HttpServletResponse) response;
		final var session = httpRequest.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
			if (httpRequest.getServletPath().indexOf("api") != -1) {
				httpResponse.getWriter().print(HttpServletResponse.SC_FORBIDDEN);
			} else {
				redirector.redirect(httpRequest, httpResponse, "/login", "Xin vui lòng đăng nhập.", 1);
			}
			return;
		}
		chain.doFilter(request, response);
	}
}
