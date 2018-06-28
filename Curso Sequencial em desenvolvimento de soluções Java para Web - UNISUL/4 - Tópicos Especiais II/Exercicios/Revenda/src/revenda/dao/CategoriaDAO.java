package revenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import revenda.domain.Categoria;
import framework.dao.DaoBase;


/**
 * Classe responsável por gravar em banco
 * as informações de cada descrição.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/10/2008.
 */
public class CategoriaDAO extends DaoBase {

	
	public CategoriaDAO() throws Exception {
		super();
	}

	

	@Override
	protected String getColumnsWithoutPrimaryKey() {
		return "DSCATEGORIA";
	}


	@Override
	protected String getJoins() {
		return "";
	}


	@Override
	protected String getPrimaryKeyColumn() {
		return "CDCATEGORIA";
	}


	@Override
	protected String getTableName() {
		return "CATEGORIA";
	}


	@Override
	protected String getWhereByExample(int cd, String ds) {
		StringBuilder string = new StringBuilder();
		string.append("1=1");
		
		if ( cd > 0 ) {
			string.append(" AND CDCATEGORIA = " + cd);
		}
		if (!ds.equals("")){
			string.append(" AND DSCATEGORIA LIKE '%" + ds + "%'");
		}
		
		return string.toString();
	}


	@Override
	protected String getWherePrimaryKey() {
		return "";
	}


	@Override
	protected Object populaDomainBase(ResultSet rs) throws Exception {
		Categoria categoria = new Categoria();
		categoria.setCdCategoria( rs.getInt("CDCATEGORIA"));
		categoria.setDsCategoria( rs.getString("DSCATEGORIA"));
		return categoria;
	}


	@Override
	protected void populaObjectStatment(PreparedStatement stm, Object obj) throws Exception {
		Categoria c = (Categoria) obj;
		stm.setString(1, c.getDsCategoria());
		stm.setInt(2, c.getCdCategoria());
	}


	@Override
	protected void populaPrimaryKeyStatement(PreparedStatement stm, Object obj) throws Exception {
		Categoria c = (Categoria) obj;
		stm.setInt(1, c.getCdCategoria());
	}
	

	@Override
	protected List sqlPersolizable(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
