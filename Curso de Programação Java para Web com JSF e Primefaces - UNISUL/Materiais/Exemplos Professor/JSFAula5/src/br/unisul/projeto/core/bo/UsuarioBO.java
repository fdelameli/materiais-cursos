package br.unisul.projeto.core.bo;

import br.unisul.projeto.core.dao.UsuarioDAO;
import br.unisul.projeto.core.entity.UsuarioEntity;

public class UsuarioBO extends CrudBO<UsuarioEntity>{

	public UsuarioEntity buscarUsuarioPorLoginSenha(String login, String senha){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.buscarUsuarioPorLoginSenha(login, senha);
	}
}
