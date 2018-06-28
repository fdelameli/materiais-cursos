package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.bo.UsuarioBo;

public class PesquisarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		UsuarioBean usuario = new UsuarioBean();
		
		if (!request.getParameter("codigo").equals("")) {
			usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		} else {
			usuario.setCodigo(-1);
		}
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEmail(request.getParameter("email"));
		
		UsuarioBo bo = new UsuarioBo();
		
		request.getSession().setAttribute("lista", bo.pesquisarUsuario(usuario));
		
		response.sendRedirect("index.jsp?id=pesquisa-esp-user");
		
	}
	
}
