package br.com.napoleao.teste.enums;

public enum TipoConfirmacao {
	
	S ("Sim"),
	N ("Não");
	
	private String label;
	
	private TipoConfirmacao(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
