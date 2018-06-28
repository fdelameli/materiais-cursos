package br.unisul.projeto.view.backbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.unisul.projeto.core.bo.UsuarioBO;
import br.unisul.projeto.core.entity.UsuarioEntity;

@ManagedBean(name = "login")
@RequestScoped
public class LoginBack {

	private String login;
	
	private String senha;
	
	//Metodo que realiza a autenticacao
	public String autenticar(){
		
		//Busca no banco o usuario pelo login e senha digitado
		UsuarioEntity usuarioLogado = new UsuarioBO().buscarUsuarioPorLoginSenha(login, senha);
		
		//Se retornar null quer dizer que login e senha estao invalidos
		if(usuarioLogado == null){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Login ou senha inválido", 
					"Login ou senha inválido"));
			return null;
		}else{
		//Usuario existente
		//Coloca usuario na sessao
		((HttpServletRequest)FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getRequest()).getSession()
								.setAttribute("usuarioLogado", usuarioLogado);
		
			//redireciona para area restrita
			return "/restrito/acessoRestrito.xhtml?faces-redirect=true";
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
