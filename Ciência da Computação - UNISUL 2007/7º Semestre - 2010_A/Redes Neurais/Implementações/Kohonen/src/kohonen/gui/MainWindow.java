package kohonen.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import kohonen.RedeKohonen1;
import kohonen.RedeKohonen2;

/**
 * Classe que representa a interface gráfica do usuário (GUI).
 * @author Fabio Dela Bruna
 */
public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton buttonIniciarAprendizadoRede1;
	private JButton buttonIniciarAprendizadoRede2;
	private JButton buttonTestarRedeKohonen1;
	private JButton buttonTestarRedeKohonen2;
	private JTextArea textArea;
	private RedeKohonen1 redeRK1;
	private RedeKohonen2 redeRK2;

	/**
	 * Construtor da classe.
	 */
	public MainWindow() {
		initComponents();
	}

	/**
	 * Monta todos os componentes da interface gráfica.
	 */
	private void initComponents() {

		setTitle("Redes Neurais - Rede de Kohonen");
		setSize(555, 400);

		Font f = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 16);
		Font f2 = new Font(Font.MONOSPACED, Font.BOLD, 14);

		buttonIniciarAprendizadoRede1 = new JButton("Treinar Rede Kohonen 1");
		buttonIniciarAprendizadoRede1.setToolTipText("Rede de Kohonen sem estrutura topológica");
		buttonIniciarAprendizadoRede1.setFont(f);
		buttonIniciarAprendizadoRede1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(atualizaTextArea(null));
				redeRK1 = new RedeKohonen1();
				iniciaAprendizadoRK1();
				textArea.setText(atualizaTextArea(e));
				textArea.setSelectionStart(0); // pequena gambiarra para o
												// scroll panel
				textArea.setSelectionEnd(1); // não ir pro final.
				buttonTestarRedeKohonen1.requestFocus();
			}
		});
		
		buttonIniciarAprendizadoRede2 = new JButton("Treinar Rede Kohonen 2");
		buttonIniciarAprendizadoRede2.setToolTipText("Rede de Kohonen com estrutura linear");
		buttonIniciarAprendizadoRede2.setFont(f);
		buttonIniciarAprendizadoRede2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(atualizaTextArea(null));
				redeRK2 = new RedeKohonen2();
				iniciaAprendizadoRK2();
				textArea.setText(atualizaTextArea(e));
				textArea.setSelectionStart(0); // pequena gambiarra para o
												// scroll panel
				textArea.setSelectionEnd(1); // não ir pro final.
				buttonTestarRedeKohonen1.requestFocus();
			}
		});
		

		buttonTestarRedeKohonen1 = new JButton("Testar Rede Kohonen 1");
		buttonTestarRedeKohonen1.setToolTipText( "Testa a rede de Kohonen sem estrutura topológica" );
		buttonTestarRedeKohonen1.setFont(f);
		buttonTestarRedeKohonen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testarRede(e);
			}
		});
		
		buttonTestarRedeKohonen2 = new JButton("Testar Rede Kohonen 2");
		buttonTestarRedeKohonen2.setToolTipText( "Testa a rede de Kohonen com estrutura linear" );
		buttonTestarRedeKohonen2.setFont(f);
		buttonTestarRedeKohonen2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testarRede(e);
			}
		});

		textArea = new JTextArea(atualizaTextArea(null));
		textArea.setEditable(false);
		textArea.setOpaque(false);
		textArea.setTabSize(4);
		textArea.setFont(f2);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBorder(BorderFactory.createTitledBorder(" Matriz de Pesos "));

		
		JPanel leftPanel = new JPanel(new BorderLayout());
		leftPanel.add(buttonIniciarAprendizadoRede1, BorderLayout.NORTH);
		leftPanel.add(buttonTestarRedeKohonen1, BorderLayout.SOUTH);
		
		
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.add(buttonIniciarAprendizadoRede2, BorderLayout.NORTH);
		rightPanel.add(buttonTestarRedeKohonen2, BorderLayout.SOUTH);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.add(leftPanel, BorderLayout.EAST);
		centerPanel.add(rightPanel, BorderLayout.WEST);

		getContentPane().add(centerPanel, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);

		// Posiciona a janela no centro da tela.
		int screenX = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		int screenY = (int) Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();

		int frameX = (int) getSize().getWidth();
		int frameY = (int) getSize().getHeight();

		setLocation((int) (screenX / 2) - (frameX / 2), (int) (screenY / 2)
				- (frameY / 2));
		// .
		

	}

	/**
	 * Chama o método da classe kohonen.RedeKohonen1 para iniciar o
	 * aprendizado da rede.
	 */
	private void iniciaAprendizadoRK1() {
		try {
			redeRK1.treinaRede();
			JOptionPane.showMessageDialog(this, new JLabel(
					"Treinamento da rede concluído com sucesso.",
					SwingConstants.CENTER), "Sucesso!",
					JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro!",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Chama o método da classe kohonen.RedeKohonen2 para iniciar o
	 * aprendizado da rede.
	 */
	private void iniciaAprendizadoRK2() {
		try {
			redeRK2.treinaRede();
			JOptionPane.showMessageDialog(this, new JLabel(
					"Treinamento da rede concluído com sucesso.",
					SwingConstants.CENTER), "Sucesso!",
					JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	
	/**
	 * Chama o método da classe rede.RedeHeteroassociativa para testar a rede
	 * neural com um arquivo de teste.
	 */
	private void testarRede(ActionEvent e) {
		
		File[] arquivos = new File("arquivos/testes").listFiles();
		String result = "";
		
		try {
			
			if (e.getSource() == buttonTestarRedeKohonen1) {
				result = redeRK1.testaRede( arquivos );
			} else if (e.getSource() == buttonTestarRedeKohonen2) {
				result = redeRK2.testaRede( arquivos );
			}
		
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(this, ioe.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
		JOptionPane.showMessageDialog(this, result, "Resultado", JOptionPane.PLAIN_MESSAGE);
//		System.out.println(result);
			
	}

	

	/**
	 * Atualiza a matriz de pesos.
	 */
	private String atualizaTextArea(ActionEvent e) {
		double[][] W = inicializaMatrizPesosZerada();
		if (e == null)
			;// nao faz nada
		else if (e.getSource() == buttonIniciarAprendizadoRede1)
			W = redeRK1.getMatrizPesos();
		else if (e.getSource() == buttonIniciarAprendizadoRede2)
			W = redeRK2.getMatrizPesos();
		
		String pesos = "";
		for (int i = 0; i < W.length; i++) {
			for (int j = 0; j < W[i].length; j++) {
				String aux = "";
				if (W[i][j] >= 0)
					aux = " " + String.format("%.3f", W[i][j]);
				else
					aux = String.format("%.3f", W[i][j]) + "";

				if (j != W[i].length - 1)
					pesos += (aux + "\t");
				else
					pesos += (aux + "\n");
			}
		}
		return pesos;
	}
	
	
	/**
	 * Dá valores iniciais zerados para a matriz de pesos.
	 * @return
	 */
	private double[][] inicializaMatrizPesosZerada() {
		double W[][] = new double[63][25];
		for (int i = 0; i < W.length; i++) {
			for (int j = 0; j < W[i].length; j++) {
				W[i][j] = 0;
			}
		}
		return W;
	}

}
