package br.unisul.projeto.view.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.projeto.core.entity.UsuarioEntity;

public class AcessoFiltro implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		//Verifica se tem alguem logado
		UsuarioEntity usuarioLogado = (UsuarioEntity)((HttpServletRequest)request)
										.getSession().getAttribute("usuarioLogado");
		
		//Se nao tiver ninguem logado manda pra tela de login
		if(usuarioLogado == null){
			((HttpServletResponse)response).sendRedirect(
					((HttpServletRequest)request)
						.getServletContext()
						.getContextPath() + "/login.xhtml");
		}else{
			//Tem gente logada, deixa seguir o fluxo
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
