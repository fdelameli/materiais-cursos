package aula03.arrayList.exercicios.exe01;

import java.util.ArrayList;

public class Metodos {
	
	// fazer para returna um produto  (PRODUTO)
	public static String produtoBaixoGiroValorMaisAlto(ArrayList<Produto> p){
		double valorMaisAlto = 0;
		String temp = "";
		for (int i = 0; i < p.size(); i++) {
			Produto aux = (Produto) p.get(i);
			if(aux.getRotatividade() == 2){
				if(aux.getValor() > valorMaisAlto)
					valorMaisAlto = aux.getValor();
					temp = aux.getNome();
			}
		}
		return temp;
	}
	
	
	public static String produtoAltoGiroValorMaisBaixo(ArrayList<Produto> p){
		double valorMaisBaixo = 99999999;
		String temp = "";
		for (int i = 0; i < p.size(); i++) {
			Produto aux = (Produto) p.get(i);
			if(aux.getRotatividade() == 1){
				if(aux.getValor() < valorMaisBaixo)
					valorMaisBaixo = aux.getValor();
					temp = aux.getNome();
			}
		}
		return temp;
	}
	
	
	public static double somatorioBaixoGiro (ArrayList<Produto> p){
		double somatorio = 0;
		for (int i = 0; i < p.size(); i++) {
			Produto aux = (Produto) p.get(i);
			if(aux.getRotatividade() == 2){
				somatorio += aux.getValor();
			}
		}
		return somatorio;
	}
	
	
	public static double somatorioAltoGiro (ArrayList<Produto> p){
		double somatorio = 0;
		for (int i = 0; i < p.size(); i++) {
			Produto aux = (Produto) p.get(i);
			if(aux.getRotatividade() == 1){
				somatorio += aux.getValor();
			}
		}
		return somatorio;
	}

}