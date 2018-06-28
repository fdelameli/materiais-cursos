package br.unisul.banco.view.controller.produto;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.bo.ProdutoBo;

public class AlterarProdutoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		ProdutoBean produto = new ProdutoBean();
		
		produto.setCodigo(Integer.parseInt(
				request.getParameter("codigo")));
		produto.setNome(request.getParameter("nome"));
		produto.setPreco(Double.parseDouble(request.getParameter("preco")));
		produto.setTipo(Integer.parseInt(request.getParameter("tipo")));
		
		ProdutoBo bo = new ProdutoBo();
		bo.alterarProduto(produto);
		
		request.getSession().setAttribute("refresh", "now");
		request.getSession().setAttribute("result", "/sequencial/produto/pesquisaProduto.jsp");
		response.sendRedirect("/sequencial/index.jsp");
		
	}
	
}
