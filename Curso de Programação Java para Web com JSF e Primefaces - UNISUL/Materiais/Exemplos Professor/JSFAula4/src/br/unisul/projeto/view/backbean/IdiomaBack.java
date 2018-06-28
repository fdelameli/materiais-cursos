package br.unisul.projeto.view.backbean;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "idioma")
@SessionScoped
public class IdiomaBack {

	private String locale;

	@PostConstruct
	public void inicializar(){
		locale = "pt_BR";
	}
	
	public void aplicar(){
		FacesContext.getCurrentInstance().
					getViewRoot().setLocale(new Locale(locale));
	}
	
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
}
