package br.unisul.aula.trabalho.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que represenra um cliente de classifica��o preferencial.
 * @author Fabio Dela Bruna / Marcio Teixeira Oz�rio.
 * @since 13/05/2008.
 */
public class ClientePreferencial extends Cliente {

	//atributos
	
	private final double DESCONTO = 0.8;
	
	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public ClientePreferencial() {
		super();
	}

	/**
	 * Construtor com par�metros.
	 * @param nome - Nome do cliente.
	 * @param sobrenome - Sobrenome.
	 * @param cpf - Cadastro de pessoa f�sica - CPF.
	 * @param endereco - Endere�o completo.
	 * @param dataNascimento - Data de nascimento.
	 * @param fone1 - Telefone 1.
	 * @param fone2 - Telefone 2.
	 * @param qtdDias - Quantidade de dias que os clientes podem hospedar-se.
	 * @param quarto - Tipo do quarto.
	 */
	public ClientePreferencial(String nome, String sobrenome, String cpf, Endereco endereco, Date dataNascimento, String fone1, String fone2, ArrayList<Estadia> estadias) {
		super(nome, sobrenome, cpf, endereco, dataNascimento, fone1, fone2, estadias);
	}

	
	
	@Override
	public double calculaValorEstadia() {
		double total = 0;
		for (Estadia e : this.getEstadias()) {
			total += (e.getQtdDias() * e.getQuarto().getValorDiaria()) * DESCONTO;
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
