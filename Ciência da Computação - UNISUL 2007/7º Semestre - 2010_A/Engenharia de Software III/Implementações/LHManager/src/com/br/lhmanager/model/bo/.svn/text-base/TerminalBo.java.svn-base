package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Promocao;
import com.br.lhmanager.controller.entitys.Terminal;
import com.br.lhmanager.model.dao.PromocaoDAO;
import com.br.lhmanager.model.dao.TerminalDAO;

public class TerminalBo {

	TerminalDAO dao = new TerminalDAO();
	
	public String validaCadastro(Terminal t){
		if(t.getDescricao().trim().equals("")){
			return "Campo [DESCRIÇÃO] é obrigatório";
		}
		if(t.getIp().trim().equals("")){
			return "Campo [IP] é obrigatório";
		}
		if(t.getMacAddress().trim().equals("")){
			return "Campo [MAC ADDRESS] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Terminal t){
		String msg = validaCadastro(t);
		if(msg.equals("")){
			dao.inserir(t);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Terminal t){
		String msg = validaCadastro(t);
		if(msg.equals("")){
			dao.alterar(t);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Terminal t){
		dao.excluir(t);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<TerminalEntity> listaTodosTerminais(){
//		return dao.consultar();
//	}
		
	
}
