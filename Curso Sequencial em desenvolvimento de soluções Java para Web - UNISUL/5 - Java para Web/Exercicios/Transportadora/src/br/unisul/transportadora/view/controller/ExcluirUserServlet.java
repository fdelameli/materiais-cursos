package br.unisul.transportadora.view.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bo.UsuarioBo;

public class ExcluirUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		Integer codigo = Integer.parseInt(request.getParameter("id"));
		UsuarioBo bo = new UsuarioBo();
		
		try {
			
			bo.deleteUsuario(codigo);
			response.sendRedirect("index.jsp?listar-users");
			
		} catch (SQLException e) {
			response.sendRedirect("index.jsp?id=erro-sql&msg="+e);
		}
		
	}
	
}
