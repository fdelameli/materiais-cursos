package br.unisul.aula.trabalho.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que represenra um cliente de classificação preferencial.
 * @author Fabio Dela Bruna / Marcio Teixeira Ozório.
 * @since 13/05/2008.
 */
public class ClienteNormal extends Cliente {

	//atributos
	
	private final double TAXA = 5.00;
	
	
	//construtores
	
	/**
	 * Construtor default
	 */
	public ClienteNormal() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 * @param nome - Nome do cliente.
	 * @param sobrenome - Sobrenome.
	 * @param cpf - Cadastro de pessoa física - CPF.
	 * @param endereco - Endereço completo.
	 * @param dataNascimento - Data de nascimento.
	 * @param fone1 - Telefone 1.
	 * @param fone2 - Telefone 2.
	 * @param estadias - ArrayList de estadias.
	 */
	public ClienteNormal(String nome, String sobrenome, String cpf, Endereco endereco, Date dataNascimento, String fone1, String fone2, ArrayList<Estadia> estadias) {
		super(nome, sobrenome, cpf, endereco, dataNascimento, fone1, fone2, estadias);
	}
	

	
	@Override
	public double calculaValorEstadia() {
		double total = 0;
		for (Estadia e : this.getEstadias()) {
			total += (e.getQtdDias() * e.getQuarto().getValorDiaria()) + (e.getQtdDias() * TAXA);
		}
		return total;
	}
	
	public void cadastraEstadia(Estadia e){
		this.getEstadias().add(e);
	}
	
	public String toString(){
		return String.format("%sValor a ser pago: %s\n", super.toString(), calculaValorEstadia());
	}
	
}
