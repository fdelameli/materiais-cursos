package br.unisul.projeto.view.backbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.unisul.projeto.core.entity.UsuarioEntity;

@ManagedBean(name = "cadastroUsuario")
@SessionScoped
public class CadastroUsuarioBack {

	private UsuarioEntity usuario;

	private List<UsuarioEntity> listUsuario;
	
	private Integer idade;
	
	@PostConstruct
	public void inicializar(){
		usuario = new UsuarioEntity();
		listUsuario = new ArrayList<UsuarioEntity>();
	}
	
	public void carregarFormulario(){
		HttpServletRequest req = (HttpServletRequest)FacesContext
										.getCurrentInstance()
										.getExternalContext()
										.getRequest();
		
		String idUsuario = req.getParameter("idUsuario");
		
		for (UsuarioEntity usu : listUsuario) {
			if(usu.getId() == Long.parseLong(idUsuario)){
				usuario = usu;
			}
		}
		
	}
	
	public void excluir(){
		HttpServletRequest req = (HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest();

		String idUsuario = req.getParameter("idUsuario");
		
		UsuarioEntity usu = new UsuarioEntity();
		usu.setId(Long.parseLong(idUsuario));
		
		listUsuario.remove(usu);

	}
	
	public void cadastrar(){
		//Se id for != null é alteracao
		if(usuario != null && usuario.getId() != null){
			listUsuario.remove(usuario);
			listUsuario.add(usuario);
		}else{
			//Adiciona usuario cadastrado na lista
			usuario.setId(new Long(listUsuario.size()+1));
			listUsuario.add(usuario);
		}
		
		//Limpa entidade usuario, limpando o formulario
		usuario = new UsuarioEntity();
	}
	
	public void dispararMessages(){
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_WARN, 
						"Mensagem Atenção Summary",
						"Mensagem Atenção Detail"));
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Mensagem Info Summary",
						"Mensagem Info Detail"));
	}
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<UsuarioEntity> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<UsuarioEntity> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
