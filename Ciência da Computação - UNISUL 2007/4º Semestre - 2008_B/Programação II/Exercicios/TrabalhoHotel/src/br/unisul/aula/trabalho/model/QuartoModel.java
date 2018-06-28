package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.dto.Quarto;

public class QuartoModel implements IQuartoModel {

	private ArrayList<Quarto> quartos;

	/**
	 * Construtor default.
	 */
	public QuartoModel() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 * 
	 * @param quartos - ArrayList de Quartos.
	 */
	public QuartoModel(ArrayList<Quarto> quartos) {
		super();
		this.quartos = quartos;
	}

	@Override
	public void cadastraQuarto(Quarto q) throws IllegalArgumentException {
		validaQuarto(q);
		this.quartos.add(q);
	}

	@Override
	public ArrayList<Quarto> mostraQuartos() {
		return this.quartos;
	}

	@Override
	public void removeQuarto(Quarto q) {
		this.quartos.remove(q);

	}
	
	/**
	 * Método que verifica se os atributos obrigatórios de determinado quarto são válidos.
	 * @param q - Quarto.
	 * @throws IllegalArgumentException
	 */
	private void validaQuarto(Quarto q) throws IllegalArgumentException {
		if (q.getQtdPessoas() <= 0)
			throw new IllegalArgumentException("Quantidade de Pessoas neste quarto é inválida!");
	}

}
