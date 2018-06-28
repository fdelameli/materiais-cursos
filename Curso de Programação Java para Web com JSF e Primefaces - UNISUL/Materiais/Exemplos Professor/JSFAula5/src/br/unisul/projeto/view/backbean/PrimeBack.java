package br.unisul.projeto.view.backbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "prime")
@ViewScoped
public class PrimeBack {

	private String msg;

	public void converte(){
		msg = msg.toUpperCase();
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
