package br.unisul.projeto.view.backbean;

import javax.annotation.PostConstruct;

import br.unisul.projeto.core.entity.UsuarioEntity;

public class CadastroUsuarioBack {

	private UsuarioEntity usuario;

	@PostConstruct
	public void postConstruct(){
		usuario = new UsuarioEntity();
	}
	
	public void cadastrar(){
		System.out.println(usuario);
		usuario = new UsuarioEntity();
	}
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}
