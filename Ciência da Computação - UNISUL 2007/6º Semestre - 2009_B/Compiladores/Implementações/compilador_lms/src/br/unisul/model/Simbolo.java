package br.unisul.model;

public class Simbolo {

	private String nomeSimbolo;
	private String categoriaSimbolo;
	private int nivel;
	private int deslocamento;
	
	/**
	 * Construtor da Classe com passagem de par�metros
	 * 
	 * @param nomeSimbolo
	 * @param categoriaSimbolo
	 * @param nivel
	 * @param deslocamento
	 */
	public Simbolo(String nomeSimbolo, String categoriaSimbolo, int nivel, int deslocamento){
		this.nomeSimbolo = nomeSimbolo;
		this.categoriaSimbolo = categoriaSimbolo;
		this.nivel = nivel;
		this.deslocamento = deslocamento;
	}
	
	/**
	 * Construtor padr�o da Classe
	 * 
	 * @author Almir Hoepers, Guilherme Azevedo, Thiago Ghisi
	 */
	public Simbolo(){
		this(null, null, 0, 0);
	}

	//------------------------------------
	// GETTERs e SETTERs
	//------------------------------------
	
	public String getNomeSimbolo() {
		return nomeSimbolo;
	}

	public void setNomeSimbolo(String nomeSimbolo) {
		this.nomeSimbolo = nomeSimbolo;
	}

	public String getCategoriaSimbolo() {
		return categoriaSimbolo;
	}

	public void setCategoriaSimbolo(String categoriaSimbolo) {
		this.categoriaSimbolo = categoriaSimbolo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getDeslocamento() {
		return deslocamento;
	}

	public void setDeslocamento(int deslocamento) {
		this.deslocamento = deslocamento;
	}

	
}
