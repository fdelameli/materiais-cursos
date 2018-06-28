package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.CaminhaoBean;
import br.unisul.transportadora.bo.CaminhaoBo;

public class AlterarCaminhaoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {

		CaminhaoBo bo = new CaminhaoBo();
		CaminhaoBean camAtual = (CaminhaoBean)request.getSession().getAttribute("cam");
		CaminhaoBean cam = new CaminhaoBean();
		
		cam.setCodigo(camAtual.getCodigo());
		cam.setDescricao(request.getParameter("descricao"));
		
		bo.updateCaminhao(cam);
		
		response.sendRedirect("index.jsp?id=listar-caminhoes");
		
	}
}
