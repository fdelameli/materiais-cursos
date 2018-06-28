package revenda.domain;

import framework.domain.DomainBase;

/**
 * Classe que representa um veículo e suas informações.
 * @author Fabio Dela Bruna.
 * @since 04/10/2008.
 */
public class Veiculo extends DomainBase {

	//atributos
	private Integer cdVeiculo;
	private Integer cdCategoria;
	private Integer cdMontadora;
	private String dsVeiculo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private Double valorVeiculo;
	private String corVeiculo;
	private String dsMontadora;
	
	//construtor default
	public Veiculo() {
		
	}
	
	
	//toString
	public String toString() {
		return String.format("%s  -  %s  -  %s  -  %s  -  R$ %s",
				getCdVeiculo(), getDsVeiculo(), getCorVeiculo(), getAnoModelo(), getValorVeiculo());
	}


	//getters e setters
	public Integer getCdVeiculo() {
		return cdVeiculo;
	}

	public void setCdVeiculo(Integer cdVeiculo) {
		this.cdVeiculo = cdVeiculo;
	}

	public Integer getCdCategoria() {
		return cdCategoria;
	}

	public void setCdCategoria(Integer cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	public Integer getCdMontadora() {
		return cdMontadora;
	}

	public void setCdMontadora(Integer cdMontadora) {
		this.cdMontadora = cdMontadora;
	}

	public String getDsVeiculo() {
		return dsVeiculo;
	}

	public void setDsVeiculo(String dsVeiculo) {
		this.dsVeiculo = dsVeiculo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Double getValorVeiculo() {
		return valorVeiculo;
	}

	public void setValorVeiculo(Double valorVeiculo) {
		this.valorVeiculo = valorVeiculo;
	}

	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}
	
	public void setDsMontadora(String dsMontadora) {
		this.dsMontadora = dsMontadora;
	}
	
	public String getDsMontadora() {
		return dsMontadora;
	}
	
}
