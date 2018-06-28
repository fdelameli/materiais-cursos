package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Impressao;
import com.br.lhmanager.controller.entitys.Promocao;
import com.br.lhmanager.model.dao.ImpressaoDAO;
import com.br.lhmanager.model.dao.PromocaoDAO;

public class PromocaoBo {

	PromocaoDAO dao = new PromocaoDAO();
	
	public String validaCadastro(Promocao p){
		if(p.getDescricao().trim().equals("")){
			return "Campo [DESCRIÇÃO] é obrigatório";
		}
		if(p.getDataInicio() == null){
			return "Campo [DATA DE INÍCIO] é obrigatório";
		}
		if(p.getDataFim() == null){
			return "Campo [DATA DE TÉRMINO] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Promocao p){
		String msg = validaCadastro(p);
		if(msg.equals("")){
			dao.inserir(p);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Promocao p){
		String msg = validaCadastro(p);
		if(msg.equals("")){
			dao.alterar(p);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Promocao p){
		dao.excluir(p);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<PromocaoEntity> listaTodasPromocoes(){
//		return dao.consultar();
//	}
		
	
	
}
