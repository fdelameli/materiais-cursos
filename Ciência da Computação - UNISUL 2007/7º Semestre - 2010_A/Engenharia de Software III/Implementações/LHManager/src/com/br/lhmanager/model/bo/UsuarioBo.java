package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Promocao;
import com.br.lhmanager.controller.entitys.Usuario;
import com.br.lhmanager.model.dao.PromocaoDAO;
import com.br.lhmanager.model.dao.UsuarioDAO;

public class UsuarioBo {

	UsuarioDAO dao = new UsuarioDAO();
	
	public String validaCadastro(Usuario u){
		if(u.getNome().trim().equals("")){
			return "Campo [NOME] é obrigatório";
		}
		if(u.getTelefone().trim().equals("")){
			return "Campo [TELEFONE] é obrigatório";
		}
		if(u.getLogin().trim().length() < 4){
			return "Campo [LOGIN] necessita mínimo de 5 caracteres";
		}
		if(u.getSenha().trim().length() < 4){
			return "Campo [SENHA] necessita mínimo de 5 caracteres";
		}
		return "";
	}
	
	public String inserir(Usuario u){
		String msg = validaCadastro(u);
		if(msg.equals("")){
			dao.inserir(u);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Usuario u){
		String msg = validaCadastro(u);
		if(msg.equals("")){
			dao.alterar(u);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Usuario u){
		dao.excluir(u);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<UsuarioEntity> listaTodosUsuario(){
//		return dao.consultar();
//	}
		
	
}
