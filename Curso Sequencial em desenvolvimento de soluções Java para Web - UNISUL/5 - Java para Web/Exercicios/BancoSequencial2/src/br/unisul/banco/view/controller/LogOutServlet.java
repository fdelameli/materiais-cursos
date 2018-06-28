package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		
		
		if(request.getSession().getAttribute("logado")!=null){
			request.getSession().removeAttribute("logado");
			response.sendRedirect("/sequencial/login.jsp");
		}else{
			response.sendRedirect("/sequencial/login.jsp?erro=Você já fez logout!");
		}
		
		
		
		
		
	}
	
}
