package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bo.UsuarioBo;

public class ExcluirUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		UsuarioBo bo = new UsuarioBo();
		bo.excluirUsuario(id);
		
		response.sendRedirect("index.jsp?id=pesquisa-user");
	}
}
