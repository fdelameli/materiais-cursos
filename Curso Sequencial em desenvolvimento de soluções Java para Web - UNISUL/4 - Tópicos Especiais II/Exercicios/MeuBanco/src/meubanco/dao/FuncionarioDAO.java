package meubanco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import meubanco.domain.Funcionario;
import meubanco.domain.Pessoa;

import framework.dao.DaoBase;

public class FuncionarioDAO extends DaoBase {
	

	public FuncionarioDAO() throws Exception {
		
	}

	
	
	@Override
	protected String getTableName() {
		return "FUNCIONARIO F";
	}

	@Override
	protected String getWherePrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object populaDomainBase(ResultSet rs) throws Exception {
		Funcionario func = new Funcionario();
		func.setCdFuncionario( rs.getInt("CDFUNCIONARIO"));
		func.setSalario( rs.getDouble("VLSALARIO"));
		func.setCdPessoa( rs.getInt("CDPESSOA"));
		
		func.setPessoa(new Pessoa());
		func.getPessoa().setNmPessoa( rs.getString("NMPESSOA"));
		
		return func;
	}

	@Override
	protected void populaPrimaryKeyStatement(PreparedStatement stm, Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected String getJoins() {
		return "JOIN PESSOA P ON P.CDPESSOA = F.CDPESSOA";
	}



	@Override
	protected String getWhereByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected String getColumnsWithoutPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected String getPrimaryKeyColumn() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected void populaObjectStatment(PreparedStatement stm, Object obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
