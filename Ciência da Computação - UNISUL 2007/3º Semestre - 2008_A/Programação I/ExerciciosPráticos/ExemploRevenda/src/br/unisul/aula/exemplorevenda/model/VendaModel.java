package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import br.unisul.aula.exemplorevenda.entidade.Venda;

/**
 * Classe de negócio.
 * @author Fabio Dela Bruna
 * @since 29/04/2008
 */
public class VendaModel implements IVendaModel {
	
	// atributos
	
	private ArrayList<Venda> vendas;
	
	
	// construtores
	
	/**
	 * Construtor default
	 */
	public VendaModel() {
		super();
	}
	
	/**
	 * Cnstrutor com parâmetros.
	 * @param vendas - ArrayList de Vendas.
	 */
	public VendaModel(ArrayList<Venda> vendas) {
		super();
		this.vendas = vendas;
	}


	// métodos principais

	@Override
	public Venda buscaVenda(int codigo, String cliente) {
		if((cliente != null && cliente.length() != 0) && codigo != 0){
			for(Venda v : this.vendas){
				if(v.getCliente().equals(cliente)){
					return v;
				}
			}
		}
		return null;
	}

	@Override
	public void efetuaVenda(Venda v) {
		this.vendas.add(v);
	}

	@Override
	public ArrayList<Venda> mostraVendas() {
		return this.vendas;
	}

}
