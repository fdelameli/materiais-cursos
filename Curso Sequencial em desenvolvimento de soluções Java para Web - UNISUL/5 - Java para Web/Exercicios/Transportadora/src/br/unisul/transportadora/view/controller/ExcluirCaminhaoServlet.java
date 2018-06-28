package br.unisul.transportadora.view.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bo.CaminhaoBo;

public class ExcluirCaminhaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
	
		Integer codigo = Integer.parseInt(request.getParameter("id"));
		CaminhaoBo bo = new CaminhaoBo();
		
		try {
			
			bo.deleteCaminhao(codigo);
			response.sendRedirect("index.jsp?id=listar-caminhoes");
			
		} catch (SQLException e) {
			response.sendRedirect("index.jsp?id=erro-sql&msg="+e);
		}
	
	}
	
}
