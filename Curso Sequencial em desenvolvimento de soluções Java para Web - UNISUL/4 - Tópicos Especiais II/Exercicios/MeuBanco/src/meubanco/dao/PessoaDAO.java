package meubanco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import meubanco.domain.Pessoa;
import framework.dao.DaoBase;

public class PessoaDAO extends DaoBase {
	
	
	/**
	 * Construtor defautl.
	 */
	public PessoaDAO() throws Exception {
		super();
	}
	
	

	@Override
	protected String getTableName() {
		return "PESSOA";
	}


	@Override
	protected Object populaDomainBase(ResultSet rs) throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setCdPessoa(rs.getInt("CDPESSOA"));
		pessoa.setNmPessoa(rs.getString("NMPESSOA"));
		return pessoa;
	}
	

	@Override
	protected void populaPrimaryKeyStatement(PreparedStatement stm, Object obj) throws Exception {
		Pessoa pessoa = (Pessoa) obj;
		stm.setInt(1, pessoa.getCdPessoa());
	}
	

	@Override
	protected String getJoins() {
		return "";
	}


	@Override
	protected String getWhereByExample(Object obj) {
		Pessoa pessoa = (Pessoa) obj;
		StringBuilder sqlWhere = new StringBuilder();
		sqlWhere.append(" 1=1 ");
		
		if (pessoa.getCdPessoa() != null) {
			sqlWhere.append(" AND CDPESSOA = " + pessoa.getCdPessoa());
		}
		if (pessoa.getNmPessoa() != null) {
			sqlWhere.append(" AND NMPESSOA LIKE '%" + pessoa.getNmPessoa() + "%' ");
		}
		return sqlWhere.toString();
	}

	
	@Override
	protected String getColumnsWithoutPrimaryKey() {
		return " NMPESSOA";
	}
	
	@Override
	protected String getPrimaryKeyColumn() {
		return " CDPESSOA";
	}
	
	@Override
	protected void populaObjectStatment(PreparedStatement stm, Object obj) throws Exception {
		Pessoa p = (Pessoa) obj;
		stm.setString(1, p.getNmPessoa());
		stm.setInt(2, p.getCdPessoa());
	}



	@Override
	protected String getWherePrimaryKey() {
		return null;
	}

	
}
