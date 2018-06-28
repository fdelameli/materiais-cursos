package br.unisul.banco.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.bo.ProdutoBo;

public class AdicionarCarrinhoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		List<ProdutoBean> carrinhoCompras = null;
		
		ProdutoBo bo = new ProdutoBo();
		Integer codigo = Integer.parseInt(request.getParameter("id"));
		ProdutoBean produto = bo.buscarProdutoPorCodigo(codigo);
		System.out.println(produto.getDescricao());
		
		if (carrinhoCompras == null) {
			carrinhoCompras = new ArrayList<ProdutoBean>();
			carrinhoCompras.add(produto);
			request.getSession().setAttribute("carrinhoCompras", carrinhoCompras);
		} else {
			carrinhoCompras.add(produto);
			request.getSession().setAttribute("carrinhoCompras", carrinhoCompras);
		}

		response.sendRedirect("index.jsp?id=lista-carrinho");
	
	}
}
