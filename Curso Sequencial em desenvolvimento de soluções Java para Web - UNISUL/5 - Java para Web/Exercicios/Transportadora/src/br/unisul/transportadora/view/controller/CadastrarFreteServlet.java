package br.unisul.transportadora.view.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unisul.transportadora.bean.CaminhaoBean;
import br.unisul.transportadora.bean.FreteBean;
import br.unisul.transportadora.bean.TransportadoraBean;
import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.bo.CaminhaoBo;
import br.unisul.transportadora.bo.FreteBo;
import br.unisul.transportadora.bo.TransportadoraBo;

public class CadastrarFreteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		FreteBean frete = new FreteBean();
		FreteBo bo = new FreteBo();
		
		UsuarioBean user = (UsuarioBean)request.getSession().getAttribute("logado");
		
		frete.setCodigo(bo.getMaxValueFromCodigo()+1);
		frete.setQuilometragem(Double.parseDouble(request.getParameter("km")));
		frete.setValor(Double.parseDouble(request.getParameter("km"))*2);
		frete.setCodigoCliente(user.getCodigo());
		
		Integer codTransp = Integer.parseInt(request.getParameter("transportadora"));
		TransportadoraBo transpBo = new TransportadoraBo();
		TransportadoraBean transp = transpBo.findById(codTransp);
		frete.setCodigoTransportadora(transp.getCodigo());
		
		Integer codCam = Integer.parseInt(request.getParameter("caminhao"));
		CaminhaoBo camBo = new CaminhaoBo();
		CaminhaoBean cam = camBo.findById(codCam);
		frete.setCodigoCaminhao(cam.getCodigo());
		
		bo.insertFrete(frete);
		
		response.sendRedirect("index.jsp?id=meus-fretes");
		
	}
	
}
