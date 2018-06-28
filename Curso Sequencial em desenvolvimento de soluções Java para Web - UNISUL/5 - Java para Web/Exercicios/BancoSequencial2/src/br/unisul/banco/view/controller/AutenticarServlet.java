package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.bo.UsuarioBo;

public class AutenticarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		UsuarioBean usuario = new UsuarioBean();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		UsuarioBean usuarioLogado = null;
		
		UsuarioBo usuarioBo = new UsuarioBo();
		
//		usuarioLogado = usuarioBo.verificarAuth(usuario);
		if (usuario.getLogin().equals("admin") && usuario.getSenha().equals("admin")) {
			usuarioLogado = new UsuarioBean();
			usuarioLogado.setNome("Usuario Teste");
			usuarioLogado.setEmail("teste@email.com.br");
			usuarioLogado.setTipo(1);
		}
		
		
		if(usuarioLogado != null){
			if(usuarioLogado.getTipo()==1){
				request.getSession().setAttribute("admin", "admin");
			}else{
				request.getSession().setAttribute("user", "user");
			}
			request.getSession().setAttribute("logado", usuarioLogado);
			response.sendRedirect("/sequencial/index.jsp");
		}else{
			response.sendRedirect("/sequencial/login.jsp?erro=Erro no login ou senha");
		}
		
		
		
		
		
	}
	
}
