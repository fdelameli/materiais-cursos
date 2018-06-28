package com.br.lhmanager.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.br.lhmanager.controller.entitys.TipoDespesa;
import com.br.lhmanager.model.dao.TipoDespesaDAO;

public class TipoDespesaBo {

	TipoDespesaDAO dao = new TipoDespesaDAO();

	public String validaCadastro( TipoDespesa t ) {
		if ( t.getDescricao().trim().equals( "" ) ) {
			return "Campo [DESCRIÇÃO] é obrigatório";
		}
		return "";
	}

	public String inserir( TipoDespesa t ) {
		String msg = validaCadastro( t );
		if ( msg.equals( "" ) ) {
			dao.inserir( t );
			msg = "Cadastro Confirmado";
		}
		return msg;
	}

	public String alterar( TipoDespesa t ) {
		String msg = validaCadastro( t );
		if ( msg.equals( "" ) ) {
			dao.alterar( t );
			msg = "Alteração Confirmada";
		}
		return msg;
	}

	public String excluir( TipoDespesa t ) {
		dao.excluir( t );
		return "Exclusão confirmada";
	}

	public TipoDespesa findById( TipoDespesa t ) throws SQLException {
		return (TipoDespesa ) dao.findById( t );
	}

	@SuppressWarnings( "unchecked" )
	public ArrayList<TipoDespesa> consultar() throws SQLException {
		return dao.consultar();
	}


}
