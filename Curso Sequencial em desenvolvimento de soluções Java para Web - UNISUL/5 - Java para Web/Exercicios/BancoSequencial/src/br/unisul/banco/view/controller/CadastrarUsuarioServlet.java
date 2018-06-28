package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.bo.UsuarioBo;

public class CadastrarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		UsuarioBean usuario = new UsuarioBean();
		
		if (!request.getParameter("codigo").equals("")) {
			usuario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		} else {
			usuario.setCodigo(null);
		}
		usuario.setNome(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEmail(request.getParameter("email"));
		
		if (!request.getParameter("tipo").equals("")) {
			usuario.setTipo(Integer.parseInt(request.getParameter("tipo")));
		} else {
			usuario.setTipo(null);
		}
		UsuarioBo bo = new UsuarioBo();
		
		if (bo.insertUsuario(usuario)) {
			response.sendRedirect("index.jsp?id=sucesso-cad");
		} else {
			response.sendRedirect("index.jsp?id=falha-cad");
		}
		
		
		
	}
	
}
