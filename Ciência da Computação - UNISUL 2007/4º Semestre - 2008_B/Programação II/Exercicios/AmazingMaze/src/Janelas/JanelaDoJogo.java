package Janelas;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import com.amazinMaze.exception.DevagarDemaisException;
import com.amazingMaze.core.ArmazenadorDeTempo;
import com.amazingMaze.core.AtualizadorDeTiles;
import com.amazingMaze.core.CalculadorDeTempo;
import com.amazingMaze.core.CarregadorDeFases;

@SuppressWarnings("serial")
public class JanelaDoJogo extends JFrame{

	private int levalAtualComZeroNaFrente = 01;
	private int levelAtual = 1;
	
	private Container container;
	private CarregadorDeFases fase = new CarregadorDeFases();

	private int segundos;
	private int jx;
	private int timeLeft;
	private JPanel progBarPanel;
	private JLabel[][] labelMatrix;
	private CalculadorDeTempo calculadorDeTempo;
	private JProgressBar progressBar;
	private MazeObject mazeObject;
	private JPanel newPanel;
	private AtualizadorDeTiles atualizadosDeTiles = new AtualizadorDeTiles();
	private String[][] matrixAtual;
	private Timer timely;
	private ArmazenadorDeTempo timeKeeper;
	Action updateCursorAction = new AbstractAction() {
		// classe gera uma excessão se o jogador demorar demais para terminar o nivel.
		public void actionPerformed(ActionEvent e) throws DevagarDemaisException
		{
			segundos -= 1;
			jx += 1;
			if (segundos < 0) {
				segundos = 60;
				timeLeft -= 1;
			}
			if (timeLeft == 0 && segundos == 0) {
				timely.stop();
//				JLabel yousuckLabel = new JLabel("", new ImageIcon(
//						"imagens\\gameover.jpg"), JLabel.LEFT);
//				container.add(yousuckLabel);
//				remove(newPanel);
//				remove(progBarPanel);
//				pack();
//				setVisible(true);
				timely.stop();
				levalAtualComZeroNaFrente -= 01;
				if (levalAtualComZeroNaFrente < 01)
					throw new DevagarDemaisException("Game Over");
				else
					loadMatrixGui("newLoad");
			}
			progressBar.setValue(jx);
			progressBar.setString(timeLeft + ":" + segundos);
		}
	};
	

	public JanelaDoJogo() {
		super("The Amazing Maze");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = getContentPane();
		
		newPanel = new JPanel();
		timeKeeper = new ArmazenadorDeTempo();

		pack(); // ajeita o tamanho da tela
		setVisible(true);
		
		
		// Carrega a primeira fase
		fase.carregaFaseDoArquivo("./fases/level1.maz");
		atualizadosDeTiles.setExit(fase.getSaidaX(), fase.getSaidaY());
		loadMatrixGui("newLoad");
		fase.getLevelMessage(1);
		// **************************************
		
	}// termina o construtor

	// captura o movimento das teclas
	private class KeyListner extends KeyAdapter 
	{
		public void keyPressed(KeyEvent theEvent) {
			switch (theEvent.getKeyCode()) {
			case KeyEvent.VK_UP: {
				// informa que o opolino se moveu.
				atualizadosDeTiles.atualizaMatrixDeTiles(-1, 0, matrixAtual, fase.getTotalDeDiamantesDaFase());
				// Recarrega a GUI para mostrar o resultado
				loadMatrixGui("updateLoad");
				if (atualizadosDeTiles.getAtualizaLevel() == true) {
					carregaProximaFase();
				}
				break;
			}
			case KeyEvent.VK_DOWN: {
				// ver acima
				atualizadosDeTiles.atualizaMatrixDeTiles(1, 0, matrixAtual, fase.getTotalDeDiamantesDaFase());
				// ver acima
				loadMatrixGui("updateLoad");
				// ver acima
				if (atualizadosDeTiles.getAtualizaLevel() == true){
					carregaProximaFase();
				}
				break;
			}
			case KeyEvent.VK_LEFT: {
				// ver acima
				atualizadosDeTiles.atualizaMatrixDeTiles(0, -1, matrixAtual, fase.getTotalDeDiamantesDaFase());
				// ver acima
				loadMatrixGui("updateLoad");
				// ver acima
				if (atualizadosDeTiles.getAtualizaLevel() == true){
					carregaProximaFase();
				}
				break;
			}
			case KeyEvent.VK_RIGHT: {
				// ver acima
				atualizadosDeTiles.atualizaMatrixDeTiles(0, 1, matrixAtual, fase.getTotalDeDiamantesDaFase()); 
				// ver acima
				loadMatrixGui("updateLoad");
				if (atualizadosDeTiles.getAtualizaLevel() == true) {
					carregaProximaFase();
				}
				break;
			}
			}// fim do switch
			// mostra quantos queijos ainda estão sobrando na GUI
			JLabel mainLabel = new JLabel("Queijos Restantes: "
					+ atualizadosDeTiles.getDimondsLeft() + "", JLabel.CENTER);
			JPanel dimondsPanel = new JPanel();
			dimondsPanel.add(mainLabel);
			container.add(dimondsPanel, BorderLayout.SOUTH);
		}// fim do método
	}// fim da classe interna


