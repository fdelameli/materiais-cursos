package com.br.lhmanager.model.bo;

import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.Impressao;
import com.br.lhmanager.controller.entitys.Produto;
import com.br.lhmanager.model.dao.ImpressaoDAO;
import com.br.lhmanager.model.dao.ProdutoDAO;

public class ProdutoBo {

	ProdutoDAO dao = new ProdutoDAO();
	
	public String validaCadastro(Produto p){
		if(p.getDescricao().trim().equals("")){
			return "Campo [DESCRIÇÃO] é obrigatório";
		}
		if(p.getValor() > 0.0){
			return "Campo [VALOR] é obrigatório";
		}
		return "";
	}
	
	public String inserir(Produto p){
		String msg = validaCadastro(p);
		if(msg.equals("")){
			dao.inserir(p);
			msg = "Cadastro Confirmado";
		}
		return msg;
	}
	
	public String alterar(Produto p){
		String msg = validaCadastro(p);
		if(msg.equals("")){
			dao.alterar(p);
			msg = "Alteração Confirmada";
		}
		return msg;
	}
	
	public String excluir(Produto p){
		dao.excluir(p);
		return "Exclusão confirmada";
	}
	
//	public ArrayList<ProdutoEntity> listaTodosProdutos(){
//		return dao.consultar();
//	}
		
	
}
