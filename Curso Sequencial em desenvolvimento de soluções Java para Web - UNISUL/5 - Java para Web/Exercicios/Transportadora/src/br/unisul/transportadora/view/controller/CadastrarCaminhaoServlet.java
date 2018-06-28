package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.CaminhaoBean;
import br.unisul.transportadora.bo.CaminhaoBo;

public class CadastrarCaminhaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		CaminhaoBo bo = new CaminhaoBo();
		CaminhaoBean cam = new CaminhaoBean();
		
		if (!bo.getMaxValueFromCodigo().equals(null)) {
			cam.setCodigo(bo.getMaxValueFromCodigo()+1);
		} else {
			cam.setCodigo(1);
		}
		
		cam.setDescricao(request.getParameter("descricao"));
		
		bo.insertCaminhao(cam);
		
		response.sendRedirect("index.jsp?id=listar-caminhoes");
		
	}
	
}
