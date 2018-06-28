package com.br.lhmanager.model.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.br.lhmanager.controller.entitys.Atendimento;
import com.br.lhmanager.model.dao.AtendimentoDAO;

public class AtendimentoBo {

	AtendimentoDAO dao = new AtendimentoDAO();
	
	public String validaCadastro(Atendimento a){
		if(a.getCliente() == null){
			return "Campo [CLIENTE] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Atendimento a){
		String msg = validaCadastro(a);
		if(msg.equals("")){
			dao.inserir(a);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Atendimento a){
		String msg = validaCadastro(a);
		if(msg.equals("")){
			dao.alterar(a);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Atendimento a){
		dao.excluir(a);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<AtendimentoEntity> listaTodosAtendimentos(){
//		return dao.consultar();
//	}
	
}
