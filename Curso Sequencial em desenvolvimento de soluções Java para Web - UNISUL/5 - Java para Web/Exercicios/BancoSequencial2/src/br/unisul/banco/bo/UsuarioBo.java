package br.unisul.banco.bo;

import java.util.List;

import br.unisul.banco.bean.UsuarioBean;
import br.unisul.banco.dao.UsuarioDao;

public class UsuarioBo {

	public void insertUsuario(UsuarioBean usuario){

		//Implementar validadores

		UsuarioDao dao = new UsuarioDao();
		dao.insertUsuario(usuario);		
	}

	public List<UsuarioBean> listarUsuario(){

		UsuarioDao dao = new UsuarioDao();
		return dao.listarUsuario();
	}

	public void excluirUsuario(Integer codigo){

		UsuarioDao dao = new UsuarioDao();
		dao.excluirUsuario(codigo);		
	}

	public UsuarioBean buscarUsuarioPorCodigo(Integer codigo){
		UsuarioDao dao = new UsuarioDao();
		return dao.buscarUsuarioPorCodigo(codigo);
	}

	public void alterarUsuario(UsuarioBean usuario){
		UsuarioDao dao = new UsuarioDao();
		dao.alterarUsuario(usuario);
	}

	public List<UsuarioBean> pesquisarUsuario(UsuarioBean usuario){
		UsuarioDao dao = new UsuarioDao();
		return dao.pesquisarUsuario(usuario);		
	}


	public UsuarioBean verificarAuth(UsuarioBean usuario){
		if(usuario != null && usuario.getLogin()!= null 
				&& !usuario.getLogin().equals("") 
				&& usuario.getSenha()!=null 
				&& !usuario.getSenha().equals("")){
			
			
			UsuarioDao dao = new UsuarioDao();
			
			return dao.verificaAuth(usuario);
			
		}else{
			return null;
		}
	}
}







