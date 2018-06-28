package com.amazingMaze.core;
public class ArmazenadorDeTempo{
	
	int minutos=0; 
	int segundos=0;
	
    public void incrementaTempo(int min, int sec) {
		if (sec + segundos <= 60) {
			minutos += min;
			segundos = sec + segundos;
		} else {
			minutos += min;
			minutos += 1 * ((sec + segundos) / 60);
			segundos = (sec + segundos) % 60;
		}
	}
	
	public int getMinutos() {
		return minutos;
	}

	public int getSegundos() {
		return segundos;
	}
}
