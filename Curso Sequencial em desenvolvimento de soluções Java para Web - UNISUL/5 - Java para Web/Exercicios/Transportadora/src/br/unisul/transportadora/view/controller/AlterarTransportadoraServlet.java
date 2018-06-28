package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.TransportadoraBean;
import br.unisul.transportadora.bo.TransportadoraBo;

public class AlterarTransportadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		TransportadoraBo bo = new TransportadoraBo();
		TransportadoraBean transpAtual = (TransportadoraBean) request.getSession().getAttribute("transp");
		TransportadoraBean transp = new TransportadoraBean();
		
		transp.setCodigo(transpAtual.getCodigo());
		transp.setNome(request.getParameter("nome"));
		
		bo.updateTransportadora(transp);
		
		response.sendRedirect("index.jsp?id=listar-transp");
		
	}
	
}
