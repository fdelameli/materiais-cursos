package br.unisul.projeto.view.backbean;

import javax.annotation.PostConstruct;

public class HelloBack {

	private String msg;

	@PostConstruct
	public void postConstruct(){
		msg = "Hello Managed Bean!";
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
