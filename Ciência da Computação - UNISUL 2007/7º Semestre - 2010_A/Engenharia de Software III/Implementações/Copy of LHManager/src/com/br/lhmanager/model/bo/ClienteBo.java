package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Cliente;
import com.br.lhmanager.model.dao.CampeonatoDAO;

public class ClienteBo {

	CampeonatoDAO dao = new CampeonatoDAO();
	
	public String validaCadastro(Cliente c){
		if(c.getCpf().trim().equals("")){
			return "Campo [CPF] é obrigatório";
		}
		if(c.getNome().trim().equals("")){
			return "Campo [NOME] é obrigatório";
		}
		if(c.getTelefone().trim().equals("")){
			return "Campo [TELEFONE] é obrigatório";
		}
		if(c.getEmail().trim().equals("")){
			return "Campo [EMAIL] é obrigatório";
		}
		if(c.getEndereco().trim().equals("")){
			return "Campo [ENDEREÇO] é obrigatório";
		}
		if(c.getNascimento() == null){
			return "Campo [DATA DE NASCIMENTO] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Cliente c){
		String msg = validaCadastro(c);
		if(msg.equals("")){
			dao.inserir(c);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Cliente c){
		String msg = validaCadastro(c);
		if(msg.equals("")){
			dao.alterar(c);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Cliente c){
		dao.excluir(c);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<ClienteEntity> listaTodosClientes(){
//		return dao.consultar();
//	}
	
}
