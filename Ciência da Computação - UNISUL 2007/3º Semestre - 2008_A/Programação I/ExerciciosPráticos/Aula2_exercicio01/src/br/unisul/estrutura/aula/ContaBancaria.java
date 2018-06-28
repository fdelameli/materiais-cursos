package br.unisul.estrutura.aula;

import javax.swing.JOptionPane;

/**
 * Classe que representa uma conta bancária
 * 
 * @author Fabio Dela Bruna
 * @since 26/02/2008
 */
public class ContaBancaria {

	private int numeroConta;
	private double saldo;
	private Pessoa pessoa;
	
	
	/**
	 * Construtor default
	 */
	public ContaBancaria(){
		super();
	}
	
	
	/**
	 * 
	 * @param numeroConta Numero da Conta
	 * @param saldo Saldo da Conta
	 * @param pessoa 
	 */
	public ContaBancaria(int numeroConta, double saldo, Pessoa pessoa) {
		super();
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.pessoa = pessoa;
	}

	
	/**
	 * @return the numeroConta
	 */
	public int getNumeroConta() {
		return numeroConta;
	}

	
	/**
	 * @param numeroConta the numeroConta to set
	 */
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	
	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	
	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	/**
	 * Retira uma quantida de dinheiro da conta
	 * @param valorRetirado Valor a ser retirado.
	 */
	public void retirarValor(double valorRetirado){
		if(saldo < valorRetirado){
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
		} else {
			saldo -= valorRetirado;
		}
	}
}
