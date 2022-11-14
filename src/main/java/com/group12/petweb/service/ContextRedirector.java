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
		final var completeUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "")
				+ request.getContextPath() + url;
		request.setAttribute("title", title);
		request.setAttribute("url", completeUrl);
		request.setAttribute("timeout", seconds);
		request.getRequestDispatcher("/WEB-INF/views/Redirect.jsp").forward(request, response);
	}
}
