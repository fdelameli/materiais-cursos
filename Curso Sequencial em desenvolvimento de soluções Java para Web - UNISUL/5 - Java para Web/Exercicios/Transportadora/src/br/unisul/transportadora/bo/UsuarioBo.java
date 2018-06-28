package br.unisul.transportadora.bo;

import java.sql.SQLException;
import java.util.List;

import br.unisul.transportadora.bean.UsuarioBean;
import br.unisul.transportadora.dao.UsuarioDao;

/**
 * Classe Java que efetua a comunição entre as 
 * entidades do tipo UsuarioBean e a camada view.
 * @author Fabio Dela Bruna
 */
public class UsuarioBo {


	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\ 
	 * Os Métodos a seguir fazem a comunicação entre a camada "view" 
	 * e a camada "dao" para objetos do tipo UsuarioBean.
	 *  
	 */

	public Integer getMaxValueFromCodigo() {
		UsuarioDao dao = new UsuarioDao();
		return dao.getMaxValueFromCodigo();
	}
	
	public List<UsuarioBean> findAllById (Integer tipo) {
		UsuarioDao dao = new UsuarioDao();
		return dao.findAllById(tipo);
	}
	
	public UsuarioBean findById(Integer codigo) {
		UsuarioDao dao = new UsuarioDao();
		return dao.findById(codigo);
	}
	
	public UsuarioBean findByEmailSenha(String email, String senha) {
		UsuarioDao dao = new UsuarioDao();
		return dao.findByEmailSenha(email, senha);
	}

	public void insertUsuario(UsuarioBean user) {
		UsuarioDao dao = new UsuarioDao();
		dao.insertUsuario(user);
	}

	public void updateUsuario(UsuarioBean user) {
		UsuarioDao dao = new UsuarioDao();
		dao.updateUsuario(user);
	}
	
	public void deleteUsuario(Integer codigo) throws SQLException {
		UsuarioDao dao = new UsuarioDao();
		dao.deleteUsuario(codigo);
	}
	
	public List<UsuarioBean> findAllUsuario() {
		UsuarioDao dao = new UsuarioDao();
		return dao.findAllUsuario();
	}
	
	/*
	 * 
	 * Fim dos métodos que efetuam a comunicação...
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


}
