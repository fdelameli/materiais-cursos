package revenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import revenda.domain.Login;

import framework.dao.DaoBase;

public class LoginDAO extends DaoBase {

	public LoginDAO() throws Exception {
		super();
	}

	@Override
	protected String getColumnsWithoutPrimaryKey() {
		return "LOGIN,SENHA";
	}

	@Override
	protected String getJoins() {
		return "";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		return "";
	}

	@Override
	protected String getTableName() {
		return "LOGIN";
	}

	@Override
	protected String getWhereByExample(int cd, String ds) {
		return "";
	}

	@Override
	protected String getWherePrimaryKey() {
		return "";
	}

	@Override
	protected Object populaDomainBase(ResultSet rs) throws Exception {
		Login l = new Login();
		
		l.setLogin( rs.getString("LOGIN"));
		l.setSenha( rs.getString("SENHA"));
		
		return l;
	}

	@Override
	protected void populaObjectStatment(PreparedStatement stm, Object obj) throws Exception {
		Login l = (Login) obj;
		
		stm.setString(1, l.getSenha());
		stm.setString(2, l.getLogin());

	}

	@Override
	protected void populaPrimaryKeyStatement(PreparedStatement stm, Object obj)
			throws Exception {
	}

	@Override
	protected List sqlPersolizable(Connection con) throws Exception {
		return null;
	}

}
