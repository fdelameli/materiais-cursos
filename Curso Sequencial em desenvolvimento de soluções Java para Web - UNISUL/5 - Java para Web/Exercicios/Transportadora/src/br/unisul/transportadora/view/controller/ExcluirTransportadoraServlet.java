package br.unisul.transportadora.view.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bo.TransportadoraBo;

public class ExcluirTransportadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		Integer codigo = Integer.parseInt(request.getParameter("id"));
		TransportadoraBo bo = new TransportadoraBo();
		
		try {
			bo.deleteTransportadora(codigo);
			response.sendRedirect("index.jsp?id=listar-transp");
		} catch (SQLException e) {
			response.sendRedirect("index.jsp?id=erro-sql&msg="+e);
		}
		
	}
	
}
