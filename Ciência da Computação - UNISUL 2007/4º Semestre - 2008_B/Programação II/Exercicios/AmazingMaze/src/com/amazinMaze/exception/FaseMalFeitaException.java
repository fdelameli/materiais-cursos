package com.amazinMaze.exception;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class FaseMalFeitaException extends RuntimeException
{
	// se a fase é carregada com dois jogadores ou duas saídas, isso é disparado
    public FaseMalFeitaException(){
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar a fase.");
     }
}
