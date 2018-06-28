
package br.unisul.model;

/**
 *	Representa um token.
 */
public class Token {
    
	private int cdToken;
	private String nmToken;
	private String tpToken;

	//-------------------------------------------------------------
	// Contrutores
	//-------------------------------------------------------------
	
	public Token (int cdToken, String nmToken, String tpToken) {
		this.cdToken = cdToken;
		this.nmToken = nmToken;
		this.tpToken = tpToken;
	}
	
	public Token(){
		this(0, null, null);
	}
	
	//-------------------------------------------------------------
	// Getters and Setters
	//-------------------------------------------------------------
	
	public int getCdToken() {
		return cdToken;
	}
	public void setCdToken(int cdToken) {
		this.cdToken = cdToken;
	}
	public String getNmToken() {
		return nmToken;
	}
	public void setNmToken(String nmToken) {
		this.nmToken = nmToken;
	}
	public String getTpToken() {
		return tpToken;
	}
	public void setTpToken(String tpToken) {
		this.tpToken = tpToken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cdToken;
		result = prime * result + ((nmToken == null) ? 0 : nmToken.hashCode());
		result = prime * result + ((tpToken == null) ? 0 : tpToken.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (cdToken != other.cdToken)
			return false;
		if (nmToken == null) {
			if (other.nmToken != null)
				return false;
		} else if (!nmToken.equals(other.nmToken))
			return false;
		if (tpToken == null) {
			if (other.tpToken != null)
				return false;
		} else if (!tpToken.equals(other.tpToken))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "C�digo: " + cdToken +"\t"+ 
			   "Nome: " + nmToken +"\t"+
			   "Tipo: " + tpToken;
	}
	
	
    
}
