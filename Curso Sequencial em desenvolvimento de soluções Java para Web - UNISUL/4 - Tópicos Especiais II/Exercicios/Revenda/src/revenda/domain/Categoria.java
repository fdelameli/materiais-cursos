package revenda.domain;

import framework.domain.DomainBase;

/**
 * Classe que representa uma categoria.
 * @author Fabio Dela Bruna.
 * @since 04/10/2008.
 */
public class Categoria extends DomainBase {

	//atributos
	private Integer cdCategoria;
	private String dsCategoria;
	
	
	//construtor default
	public Categoria() {
		
	}
	
	// toString
	public String toString() {
		return String.format("%s  -  %s", getCdCategoria(), getDsCategoria());
	}


	//getters e setters
	public Integer getCdCategoria() {
		return cdCategoria;
	}

	public void setCdCategoria(Integer cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	public String getDsCategoria() {
		return dsCategoria;
	}

	public void setDsCategoria(String dsCategoria) {
		this.dsCategoria = dsCategoria;
	}
	
}
