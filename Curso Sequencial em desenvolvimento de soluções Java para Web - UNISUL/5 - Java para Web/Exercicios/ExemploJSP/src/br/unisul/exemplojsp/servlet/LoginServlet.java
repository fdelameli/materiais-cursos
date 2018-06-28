package br.unisul.exemplojsp.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if (login.equals("teste") && senha.equals("teste")) {
			response.sendRedirect("index.jsp?id=2");
		} else {
			response.sendRedirect("index.jsp?id=3");
		}
		
	}

}
