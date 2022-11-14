package com.group12.petweb.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Redirector {
	void redirect(HttpServletRequest request, HttpServletResponse response, String url, int seconds) throws ServletException, IOException;
	void redirect(HttpServletRequest request, HttpServletResponse response, String url, String title, int seconds) throws ServletException, IOException;
}

