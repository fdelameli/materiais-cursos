package br.unisul.projeto.view.backbean;

import javax.annotation.PostConstruct;

public class HelloBack {

	private String msg;

	@PostConstruct
	public void postConstruct(){
		msg = "Hello Managed Bean!";
	}
	
	public String redirecionar(){
		System.out.println("processamento qualquer");
		
		return "retorno1";
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
