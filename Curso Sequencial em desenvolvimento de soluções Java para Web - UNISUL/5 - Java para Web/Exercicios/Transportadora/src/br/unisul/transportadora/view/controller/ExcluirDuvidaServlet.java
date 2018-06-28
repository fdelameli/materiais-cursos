package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bo.DuvidaBo;

public class ExcluirDuvidaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		Integer codigo = Integer.parseInt(request.getParameter("id"));
		
		DuvidaBo bo = new DuvidaBo();
		bo.deleteDuvida(codigo);
		
		response.sendRedirect("index.jsp?id=duvidas");
		
	}
	
}
