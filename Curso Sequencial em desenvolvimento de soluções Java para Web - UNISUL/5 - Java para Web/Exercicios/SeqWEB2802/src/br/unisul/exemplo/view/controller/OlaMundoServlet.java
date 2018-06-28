package br.unisul.exemplo.view.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OlaMundoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PrintWriter print = response.getWriter();
		print.println("<HTML>");
		print.println("<HEAD>");
		print.println("<TITLE>Olá Mundo</TITLE>");
		print.println("</HEAD>");
		print.println("<BODY>");
		print.println("<H1>Olá Mundo</H1>");
		print.println("</BODY>");
		print.println("</HTML>");

	}
	
	

}
