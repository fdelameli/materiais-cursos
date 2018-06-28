package br.unisul.transportadora.bo;

import java.util.ArrayList;
import java.util.List;

import br.unisul.transportadora.bean.FreteBean;
import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.dao.FreteDao;

/**
 * Classe Java que efetua a comunição entre as 
 * entidades do tipo FreteBean e a camada view.
 * @author Fabio Dela Bruna
 */
public class FreteBo {


	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\ 
	 * Os Métodos a seguir fazem a comunicação entre a camada "view" 
	 * e a camada "dao" para objetos do tipo FreteBean.
	 *  
	 */

	public Integer getMaxValueFromCodigo() {
		FreteDao dao = new FreteDao();
		return dao.getMaxValueFromCodigo();
	}
	
	public FreteBean findById(Integer codigo) {
		FreteDao dao = new FreteDao();
		return dao.findById(codigo);
	}
	
	public ArrayList<FreteBean> findByCliente(UsuarioBean user) {
		FreteDao dao = new FreteDao();
		return dao.findByCliente(user);
	}

	public boolean insertFrete(FreteBean fre) {
		FreteDao dao = new FreteDao();
		return dao.insertFrete(fre);
	}

	public boolean updateFrete(FreteBean fre) {
		FreteDao dao = new FreteDao();
		return dao.updateFrete(fre);
	}
	
	public boolean deleteFrete(Integer codigo) {
		FreteDao dao = new FreteDao();
		return dao.deleteFrete(codigo);
	}
	
	public List<FreteBean> findAllFrete() {
		FreteDao dao = new FreteDao();
		return dao.findAllFrete();
	}
	
	/*
	 * 
	 * Fim dos métodos que efetuam a comunicação...
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


}
