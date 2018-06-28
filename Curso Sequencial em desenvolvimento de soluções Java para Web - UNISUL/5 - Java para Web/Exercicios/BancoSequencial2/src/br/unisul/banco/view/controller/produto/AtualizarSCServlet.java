package br.unisul.banco.view.controller.produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.banco.bean.ProdutoBean;
import br.unisul.banco.bo.ProdutoBo;

public class AtualizarSCServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{



		Integer id = Integer.parseInt(request.getParameter("id"));

		ProdutoBo produtoBo = new ProdutoBo();

		List<ProdutoBean> sc = new ArrayList<ProdutoBean>();
		if(request.getParameter("acao")==null){
			if(request.getSession().getAttribute("ShoppingCart")!=null){
				sc = (List)request.getSession().getAttribute("ShoppingCart");
				sc.add(produtoBo.buscarProdutoPorCodigo(id));
				request.getSession().setAttribute("ShoppingCart",sc);
			}else{
				sc.add(produtoBo.buscarProdutoPorCodigo(id));
				request.getSession().setAttribute("ShoppingCart", sc);
			}
		}else{
			sc = (List)request.getSession().getAttribute("ShoppingCart");
//			for(int i = 0; i < sc.size(); i++){
//				if(sc.get(i).getCodigo()==id){
//					sc.remove(i);
//				}
//			}
			sc.remove(Integer.parseInt(request.getParameter("acao")));
			request.getSession().setAttribute("ShoppingCart", sc);
		}

		request.getSession().setAttribute("result", "/sequencial/produto/pesquisaProduto.jsp");
		request.getSession().setAttribute("sc", "/sequencial/produto/shoppingCart.jsp");
		response.sendRedirect("/sequencial/index.jsp");

	}

}



