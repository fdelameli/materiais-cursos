package br.unisul.aula.classes;

import java.util.ArrayList;


/**
 * Classe que contém métodos para funcionamento do programa.
 * @author Fabio Dela Bruna
 * @since 17/04/2008
 */
public class Metodos {
	
	
	// Métodos principais
	
	/**
	 * Método que retorna o percentual de acidentes
	 * em que houve vítimas fatais
	 */
	public static double percentualAcidentesVitimasFatais(ArrayList acidentes){
		short qtdAcidentes = 0;
		for (int i = 0; i < acidentes.size() ; i++) {
			//Acidente temp = (Acidente) acidentes.get(i);
			if(((Acidente) acidentes.get(i)).isVitimasFatais()){
				qtdAcidentes++;
			}
		}
		return ((qtdAcidentes*100) / acidentes.size());
	}
	
	/**
	 * Método que retorna o percentual de acidentes
	 * em que os envolvidos eram menores de 18 anos.
	 */
	public static double percentualAcidentesMenoresIdade(ArrayList acidentes){
		short qtdAcidentes = 0;
		for (int i = 0; i < acidentes.size(); i++) {
			Acidente temp = (Acidente) acidentes.get(i);
			if(temp.getPessoa().getIdade() < 18)
				qtdAcidentes++;
		}
		return ((qtdAcidentes*100) / acidentes.size());
	}
	
	/**
	 * Método que retorna o percentual de embriagados
	 */
	public static double percentualEmbriagados(ArrayList acidentes){
		short qtdEmbriagados = 0;
		for (int i = 0; i < acidentes.size() ; i++) {
			Acidente temp = (Acidente) acidentes.get(i);
			if(temp.getPessoa().isEmbriagado())
				qtdEmbriagados++;
		}
		return ((qtdEmbriagados*100) / acidentes.size());
	}
	
	/**
	 * Método que verifica a quantidade de acidentes
	 * que ocorreram no período do carnaval.
	 */
	public static short qtdAcidentesCarnaval(ArrayList acidentes){
		short qtdAcidentes = 0;
		for (int i = 0; i < acidentes.size(); i++) {
			Acidente temp = (Acidente) acidentes.get(i);
			String auxMes = temp.getData().substring(3, 5);
			if(auxMes.equals("02"))
				qtdAcidentes++;
		}
		return qtdAcidentes;
	}
	
	/**
	 * Verifica a quantidade de acidentes que envolveram
	 * condutores de outro estado.
	 */
	public static short qtdAcidentesOutroEstado(ArrayList acidentes){
		short qtdAcidentes = 0;
		for (int i = 0; i < acidentes.size(); i++) {
			Acidente temp = (Acidente) acidentes.get(i);
			if(temp.getPessoa().getEstado().equals("SANTA CATARINA")){
			}else{
				qtdAcidentes++;
			}
		}
		return qtdAcidentes;
	}
	
	/**
	 * Verifica o percentual de mulheres envolvidadas em acidentes.
	 */
	public static double pencetualMulheresAcidentes(ArrayList acidentes){
		short qtdMulheres = 0;
		for (int i = 0; i < acidentes.size(); i++) {
			Acidente temp = (Acidente) acidentes.get(i);
			if(temp.getPessoa().getSexo() == 'F')
				qtdMulheres++;
		}
		return ((qtdMulheres*100) / acidentes.size());
	}
	
	/**
	 * Verifica o percentual de homens envolvidados em acidentes.
	 */
	public static double pencetualHomensAcidentes(ArrayList acidentes){
		short qtdHomens = 0;
		for (int i = 0; i < acidentes.size(); i++) {
			Acidente temp = (Acidente) acidentes.get(i);
			if(temp.getPessoa().getSexo() == 'M')
				qtdHomens++;
		}
		return ((qtdHomens*100) / acidentes.size());
	}
	
	/**
	 * Verifica quantos acidentes com motocicletas
	 * tiveram vítmas fatais.
	 * 
	 * OBS: 1-automovel / 2-motocicleta / 3-bicicleta
	 */
	public static short qtdAcidenteMotocicletasVitimasFatais(ArrayList acidentes){
		short qtdAcidentes = 0;
		for (int i = 0; i < acidentes.size(); i++) {
			Acidente temp = (Acidente) acidentes.get(i);
			if(temp.getTipoVeiculo() == 2){
				if(temp.isVitimasFatais())
					qtdAcidentes++;
			}
		}
		return qtdAcidentes;
	}
	
}
