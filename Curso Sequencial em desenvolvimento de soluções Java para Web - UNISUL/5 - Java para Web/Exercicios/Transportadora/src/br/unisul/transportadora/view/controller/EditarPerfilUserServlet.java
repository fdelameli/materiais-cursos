package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.bo.UsuarioBo;

public class EditarPerfilUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		UsuarioBean usuarioLogado = (UsuarioBean)request.getSession().getAttribute("logado");
		UsuarioBean usuario = new UsuarioBean();
		
		usuario.setCodigo(usuarioLogado.getCodigo());
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setCidade(request.getParameter("cidade"));
		usuario.setUf(request.getParameter("uf"));
		usuario.setTipo(usuarioLogado.getTipo());
		
		UsuarioBo bo = new UsuarioBo();
		bo.updateUsuario(usuario);
		
		request.getSession().setAttribute("logado", usuario);
		
		response.sendRedirect("index.jsp?id=update-perfil-user");
		
	}
}
