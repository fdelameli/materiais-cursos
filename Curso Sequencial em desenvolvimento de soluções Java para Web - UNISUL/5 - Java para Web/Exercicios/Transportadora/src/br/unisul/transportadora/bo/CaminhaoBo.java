package br.unisul.transportadora.bo;

import java.sql.SQLException;
import java.util.List;

import br.unisul.transportadora.bean.CaminhaoBean;
import br.unisul.transportadora.dao.CaminhaoDao;

/**
 * Classe Java que efetua a comunição entre as 
 * entidades do tipo CaminhaoBean e a camada view.
 * @author Fabio Dela Bruna
 */
public class CaminhaoBo {


	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\ 
	 * Os Métodos a seguir fazem a comunicação entre a camada "view" 
	 * e a camada "dao" para objetos do tipo CaminhaoBean.
	 *  
	 */

	public Integer getMaxValueFromCodigo() {
		CaminhaoDao dao = new CaminhaoDao();
		return dao.getMaxValueFromCodigo();
	}
	
	public CaminhaoBean findById(Integer codigo) {
		CaminhaoDao dao = new CaminhaoDao();
		return dao.findById(codigo);
	}

	public boolean insertCaminhao(CaminhaoBean cam) {
		CaminhaoDao dao = new CaminhaoDao();
		return dao.insertCaminhao(cam);
	}

	public boolean updateCaminhao(CaminhaoBean cam) {
		CaminhaoDao dao = new CaminhaoDao();
		return dao.updateCaminhao(cam);
	}
	
	public boolean deleteCaminhao(Integer codigo) throws SQLException {
		CaminhaoDao dao = new CaminhaoDao();
		return dao.deleteCaminhao(codigo);
	}
	
	public List<CaminhaoBean> findAllCaminhao() {
		CaminhaoDao dao = new CaminhaoDao();
		return dao.findAllCaminhao();
	}
	
	/*
	 * 
	 * Fim dos métodos que efetuam a comunicação...
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


}