	public void loadMatrixGui(String event) {
		if (event == "newLoad") {
			// remove o último nível da tela
			remove(newPanel);
			if (progBarPanel != null){
				// remove a barra de progresso da tela desde que ela já tenha sido criada
				remove(progBarPanel);
			}
			String[][] temp = fase.getMatrixDaFase();
			matrixAtual = new String[fase.getQtdLinhasDaMatrix()][fase
					.getQtdColunasDaMatrix()];
			for (int i = 0; i < matrixAtual.length; i++) {
				for (int j = 0; j < matrixAtual[i].length; j++) {
					// cria uma nova matrix, para que não tenhamos as referencias da matrix antiga!
					matrixAtual[i][j] = temp[i][j];
				}
			}
			// cria o calculador de tempo para determinar quanto tempo para cado nivel é dado.
			calculadorDeTempo = new CalculadorDeTempo();
			// passa os parametros para o calculo
			calculadorDeTempo.calculaTempoDoLabirinto(fase.getTotalDeCaminhosDaFase(),fase.getTotalDeDiamantesDaFase(), fase
					.getQtdLinhasDaMatrix(), fase.getQtdColunasDaMatrix());
			// pega os minutos e os segundos permitidos pro nivel
			timeLeft = calculadorDeTempo.getMinutos();
			segundos = calculadorDeTempo.getSegundos();
			// reset the variable used for keeping time to zero since its a new level
			jx = 0;
			// create a timer to update the progress bar
			timely = new Timer(1000, updateCursorAction);
			timely.start();// start the timer
			progBarPanel = new JPanel();// panel for progress bar
			// minutes returns a single digit, we have to multiply it for Bar.
			progressBar = new JProgressBar(0, calculadorDeTempo.getMinutos() * 100);
			progressBar.setStringPainted(true);
			progBarPanel.add(progressBar);
			container.add(progBarPanel, BorderLayout.NORTH);
			newPanel = new JPanel();
			// set our panel for the game to the size of the matrix
			newPanel.setLayout(new GridLayout(fase.getQtdLinhasDaMatrix(),
					fase.getQtdColunasDaMatrix()));
			labelMatrix = new JLabel[fase.getQtdLinhasDaMatrix()][fase
					.getQtdColunasDaMatrix()];
			newPanel.addKeyListener(new KeyListner());
		}// end if
		else if (event == "updateLoad")	{
			// every time the player moves the gui must be updated.
			// get the new matrix to be	displayed from the architect
			matrixAtual = atualizadosDeTiles.getMatrixAtualizada();
			remove(newPanel);// remove the old game
			newPanel = new JPanel();
			newPanel.setLayout(new GridLayout(fase.getQtdLinhasDaMatrix(),
					fase.getQtdColunasDaMatrix()));
			newPanel.addKeyListener(new KeyListner());
			newPanel.grabFocus();
		}
		for (int i = 0; i < labelMatrix.length; i++) {
			for (int j = 0; j < labelMatrix[i].length; j++) {
				mazeObject = new MazeObject(matrixAtual[i][j]);// add our maze
																// images into
																// the gui
				labelMatrix[i][j] = mazeObject;
			}
		}// end double for loop
		container.add(newPanel);
		System.gc();// force java to clean up memory use.
		pack();
		setVisible(true);
		newPanel.grabFocus();
	}// end loadMatrixGui method

	// Classe interna para cada objeto do jogo( queijo, parede, topolino...)
	public class MazeObject extends JLabel
	{
		public MazeObject(String fileName) {
			String result = "imagens\\";
			result += fileName + ".png";
			JLabel label;
			label = new JLabel("", new ImageIcon(result), JLabel.LEFT);
			newPanel.add(label);
		}
	}

	public void carregaProximaFase() {
		levelAtual += 1;
		if(levelAtual == 5){
			timely.stop();
			JOptionPane.showMessageDialog(null, "Topolino conseguiu o queijo da cura, e pode salvar seu avô! \nParabéns!","FIM DE JOGO!!",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("imagens\\fim.jpg"));
			System.exit(0);
		}
		levalAtualComZeroNaFrente += 01;
		
		// Vai acumulando o tempo total do jogador(para os scores)
		timeKeeper.incrementaTempo(timeLeft, segundos);
		timely.stop();// dont count while we are loading the next level.
		// flush everything from TheArchitect so we dont get goffee results
		atualizadosDeTiles = new AtualizadorDeTiles();
		// the next file to be loaded (number)
		
		String nomeDaFaseaSerCarregada = "./fases/level" + levalAtualComZeroNaFrente + ".maz";
		System.gc();
		// carrega o arquivo
		fase.carregaFaseDoArquivo(nomeDaFaseaSerCarregada);
		// pega a matrix do proximo level
		matrixAtual = fase.getMatrixDaFase();
		atualizadosDeTiles.setExit(fase.getSaidaX(), fase.getSaidaY());
		loadMatrixGui("newLoad");
		fase.getLevelMessage(levelAtual);
	}

	

}//
