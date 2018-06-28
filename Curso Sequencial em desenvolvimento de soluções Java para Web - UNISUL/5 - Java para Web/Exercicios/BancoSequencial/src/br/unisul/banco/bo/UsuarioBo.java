package br.unisul.banco.bo;

import java.util.List;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.dao.UsuarioDao;

public class UsuarioBo {
	

	/**
	 * Método que verifica a validação de todos os
	 * atributos de um ojbeto do tipo usuarioBean.
	 */
	private boolean validate(UsuarioBean usuario) {
		
		if (usuario.getCodigo().equals("")) {
			return false;
		}
		if (usuario.getNome().equals("")) {
			return false;
		}
		if (usuario.getLogin().equals("")) {
			return false;
		}
		if (usuario.getSenha().equals("")) {
			return false;
		}
		if (usuario.getTipo().equals("")) {
			return false;
		}
		if (usuario.getEmail().indexOf('@') == -1) {
			return false;
		}
		
		return true;
		
	}
	
	public UsuarioBean verificarAuth(UsuarioBean usuario) {
		
		if (usuario!= null 
				&& usuario.getLogin() != null && !usuario.getLogin().equals("") && 
				usuario.getSenha() != null && !usuario.getSenha().equals("")) {
			UsuarioDao dao = new UsuarioDao();
			return dao.verificaAuth(usuario);
		} else {
			return null;	
		}
	}
	
	
	public List<UsuarioBean> pesquisarUsuario (UsuarioBean usuario) {
		UsuarioDao dao = new UsuarioDao();
		return dao.pesquisarUsuario(usuario);
	}
	
	
	public void alterarUsuario(UsuarioBean usuario) {
		UsuarioDao dao = new UsuarioDao();
		dao.alterarUsuario(usuario);
	}
	
	
	public UsuarioBean buscarUsuarioPorCodigo(Integer codigo) {
		UsuarioDao dao = new UsuarioDao();
		return dao.buscarUsuarioPorCodigo(codigo);
	}

	
	public boolean insertUsuario(UsuarioBean usuario) {
		
		if (validate(usuario)) {
			UsuarioDao dao = new UsuarioDao();
			return dao.insertUsuario(usuario);
		} else {
			return false;
		}
	}
	
	
	public List<UsuarioBean> listarUsuarios() {
		UsuarioDao dao = new UsuarioDao();
		return dao.listarUsuarios();	
	}
	
	
	public void excluirUsuario(Integer codigo) {
		UsuarioDao dao = new UsuarioDao();
		dao.excluir(codigo);
	}
	
}
