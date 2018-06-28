package br.unisul.aula.interfaceXimplementacao;

public class Principal {
	
	public static void main(String[] args) {
		
		IManutencao manutencao = new ManutencaoCarro();
		
		IManutencao manutencao2 = new ManutencaoAviao();
	}

}
