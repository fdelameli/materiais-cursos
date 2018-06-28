package revenda.domain;

import framework.domain.DomainBase;

/**
 * Classe que representa uma montadora e suas informações.
 * @author Fabio Dela Bruna. 
 * @since 04/10/2008.
 */
public class Montadora extends DomainBase {

	//atributos
	private Integer cdMontadora;
	private String dsMontadora;
	
	
	//construtor default
	public Montadora() {
		
	}
	
	
	// toString
	public String toString() {
		return String.format("%s  -  %s", getCdMontadora(), getDsMontadora());
	}


	//getters e setters
	public Integer getCdMontadora() {
		return cdMontadora;
	}

	public void setCdMontadora(Integer cdMontadora) {
		this.cdMontadora = cdMontadora;
	}

	public String getDsMontadora() {
		return dsMontadora;
	}

	public void setDsMontadora(String dsMontadora) {
		this.dsMontadora = dsMontadora;
	}
	
	public String[] toStringArray() {
		return new String[] {getCdMontadora().toString(), getDsMontadora()};
	}
}
