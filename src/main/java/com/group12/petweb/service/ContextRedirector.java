package com.group12.petweb.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextRedirector implements Redirector {
	public void redirect(HttpServletRequest request, HttpServletResponse response, String url, int seconds)
			throws ServletException, IOException {
		redirect(request, response, url, null, seconds);
	}

	public void redirect(HttpServletRequest request, HttpServletResponse response, String url, String title,
			int seconds) throws ServletException, IOException {
		final var urlBuffer = request.getRequestURL();
		final var uri = request.getRequestURI();
		final var index = urlBuffer.indexOf(uri, urlBuffer.length() - uri.length());
		final var completeUrl = urlBuffer.delete(index, index + uri.length()) + request.getContextPath() + url;
		request.setAttribute("title", title);
		request.setAttribute("url", completeUrl);
		request.setAttribute("timeout", seconds);
		request.getRequestDispatcher("/WEB-INF/views/Redirect.jsp").forward(request, response);
	}
}
