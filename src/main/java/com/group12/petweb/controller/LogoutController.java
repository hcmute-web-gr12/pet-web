package com.group12.petweb.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.group12.petweb.service.Redirector;

public class LogoutController extends HttpServlet {
	private final Redirector redirector;

	public LogoutController(Redirector redirector) {
		this.redirector = redirector;
	}

	@Override()
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getSession().invalidate();
		redirector.redirect(request, response, "/", "Đăng xuất thành công!", 1);
	}
}
