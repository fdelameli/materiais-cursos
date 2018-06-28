package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Campeonato;
import com.br.lhmanager.controller.entitys.Credito;
import com.br.lhmanager.model.dao.CampeonatoDAO;
import com.br.lhmanager.model.dao.CreditoDAO;

public class CreditoBo {

	CreditoDAO dao = new CreditoDAO();
	
	public String validaCadastro(Credito c){
		if(c.getValor() > 0.0){
			return "Campo [VALOR] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Credito c){
		String msg = validaCadastro(c);
		if(msg.equals("")){
			dao.inserir(c);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Credito c){
		String msg = validaCadastro(c);
		if(msg.equals("")){
			dao.alterar(c);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Credito c){
		dao.excluir(c);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<CreditoEntity> listaTodosCreditos(){
//		return dao.consultar();
//	}
	
}
