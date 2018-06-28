package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.CaminhaoBean;
import br.unisul.transportadora.bean.FreteBean;
import br.unisul.transportadora.bean.TransportadoraBean;
import br.unisul.transportadora.bo.CaminhaoBo;
import br.unisul.transportadora.bo.FreteBo;
import br.unisul.transportadora.bo.TransportadoraBo;

public class AlterarFreteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		FreteBean freteAtual = (FreteBean)request.getSession().getAttribute("frete");
		FreteBean freteAlterado = new FreteBean();
		
		freteAlterado.setCodigo(freteAtual.getCodigo());
		freteAlterado.setQuilometragem(Double.parseDouble(request.getParameter("km")));
		freteAlterado.setValor((Double.parseDouble(request.getParameter("km")))*2);
		freteAlterado.setCodigoCliente(freteAtual.getCodigoCliente());
		
		Integer codTransp = Integer.parseInt(request.getParameter("transportadora"));
		TransportadoraBo transpBo = new TransportadoraBo();
		TransportadoraBean transp = transpBo.findById(codTransp);
		freteAlterado.setCodigoTransportadora(transp.getCodigo());
		
		Integer codCam = Integer.parseInt(request.getParameter("caminhao"));
		CaminhaoBo camBo = new CaminhaoBo();
		CaminhaoBean cam = camBo.findById(codCam);
		freteAlterado.setCodigoCaminhao(cam.getCodigo());
		
		FreteBo bo = new FreteBo();
		bo.updateFrete(freteAlterado);
		
		response.sendRedirect("index.jsp?id=meus-fretes");
		
	}
}
