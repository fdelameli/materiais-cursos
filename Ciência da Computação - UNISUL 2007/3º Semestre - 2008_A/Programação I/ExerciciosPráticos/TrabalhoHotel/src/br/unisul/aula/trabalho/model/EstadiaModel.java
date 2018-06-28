package br.unisul.aula.trabalho.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import br.unisul.aula.trabalho.entidades.Cliente;
import br.unisul.aula.trabalho.entidades.Estadia;

public class EstadiaModel implements IEstadiaModel {
	
	//atributos
	
	private ArrayList<Estadia> estadias;

	
	//construtores
	
	/**
	 * Construtor default.
	 */
	public EstadiaModel() {
		super();
	}

	/**
	 * Construtor com parâmetros.
	 * @param estadias - ArrayList de Estadias
	 */
	public EstadiaModel(ArrayList<Estadia> estadias) {
		super();
		this.estadias = estadias;
	}
	
	
	//métodos principais

	@Override
	public ArrayList<Estadia> buscaEstadia(Cliente c) {
		if(c.getEstadias() != null)
			return c.getEstadias();
			
		return null;
	}

	@Override
	public void cadastraEstadia(Estadia e) {
		this.estadias.add(e);
	}

	@Override
	public ArrayList<Estadia> mostraEstadias() {
		return this.estadias;
	}
	

}
