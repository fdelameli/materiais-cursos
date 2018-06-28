//package com.br.lhmanager.model.bo;
//
//import java.util.ArrayList;
//
//import com.br.lhmanager.controller.entitys.Despesa;
//import com.br.lhmanager.controller.entitys.Impressao;
//import com.br.lhmanager.model.dao.DespesaDAO;
//import com.br.lhmanager.model.dao.ImpressaoDAO;
//
//public class ImpressaoBo {
//
//	ImpressaoDAO dao = new ImpressaoDAO();
//	
//	public String validaCadastro(Impressao i){
//		if(i.getDescricao().trim().equals("")){
//			return "Campo [DESCRIÇÃO] é obrigatório";
//		}
//		if(i.getQtdPaginas() > 0){
//			return "Campo [QUANTIDADE DE PÁGINAS] é obrigatório";
//		}
//		if(i.getValorUnit() > 0.0){
//			return "Campo [VALOR UNITÁRIO] é obrigatório";
//		}
//		return "";
//	}
//	
//	public String inserir(Impressao i){
//		String msg = validaCadastro(i);
//		if(msg.equals("")){
//			dao.inserir(i);
//			msg = "Cadastro Confirmado";
//		}
//		return msg;
//	}
//	
//	public String alterar(Impressao i){
//		String msg = validaCadastro(i);
//		if(msg.equals("")){
//			dao.alterar(i);
//			msg = "Alteração Confirmada";
//		}
//		return msg;
//	}
//	
//	public String excluir(Impressao i){
//		dao.excluir(i);
//		return "Exclusão confirmada";
//	}
//	
////	public ArrayList<ImpressaoEntity> listaTodasImpressoes(){
////		return dao.consultar();
////	}
//		
//	
//}
