package br.unisul.projeto.view.backbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "hello2")
@SessionScoped
public class Hello2Back {

	private String msg;
	
	@PostConstruct
	public void postConstruct(){
		msg = "Teste JSF2"; 
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
