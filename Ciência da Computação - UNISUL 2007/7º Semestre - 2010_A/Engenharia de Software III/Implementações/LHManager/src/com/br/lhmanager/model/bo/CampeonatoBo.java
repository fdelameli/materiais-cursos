package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Atendimento;
import com.br.lhmanager.controller.entitys.Campeonato;
import com.br.lhmanager.model.dao.AtendimentoDAO;
import com.br.lhmanager.model.dao.CampeonatoDAO;

public class CampeonatoBo {

	CampeonatoDAO dao = new CampeonatoDAO();
	
	public String validaCadastro(Campeonato c){
		if(c.getData() == null){
			return "Campo [DATA] é obrigatório";
		}
		if(c.getDescricao().trim().equals("")){
			return "Campo [DESCRIÇÃO] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Campeonato c){
		String msg = validaCadastro(c);
		if(msg.equals("")){
			dao.inserir(c);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Campeonato c){
		String msg = validaCadastro(c);
		if(msg.equals("")){
			dao.alterar(c);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Campeonato c){
		dao.excluir(c);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<CampeonatoEntity> listaTodosCampeonatos(){
//		return dao.consultar();
//	}
	
}
