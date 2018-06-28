package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.bo.FreteBo;

public class ExcluirFreteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		UsuarioBean user = (UsuarioBean)request.getSession().getAttribute("logado");
		
		FreteBo bo = new FreteBo();
		bo.deleteFrete(id);
		
		if (user.getTipo().equals(1)) {
			response.sendRedirect("index.jsp?id=meus-fretes");
		} else if (user.getTipo().equals(2)) {
			response.sendRedirect("index.jsp?id=listar-fretes");
		}
		
		
		
	}
}
