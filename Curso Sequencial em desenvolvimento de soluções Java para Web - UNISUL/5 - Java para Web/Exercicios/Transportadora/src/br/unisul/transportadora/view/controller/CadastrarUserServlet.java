package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.bo.UsuarioBo;

public class CadastrarUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		UsuarioBean usuario = new UsuarioBean();
		UsuarioBo bo = new UsuarioBo();
		
		if (!bo.getMaxValueFromCodigo().equals(null)) {
			usuario.setCodigo(bo.getMaxValueFromCodigo()+1);
		} else {
			usuario.setCodigo(1);
		}
		
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setCidade(request.getParameter("cidade"));
		usuario.setUf(request.getParameter("uf"));
		
		if (request.getParameter("tipo").equals("cliente")) {
			usuario.setTipo(1);
		} else if (request.getParameter("tipo").equals("admin")) {
			usuario.setTipo(2);
		}
		
		bo.insertUsuario(usuario);
		
		response.sendRedirect("index.jsp?id=sucesso-cad");

	}
	
}
