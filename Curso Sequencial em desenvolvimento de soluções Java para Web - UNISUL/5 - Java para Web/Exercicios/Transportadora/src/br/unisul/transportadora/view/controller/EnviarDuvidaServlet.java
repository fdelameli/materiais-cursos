package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.DuvidaBean;
import br.unisul.transportadora.bo.DuvidaBo;

public class EnviarDuvidaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		DuvidaBean duvida = new DuvidaBean();
		DuvidaBo bo = new DuvidaBo();
		
		
		if (!bo.getMaxValueFromCodigo().equals(null)) {
			duvida.setCodigo(bo.getMaxValueFromCodigo()+1);
		} else {
			duvida.setCodigo(1);
		}
		
		duvida.setNome(request.getParameter("nome"));
		duvida.setEmail(request.getParameter("email"));
		duvida.setEmpresa(request.getParameter("empresa"));
		duvida.setDdd(request.getParameter("ddd"));
		duvida.setFone(request.getParameter("telefone"));
		
		if (request.getParameter("assunto").equals("comercial")) {
			duvida.setAssunto("Comercial");
		} else if (request.getParameter("assunto").equals("tecnico")) {
			duvida.setAssunto("Técnico");
		} else if (request.getParameter("assunto").equals("social")) {
			duvida.setAssunto("Social");
		} else if (request.getParameter("assunto").equals("outros")) {
			duvida.setAssunto("Outros");
		}
		
		duvida.setMenssagem(request.getParameter("mensagem"));
		
		bo.insertDuvida(duvida);
		
		response.sendRedirect("index.jsp?id=sucesso");
		
	}
}
