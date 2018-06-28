package com.amazingMaze.core;

public class CalculadorDeTempo {
	int minutos = 0;
	int segundos = 0;

	/*
	 * Esse metodo calcula o tempo que o jogador tem para cada fase baseado no
	 * tamanho da fase a na quantidade de diamantes.
	 */
	public void calculaTempoDoLabirinto(int totalDecaminhos,
			int totalDeDiamantes, int xSize, int ySize) {
		// esse metodo deve ser modificado para providenciar um sistema de tempo
		// mais realistico

		segundos = (totalDecaminhos / 2 + totalDeDiamantes);
		if (segundos > 60) {
			minutos = segundos / 60;
			segundos = 0;
		}
	}

	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}
}// fim da classe
