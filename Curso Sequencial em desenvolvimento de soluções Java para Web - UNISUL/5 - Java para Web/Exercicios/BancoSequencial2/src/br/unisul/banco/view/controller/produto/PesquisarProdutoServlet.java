package br.unisul.banco.view.controller.produto;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.bo.ProdutoBo;

public class PesquisarProdutoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		ProdutoBean produto = new ProdutoBean();
		
		if(!request.getParameter("codigo").equals(""))
			produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		else
			produto.setCodigo(-1);
		
		produto.setNome(request.getParameter("nome"));
		
		if(!request.getParameter("preco").equals("")){
			produto.setPreco(Double.parseDouble(request.getParameter("preco")));
		}else{
			produto.setPreco(-1.0);
		}
		
			
		ProdutoBo bo = new ProdutoBo();
		request.getSession().setAttribute("listaProduto",bo.pesquisarProduto(produto));
		request.getSession().setAttribute("refresh", "normal");
		request.getSession().setAttribute("result", "/sequencial/produto/pesquisaProduto.jsp");
		response.sendRedirect("/sequencial/index.jsp");
	}

}




