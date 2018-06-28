package br.unisul.aula.interfacegrafica.dto;

import java.util.Date;

public class ReservaDTO {

	private long codigo;
	private Integer cliente;
	private Integer quarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	
	/**
	 * Construtor default.
	 */
	public ReservaDTO() {
		
	}


	// getters e setters
	
	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}
	
}
