package br.unisul.banco.view.controller.produto;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bo.ProdutoBo;

public class ExcluirProdutoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException{
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		
		ProdutoBo bo = new ProdutoBo();
		bo.excluirProduto(id);
		
		
		request.getSession().setAttribute("refresh", "now");
		request.getSession().setAttribute("result", "/sequencial/produto/pesquisaProduto.jsp");
		response.sendRedirect("/sequencial/index.jsp");
	}

}
