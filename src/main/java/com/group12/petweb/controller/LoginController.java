package com.group12.petweb.controller;

import jakarta.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginController extends HttpServlet {
    private final EntityManagerFactory factory;
    public LoginController(EntityManagerFactory sessionFactory) {
        this.factory = sessionFactory;
    }
    @Override()
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
        dispatcher.forward(request, response);
    }
    @Override()
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");

        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((key, value) -> {
            if (key.equalsIgnoreCase("password")) {
                return;
            }
            request.setAttribute(key, value[0]);
        });
        dispatcher.forward(request, response);
    }
}