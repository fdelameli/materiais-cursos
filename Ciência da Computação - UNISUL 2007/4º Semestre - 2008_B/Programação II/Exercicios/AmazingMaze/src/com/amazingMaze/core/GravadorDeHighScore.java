package com.amazingMaze.core;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class GravadorDeHighScore {

	private static final String NOME_DO_ARQUIVO = "scores.txt";

	// prints the highscore data to scores.txt
	public void addHighScore(String name, int min, int sec, int level){
		try {
			String outData = "PlayerName: " + name + " Total Time for Levels:"
					+ min + ":" + sec + "(Minutes:Seconds)" + "Level Reached:*"
					+ level;
			PrintWriter out = new PrintWriter(new FileOutputStream(NOME_DO_ARQUIVO, true));
			out.println("");
			out.println(outData);
			out.close();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

