package br.unisul.banco.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.bo.ProdutoBo;

public class CadastrarProdutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		ProdutoBean produto = new ProdutoBean();
		
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setGenero(request.getParameter("genero"));
		produto.setValor(Double.parseDouble(request.getParameter("valor")));
		
		ProdutoBo bo = new ProdutoBo();
		
		if (bo.insertProduto(produto)) {
			response.sendRedirect("index.jsp?id=sucesso-cad");
		} else {
			response.sendRedirect("index.jsp?id=falha-cad");
		}
		
		
		
	}
	
	
}

