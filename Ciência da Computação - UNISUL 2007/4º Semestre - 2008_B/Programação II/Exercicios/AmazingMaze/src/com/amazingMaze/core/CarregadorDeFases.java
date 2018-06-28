package com.amazingMaze.core;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.amazinMaze.exception.FaseMalFeitaException;
public class CarregadorDeFases{
    
	private int saidaX=0;
	private int saidaY=0;;
	private String[][] matrixDaFase;
	private int qtdColunasDaMatrix;
	private int qtdLinhasDaMatrix;
	
    public void carregaFaseDoArquivo(String nomeDoArquivo)
    {  
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(nomeDoArquivo));            
            String linhaDeTextoDoArquivo;
            int nomeroDaLinha = 0;
            
            while (( linhaDeTextoDoArquivo = entrada.readLine()) != null) {
            	// passa para o carregadorDeMatrix a linha e o número da linha para conversão
                carregaLinhaDaMatrix(linhaDeTextoDoArquivo, nomeroDaLinha);
                nomeroDaLinha++;
            }
         }
        catch (IOException e){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
		}
     }
     
     private void carregaLinhaDaMatrix(String linhaDeTextoDoArquivo, int numeroDaLinha)throws FaseMalFeitaException
     {
         
         if(numeroDaLinha == 0){
        	// se for a primeira linha do arquivo, ele cria a matrix baseada no cabeçalho do arquivo
        	 
        	// conta os espeços em branco
        	 int qtdEspacosEmBranco=0;
             for(int i=0; i<linhaDeTextoDoArquivo.length(); i++){
                 if(linhaDeTextoDoArquivo.charAt(i) ==' '){
                	 qtdEspacosEmBranco+=1;
                	//how many blank spaces between the size of the matrix aka 4 6 or 5  7
                 }
             }
             //**************************
             
             //still handling that possible blank space in the matrix size in the file
             int localizacaoDoEspacoEmBranco = linhaDeTextoDoArquivo.indexOf(" ");
             String qtdColunasString = linhaDeTextoDoArquivo.substring(0,localizacaoDoEspacoEmBranco);
             String qtdLinhasString = linhaDeTextoDoArquivo.substring(localizacaoDoEspacoEmBranco+qtdEspacosEmBranco, linhaDeTextoDoArquivo.length());
             qtdColunasDaMatrix = Integer.parseInt(qtdColunasString);
             qtdLinhasDaMatrix = Integer.parseInt(qtdLinhasString);
             
             // cria a matrix baseado no tamanho do arquivo 
             matrixDaFase=new String[qtdLinhasDaMatrix][qtdColunasDaMatrix];      
          }
          else {
        	// não é a primeira linha do arquivo
        	  
        	char caracter;
			for (int i = 0; i < linhaDeTextoDoArquivo.length(); i++) {
				
				caracter = linhaDeTextoDoArquivo.charAt(i);
				
				if (caracter == '.'){
					// se for ponto muda para N (evita problemas de sistema de arquivos)
					caracter = 'N';
				}

				// grava a posição da saída para usos posteriores
				if (caracter == 'E') {
					saidaX = numeroDaLinha - 1;
					saidaY = i;
					
					// esconde a saida no início da fase
					caracter = 'W';
				}
				
				String caracterString = "" + caracter;
				// preenche a matrix com o caracter lido
				matrixDaFase[numeroDaLinha - 1][i] = caracterString;
			}
		}
     }
     
     public String[][] getMatrixDaFase() {
    	
    	// variáveis para verificação de erros
		int quantidadeDeSaidas = 0;
		int quantidadeDeRatos = 0;
		// ***********************************
		
		for (int i = 0; i < matrixDaFase.length; i++) {
			for (int j = 0; j < matrixDaFase[i].length; j++) {
				if (matrixDaFase[i][j].equals("P")) {
					quantidadeDeRatos += 1;

				} else if (matrixDaFase[i][j].equals("E")) {
					quantidadeDeSaidas += 1;
				}
			}
		}
		
		if (quantidadeDeRatos > 1 || quantidadeDeSaidas > 1) {
			throw new FaseMalFeitaException();
		}

		return matrixDaFase;
	}
     
	 public int getQtdColunasDaMatrix() {
		return qtdColunasDaMatrix;
	}

	public int getQtdLinhasDaMatrix() {
		return qtdLinhasDaMatrix;
	}

	public int getSaidaX() {
		return saidaX;
	}

	public int getSaidaY() {
		return saidaY;
	}

	public int getTotalDeDiamantesDaFase() {
		int totalDimonds = 0;
		for (int i = 0; i < matrixDaFase.length; i++) {
			for (int j = 0; j < matrixDaFase[i].length; j++) {
				if (matrixDaFase[i][j].equals("D")
						|| matrixDaFase[i][j].equals("H"))
					totalDimonds += 1;
			}
		}
		return totalDimonds;
	}
	
	public int getTotalDeCaminhosDaFase() {
		int totalCaminhos = 0;
		for (int i = 0; i < matrixDaFase.length; i++) {
			for (int j = 0; j < matrixDaFase[i].length; j++) {
				if (matrixDaFase[i][j].equals("N"))
					totalCaminhos += 1;
			}
		}
		return totalCaminhos;
	}
	
    public void getLevelMessage(int lvl){
  	  try {
			BufferedReader in = new BufferedReader(new FileReader("fases\\level"+lvl+".msg"));            
			  String msg = "";
			  String buff = "";
			  while((buff = in.readLine()) != null)
				  msg += buff;
			  JOptionPane.showMessageDialog(null, msg, "Topolino diz:",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("imagens\\topoicon.png"));
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
    
    
}