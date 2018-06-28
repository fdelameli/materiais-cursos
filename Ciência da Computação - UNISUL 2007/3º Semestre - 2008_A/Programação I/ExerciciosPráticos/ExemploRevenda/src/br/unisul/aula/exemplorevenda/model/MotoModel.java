package br.unisul.aula.exemplorevenda.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.unisul.aula.exemplorevenda.entidade.Moto;

/**
 * Classe de negócio.
 * @author Fabio Dela Bruna
 * @since 29/04/2008
 */
public class MotoModel implements IMotoModel {
	
	// atributos
	private ArrayList<Moto> motos;
	
	
	// construtores
	
	/**
	 * Construtor default
	 */
	public MotoModel(){
		super();
	}

	/**
	 * Construtor com parâmetros
	 * @param carros - ArrayList de carros.
	 */
	public MotoModel(ArrayList<Moto> motos){
		super();
		this.motos = motos;
	}

	
	// métodos principais
	
	@Override
	public void atualizaMoto(Moto antiga, Moto nova) {
		if(validaMoto(nova))
			antiga = nova;
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados da Moto",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void insereMoto(Moto m) {
		if(validaMoto(m))
			this.motos.add(m);
		else
			JOptionPane.showMessageDialog(null, "Verifique os dados da Moto",
					"Erro de cadastro", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public void removeMoto(Moto m) {
		this.motos.remove(m);
	}

	@Override
	public Moto buscaMoto(String placa, String chassi) {
		if((placa != null && placa.length() != 0) && chassi == null){
			for(Moto m : this.motos){
				if(m.getPlaca().equals(placa)){
					return m;
				}
			}
		}else if(chassi != null && chassi.length() != 0){
			for(Moto m : this.motos){
				if(m.getClass().equals(chassi)){
					return m;
				}
			}
		}else if((chassi != null && chassi.length() != 0) && (placa != null && placa.length() != 0)){
			for(Moto m : this.motos){
				if(m.getNumeroChassi().equals(chassi) && m.getPlaca().equals(placa)){
					return m;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<Moto> mostraMotos() {
		return this.motos;
	}
	
	/**
	 * Verifica se todos os atributos obrigatórios estão devidamente preenchidos.
	 * @param m - Moto
	 * @return - false or true.
	 */
	private boolean validaMoto(Moto m){
		if(m == null)
			return false;
		if(m.getMarca() == null || m.getMarca().length() <= 1)
			return false;
		if(m.getPlaca() == null || m.getPlaca().length() != 8)
			return false;
		if(m.getNumeroChassi() == null || m.getNumeroChassi().length() == 0)
			return false;
		if(m.getCor() == null || m.getCor().length() == 0)
			return false;
		if(m.getAnoFabricacao() < 1915)
			return false;
		if(m.getAnoModelo() < 1915)
			return false;
		if(m.getTipoCombustivel() == null || m.getTipoCombustivel().length() == 0)
			return false;
		
		return true;
	}

}
