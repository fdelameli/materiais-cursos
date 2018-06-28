package com.amazingMaze.core;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class AtualizadorDeTiles extends JFrame {

	int foundPlayer = 0;
	
	String[][] matrixDeTiles;
	int saidaX;
	int saidaY;
	
	int qtdDiamantesColetados = 0;
	boolean atualizaLevel;
	int qtdDiamentesDaFase = 0;

	public void setExit(int x, int y){
		// grava a localização da saida
		saidaX = x;
		saidaY = y;
	}

	// usado na hora de mostrar a saida
	public void mostraSaida() {
		matrixDeTiles[saidaX][saidaY] = "E";
	}

	/*
	 * Esse método contem toda a detecção de colisão
	 */
	public void atualizaMatrixDeTiles(int xScale, int yScale, String[][] tilesAtual, int qtdDiamantesDaFase){

		try {
			// *** grava a posição do jogador ***
			int x = 0; 
			int y = 0;
			for (int i = 0; i < tilesAtual.length; i++)
			{
				for (int j = 0; j < tilesAtual[i].length; j++) {
					if (tilesAtual[i][j].equals("P")){
						// achou o jogador
						x = i;
						y = j;
						break;
					}
				}
			}
			//*******************************
			
			// use this later for the gui dimond count
			this.qtdDiamentesDaFase = qtdDiamantesDaFase;
			setAtualizaLevel(false); // não deve ir para a proxima fase ainda
			
			
			
			/*
			 * Depois que a posição do jogador foi encontrada,
			 * nós verificamos onde ele está.
			 */
			// se estiver em cima de um diamante escondido ou um diamante normal
			if (tilesAtual[x + xScale][y + yScale].equals("H") || tilesAtual[x + xScale][y + yScale].equals("D"))
			{
				tilesAtual[x][y] = "N";
				tilesAtual[x + xScale][y + yScale] = "P";
				
				// incrementa o numero de diamantes coletados
				qtdDiamantesColetados += 1;
				// its a dimond
			} else if (tilesAtual[x + xScale][y + yScale].equals("M")&& tilesAtual[x + (xScale * 2)][y + (yScale * 2)].equals("N")){
				// quando é possivel mover uma parede que se move
					tilesAtual[x][y] = "N";
					tilesAtual[x + xScale][y + yScale] = "P";
					tilesAtual[x + (xScale * 2)][y + (yScale * 2)] = "M";
				
			} else if (tilesAtual[x + xScale][y + yScale].equals("N")){
				// movimento normal pelo laberinto
				tilesAtual[x][y] = "N";
				tilesAtual[x + xScale][y + yScale] = "P";
				
			} else if (tilesAtual[x + xScale][y + yScale].equals("E")){
				// Se for a saida
				tilesAtual[x][y] = "N";
				tilesAtual[x + xScale][y + yScale] = "P";
				// carrega o proximo nivel
				setAtualizaLevel(true);
			} else {
				// colisão
			}

			// se tiver todos os diamantes, mostra a saida
			if (qtdDiamantesColetados == qtdDiamantesDaFase){
				mostraSaida();
			}

			// atualiza a matrixDeTiles
			matrixDeTiles = tilesAtual;
		} catch (RuntimeException e) {
			//ignora
		} 
	}// end method

	public void setAtualizaLevel(boolean atualizaLevel){
		this.atualizaLevel = atualizaLevel;
	}

	public boolean getAtualizaLevel(){
		return atualizaLevel;
	}

	public int getDimondsLeft() {
		// usado na interface, mostra quandos diamantes ainda estao faltando
		return qtdDiamentesDaFase - qtdDiamantesColetados;
	}

	public String[][] getMatrixAtualizada(){
		// retorna a matrix atualizada para a interface mostrar
		return matrixDeTiles;
	}
}// end class
