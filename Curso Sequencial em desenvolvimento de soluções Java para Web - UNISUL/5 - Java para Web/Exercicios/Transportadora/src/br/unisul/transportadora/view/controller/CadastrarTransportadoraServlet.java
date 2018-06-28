package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.TransportadoraBean;
import br.unisul.transportadora.bo.TransportadoraBo;

public class CadastrarTransportadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		TransportadoraBo bo = new TransportadoraBo();
		TransportadoraBean transp = new TransportadoraBean();
		
		if (!bo.getMaxValueFromCodigo().equals(null)) {
			transp.setCodigo(bo.getMaxValueFromCodigo()+1);
		} else {
			transp.setCodigo(1);
		}
		
		transp.setNome(request.getParameter("nome"));
		
		bo.insertTransportadora(transp);
		
		response.sendRedirect("index.jsp?id=listar-transp");
		
	}
	
}
