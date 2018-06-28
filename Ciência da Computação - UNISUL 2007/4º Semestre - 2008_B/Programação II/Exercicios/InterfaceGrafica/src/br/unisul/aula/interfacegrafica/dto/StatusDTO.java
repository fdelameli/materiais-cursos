package br.unisul.aula.interfacegrafica.dto;

public class StatusDTO {
	
	private int codigo;
	private String descricao;
	
	
	public StatusDTO() {
		super();
	}
	

	public StatusDTO(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getcodigo() {
		return codigo;
	}
	
	public void setcodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	/**
	 * Método toString que retorna a descrição. 
	 */
	public String toString() {
		return descricao;
	}

}
