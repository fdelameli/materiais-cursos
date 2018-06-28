package com.br.lhmanager.controller.entitys;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe que representa uma venda feita na Lan House.
 * 
 * @author Fabio Dela Bruna.
 * @since 04/05/2010.
 */
public class Venda {

	// Atributos

	/**
	 * Código da venda.
	 */
	private int codigo;

	/**
	 * Descrição da venda.
	 */
	private String descricao;

	/**
	 * Data da venda.
	 */
	private Date data;

	/**
	 * Indica se a venda foi paga ou não pelo cliente.
	 */
	private boolean flagPago;

	/**
	 * Lista de produtos vendidos.
	 */
	private ArrayList<Produto> produtos;

	/**
	 * Lista de impressões efetuadas.
	 */
	private ArrayList<Impressao> impressoes;

	// Construtores

	/**
	 * Construtor sem parâmetros (padrão).
	 */
	public Venda() {
		this(0, "", new Date(), false, new ArrayList<Produto>(),
				new ArrayList<Impressao>());
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param codigo
	 *            Código da venda.
	 * @param descricao
	 *            Descrição da venda.
	 * @param data
	 *            Data da venda.
	 * @param flagPago
	 *            Se a venda foi paga ou não.
	 * @param produtos
	 *            Lista de produtos vendidos.
	 * @param impressoes
	 *            Lista de impressões efetuadas.
	 */
	public Venda(int codigo, String descricao, Date data, boolean flagPago,
			ArrayList<Produto> produtos,
			ArrayList<Impressao> impressoes) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.data = data;
		this.flagPago = flagPago;
		this.produtos = produtos;
		this.impressoes = impressoes;
	}

	// Métodos de controle da classe

	/**
	 * Calcula o total da compra.
	 * 
	 * @return O valor total da compra.
	 */
	public double calcularTotalVenda() {
		return 0;
	}

	/**
	 * Insere um produto na venda.
	 * 
	 * @param prod
	 *            Produto a ser inserido.
	 */
	public void inserirProduto(Produto prod) {

	}

	/**
	 * Insere uma impressão na venda.
	 * 
	 * @param impr
	 *            Impressão a ser inserida.
	 */
	public void inserirImpressao(Impressao impr) {

	}

	/**
	 * Lista os itens da venda.
	 * 
	 * @return Lista com totos os itens na venda.
	 */
	public ArrayList<Object> listarItens() {
		return null;
	}

	@Override
	public String toString() {
		Format f = new SimpleDateFormat("dd/MM/yyyy");
		return String
				.format(
						"Código: %d\nDescrição: %s\nData: %s\nValor Total: %.2f\nPago: %s\n",
						getCodigo(), getDescricao(), f.format(getData()),
						calcularTotalVenda(), isFlagPago() ? "Sim" : "Não");
	}

	// Getters e Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isFlagPago() {
		return flagPago;
	}

	public void setFlagPago(boolean flagPago) {
		this.flagPago = flagPago;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Impressao> getImpressoes() {
		return impressoes;
	}

	public void setImpressoes(ArrayList<Impressao> impressoes) {
		this.impressoes = impressoes;
	}

}
