package br.unisul.aula.trabalho.model;

import java.util.ArrayList;

import br.unisul.aula.trabalho.entidades.Aluguel;
import br.unisul.aula.trabalho.entidades.Funcionario;


/**
 * Classe de negócio.
 * @author Fabio Dela Bruna / Marcio Ozório Teixeira.
 * @since 18/06/2008.
 */
public class ReceitaModel implements IReceitaModel {

	//attributes
	
	private ArrayList<Aluguel> alugueis;
	private ArrayList<Funcionario> funcionarios;
	 
	
	//constructor
	
	/**
	 * Construtor com parâmetros.
	 * @param alugueis - ArrayList de Alugueis.
	 * @param funcionarios - ArrayList de Funcionarios.
	 */
	public ReceitaModel(ArrayList<Aluguel> alugueis, ArrayList<Funcionario> funcionarios) {
		super();
		this.alugueis = alugueis;
		this.funcionarios = funcionarios;
	}

	
	//main methods
	
	@Override
	public double getTotalBruto() {
		double total = 0.0;
		for (Aluguel aluguel : this.alugueis) {
			total += aluguel.calculaValorAluguel();
		}
		return total;
	}

	@Override
	public double getTotalDispesa() {
		double total = 0.0;
		for (Funcionario funcionario : this.funcionarios) {
			total += funcionario.calculaSalario();
		}
		return total;
	}

	@Override
	public double getTotalLiquido() {
		return getTotalBruto() - getTotalDispesa();
	}

	
}
