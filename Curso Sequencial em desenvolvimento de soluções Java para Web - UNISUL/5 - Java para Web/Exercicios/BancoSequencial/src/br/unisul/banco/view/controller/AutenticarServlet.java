package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.bo.UsuarioBo;

public class AutenticarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		UsuarioBean usuario = new UsuarioBean();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		
		UsuarioBean usuarioLogado = null;
		UsuarioBo bo = new UsuarioBo();
		
		usuarioLogado = bo.verificarAuth(usuario);
		
		if (usuarioLogado != null && usuarioLogado.getTipo().equals(2)) {
			request.getSession().setAttribute("logado", usuarioLogado);
			response.sendRedirect("cliente/cliente.jsp");
		} else if (usuarioLogado != null && usuarioLogado.getTipo().equals(1)) {
			request.getSession().setAttribute("logado", usuarioLogado);
			response.sendRedirect("administrador/administrador.jsp");
		} else {
			response.sendRedirect("erro.jsp");
		}
		
//		if (usuarioLogado != null) {
//			request.getSession().setAttribute("logado", usuarioLogado);
//			response.sendRedirect("sucesso.jsp");
//		} else {
//			response.sendRedirect("erro.jsp");
//		}
		
	}

}
