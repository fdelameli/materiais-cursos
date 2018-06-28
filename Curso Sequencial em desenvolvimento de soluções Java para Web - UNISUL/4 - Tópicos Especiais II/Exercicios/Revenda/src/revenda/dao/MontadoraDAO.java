package revenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import revenda.domain.Montadora;
import framework.dao.DaoBase;

/**
 * Classe responsável por gravar em banco
 * as informações de cada montadora.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/10/2008.
 */
public class MontadoraDAO extends DaoBase {

	
	public MontadoraDAO() throws Exception {
		super();
	}
	
	
	@Override
	protected String getColumnsWithoutPrimaryKey() {
		return "DSMONTADORA";
	}

	@Override
	protected String getJoins() {
		return "";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		return "CDMONTADORA";
	}

	@Override
	protected String getTableName() {
		return "MONTADORA";
	}

	@Override
	protected String getWhereByExample(int cd, String ds) {
		StringBuilder string = new StringBuilder();
		string.append("1=1");
		
		if ( cd > 0 ) {
			string.append(" AND CDMONTADORA = " + cd);
		}
		if (!ds.equals("")){
			string.append(" AND DSMONTADORA LIKE '%" + ds + "%'");
		}
		
		return string.toString();
	}
	

	@Override
	protected String getWherePrimaryKey() {
		return "";
	}

	@Override
	protected Object populaDomainBase(ResultSet rs) throws Exception {
		Montadora m = new Montadora();
		m.setCdMontadora( rs.getInt("CDMONTADORA"));
		m.setDsMontadora( rs.getString("DSMONTADORA"));
		return m;
	}

	@Override
	protected void populaObjectStatment(PreparedStatement stm, Object obj) throws Exception {
		Montadora m = (Montadora) obj;
		stm.setString(1, m.getDsMontadora());
		stm.setInt(2, m.getCdMontadora());
	}

	@Override
	protected void populaPrimaryKeyStatement(PreparedStatement stm, Object obj) throws Exception {
		Montadora m = (Montadora) obj;
		stm.setInt(1, m.getCdMontadora());
	}
	
	@Override
	protected List sqlPersolizable(Connection con) throws Exception {
		return null;
	}
	
	
}
