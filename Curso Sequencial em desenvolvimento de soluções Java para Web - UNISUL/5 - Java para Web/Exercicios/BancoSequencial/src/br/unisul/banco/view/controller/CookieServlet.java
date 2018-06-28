package br.unisul.banco.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void processRequest(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		boolean cookieEncontrado = false;
		String valueOfCookie = "0";
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
		
			for (Cookie cookie : cookies) {
				Cookie c = cookie;
				
				if (c.getName().equals("exemploCookie")) {
					Integer value = Integer.parseInt(c.getValue());
					value++;
					c.setValue(String.valueOf(value));
					c.setMaxAge(360 * 24 * 60 * 60);
					valueOfCookie = c.getValue();
					cookieEncontrado  = true;
					response.addCookie(c);
				}
			}
		}
		
		if (!cookieEncontrado) {
			Cookie cookie = new Cookie("exemploCookie", "0");
			cookie.setMaxAge(365 * 24 * 60 * 60);
			response.addCookie(cookie);
		}
		
		PrintWriter out = response.getWriter();
		out.println("Valor do cookie: " + valueOfCookie);
		
	}

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		processRequest(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		processRequest(request, response);
	}
}
