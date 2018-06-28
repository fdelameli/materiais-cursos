package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Impressao;
import com.br.lhmanager.controller.entitys.Log;
import com.br.lhmanager.model.dao.ImpressaoDAO;
import com.br.lhmanager.model.dao.LogDAO;

public class LogBo {

	LogDAO dao = new LogDAO();
	
	public String validaCadastro(Log l){
		if(l.getDescricao().trim().equals("")){
			return "Campo [DESCRIÇÃO] é obrigatório";
		}
		if(l.getTerminal() == null){
			return "Campo [TERMINAL] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Log l){
		String msg = validaCadastro(l);
		if(msg.equals("")){
			dao.inserir(l);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Log l){
		String msg = validaCadastro(l);
		if(msg.equals("")){
			dao.alterar(l);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Log l){
		dao.excluir(l);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<LogEntity> listaTodosLogs(){
//		return dao.consultar();
//	}
		
	
}
