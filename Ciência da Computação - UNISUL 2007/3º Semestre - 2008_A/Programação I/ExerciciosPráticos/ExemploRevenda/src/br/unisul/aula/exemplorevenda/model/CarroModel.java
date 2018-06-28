package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.exemplorevenda.entidade.Carro;


/**
 * Classe de negócio.
 * @author Fabio Dela Bruna
 * @since 29/04/2008
 */
public class CarroModel implements ICarroModel {
	
	// atributos
	private ArrayList<Carro> carros;
	
	
	// construtores
	
	/**
	 * Construtor default
	 */
	public CarroModel(){
		super();
	}

	/**
	 * Construtor com parâmetros
	 * @param carros - ArrayList de carros.
	 */
	public CarroModel(ArrayList<Carro> carros){
		super();
		this.carros = carros;
	}

	
	//métodos principais
	
	@Override
	public void insereCarro(Carro c) {
		if(validaCarro(c))
			this.carros.add(c);
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados do Carro",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void atualizaCarro(Carro antigo, Carro novo) {
		if(validaCarro(novo))
			antigo = novo;
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados do Carro",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void removeCarro(Carro c) {
		this.carros.remove(c);
	}

	@Override
	public Carro buscaCarro(String placa, String chassi) {
		if((placa != null && placa.length() != 0) && chassi == null){
			for(Carro c : this.carros){
				if(c.getPlaca().equals(placa)){
					return c;
				}
			}
		}else if(chassi != null && chassi.length() != 0){
			for(Carro c : this.carros){
				if(c.getClass().equals(chassi)){
					return c;
				}
			}
		}else if((chassi != null && chassi.length() != 0) && (placa != null && placa.length() != 0)){
			for(Carro c : this.carros){
				if(c.getNumeroChassi().equals(chassi) && c.getPlaca().equals(placa)){
					return c;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<Carro> mostraCarros() {
		return this.carros;
	}
	
	/**
	 * Verifica se todos os atributos obrigatórios estão devidamente preenchidos.
	 * @param c - carro
	 * @return - false or true.
	 */
	private boolean validaCarro(Carro c){
		if(c == null)
			return false;
		if(c.getMarca() == null || c.getMarca().length() <= 1)
			return false;
		if(c.getPlaca() == null || c.getPlaca().length() != 8)
			return false;
		if(c.getNumeroChassi() == null || c.getNumeroChassi().length() == 0)
			return false;
		if(c.getCor() == null || c.getCor().length() == 0)
			return false;
		if(c.getAnoFabricacao() < 1915)
			return false;
		if(c.getAnoModelo() < 1915)
			return false;
		if(c.getTipoCombustivel() == null || c.getTipoCombustivel().length() == 0)
			return false;
		
		return true;
	}
}
