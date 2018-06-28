package revenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import revenda.domain.Veiculo;
import framework.dao.DaoBase;


/**
 * Classse responsável por gravar em banco
 * as informacoes de cada veículo.
 * 
 * @author Fabio Dela Bruna
 * @since 04/10/2008.
 */
public class VeiculoDAO extends DaoBase {

	public VeiculoDAO() throws Exception {
		super();
	}


	@Override
	protected String getJoins() {
		return "";
	}

	@Override
	protected String getPrimaryKeyColumn() {
		return "CDVEICULO";
	}

	@Override
	protected String getTableName() {
		return "VEICULO";
	}

	@Override
	protected String getWhereByExample(int cd, String ds) {
		StringBuilder string = new StringBuilder();
		string.append("1=1");
		
		if ( cd > 0 ) {
			string.append(" AND CDVEICULO = " + cd);
		}
		if (!ds.equals("")){
			string.append(" AND DSVEICULO LIKE '%" + ds + "%'");
		}
		
		return string.toString();
	}

	@Override
	protected String getWherePrimaryKey() {
		return "";
	}

	@Override
	protected Object populaDomainBase(ResultSet rs) throws Exception {
		Veiculo v = new Veiculo();
		v.setCdVeiculo( rs.getInt("CDVEICULO"));
		v.setCdCategoria( rs.getInt("CDCATEGORIA"));
		v.setCdMontadora( rs.getInt("CDMONTADORA"));
		v.setAnoFabricacao( rs.getInt("ANOFABRICACAO"));
		v.setAnoModelo( rs.getInt("ANOMODELO"));
		v.setCorVeiculo( rs.getString("CORVEICULO"));
		v.setDsVeiculo( rs.getString("DSVEICULO"));
		v.setValorVeiculo( rs.getDouble("VALORVEICULO"));
		return v;
	}

	@Override
	protected String getColumnsWithoutPrimaryKey() {
		return "CDMONTADORA,CDCATEGORIA,DSVEICULO,ANOFABRICACAO,ANOMODELO,VALORVEICULO,CORVEICULO";
	}
	
	@Override
	protected void populaObjectStatment(PreparedStatement stm, Object obj) throws Exception {
		Veiculo v = (Veiculo) obj;
		
		stm.setInt(1, v.getCdMontadora());
		stm.setInt(2, v.getCdCategoria());
		stm.setString(3, v.getDsVeiculo());
		stm.setInt(4, v.getAnoFabricacao());
		stm.setInt(5, v.getAnoModelo());
		stm.setDouble(6, v.getValorVeiculo());
		stm.setString(7, v.getCorVeiculo());
		stm.setInt(8, v.getCdVeiculo());
	}

	@Override
	protected void populaPrimaryKeyStatement(PreparedStatement stm, Object obj) throws Exception {
		Veiculo v = (Veiculo) obj;
		stm.setInt(1, v.getCdVeiculo());
	}
	
	@Override
	public List sqlPersolizable(Connection con) throws Exception {
		List lista = new ArrayList();
		
		String sql = "SELECT CDVEICULO, DSVEICULO, VALORVEICULO, DSMONTADORA"
			+ " FROM VEICULO V, MONTADORA M"
			+ " WHERE V.CDMONTADORA = M.CDMONTADORA";
		
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		while (rs.next()) {
			Veiculo v = new Veiculo();
			v.setCdVeiculo( rs.getInt("CDVEICULO"));
			v.setDsVeiculo( rs.getString("DSVEICULO"));
			v.setValorVeiculo( rs.getDouble("VALORVEICULO"));
			v.setDsMontadora( rs.getString("DSMONTADORA"));
			System.out.println(v.getDsMontadora());
			lista.add(v);
		}
		return lista;
	}
	
}
