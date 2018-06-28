package br.unisul.projeto.view.backbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unisul.projeto.core.bo.UsuarioBO;
import br.unisul.projeto.core.entity.UsuarioEntity;

@ManagedBean(name = "cadastroUsuario")
@ViewScoped
public class CadastroUsuarioBack {

	private UsuarioEntity usuario;

	private List<UsuarioEntity> usuarios;
	
	@PostConstruct
	public void inicializar(){
		usuario = new UsuarioEntity();
		usuarios = new UsuarioBO().listarTodos(UsuarioEntity.class);
	}
	
	public void cadastrar(){
		UsuarioBO bo = new UsuarioBO();

		if(usuario != null && usuario.getId() == null){
			bo.insert(usuario);
		}else{
			bo.update(usuario);
		}
		
		usuario = new UsuarioEntity();
		usuarios = bo.listarTodos(UsuarioEntity.class); 
	}
	
	public void excluir(){
		new UsuarioBO().remove(usuario);
		usuario = new UsuarioEntity();
		usuarios = new UsuarioBO().listarTodos(UsuarioEntity.class);
	}
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
}
