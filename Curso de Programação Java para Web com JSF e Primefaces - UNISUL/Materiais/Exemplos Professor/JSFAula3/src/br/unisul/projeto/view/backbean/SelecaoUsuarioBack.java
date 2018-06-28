package br.unisul.projeto.view.backbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.unisul.projeto.core.entity.UsuarioEntity;

@ManagedBean(name = "selecaoUsuario")
@SessionScoped
public class SelecaoUsuarioBack {

	private List<UsuarioEntity> usuarios;

	private UsuarioEntity usuarioSelecionado;
	
	@PostConstruct
	public void inicializar(){
		
		UsuarioEntity u1 = new UsuarioEntity();
		u1.setId(1L);
		u1.setNome("Rogério");
		u1.setLogin("rogerio");
		
		UsuarioEntity u2 = new UsuarioEntity();
		u2.setId(2L);
		u2.setNome("Teste 1");
		u2.setLogin("teste");
		
		usuarios = new ArrayList<UsuarioEntity>();
		usuarios.add(u1);
		usuarios.add(u2);
	}
	
	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioEntity getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(UsuarioEntity usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
}
