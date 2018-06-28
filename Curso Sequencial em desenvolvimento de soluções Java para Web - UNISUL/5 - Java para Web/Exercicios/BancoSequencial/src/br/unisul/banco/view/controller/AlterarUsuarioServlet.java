package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.bo.UsuarioBo;

public class AlterarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		UsuarioBean usuario = new UsuarioBean();
		
		usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setTipo(Integer.parseInt(request.getParameter("tipo")));
		
		UsuarioBo bo = new UsuarioBo();
		bo.alterarUsuario(usuario);
		
		response.sendRedirect("index.jsp?id=pesquisa-user");
	}
	
	
}
