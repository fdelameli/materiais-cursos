import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Grafo extends JFrame
{
	private JButton btnVerificar = new JButton();
	private JLabel jLabel1 = new JLabel();
	private JTextField txfSentenca = new JTextField();
	private String[] alfabeto = {};
	private String[] estados = {};
	private String[] estadosReconhecedores = {};
	private String[][] matrizTransicao = new String[0][0];
	private String estadoInicial = "";
	private String estadoAtual;

	private final int TRANSICAO_ENCONTRADA  = 0;
	private final int ENTRADA_INEXISTENTE   = 1;
	private final int TRANSICAO_INEXISTENTE = 2;

	public Grafo()
	{
		try
		{
			iniciaPrograma();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void iniciaPrograma() throws Exception
	{
		this.getContentPane().setLayout(null);
		this.setSize(new Dimension(400, 155));
		this.setTitle("Programa reconhecedor");
		this.setResizable(false);
		btnVerificar.setText("Verificar");
		btnVerificar.setBounds(new Rectangle(145, 80, 105, 35));
		btnVerificar.setMnemonic('V');
		btnVerificar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				btnVerificar_actionPerformed(e);
				}
			});
		jLabel1.setText("Sentença");
		jLabel1.setBounds(new Rectangle(15, 20, 195, 15));
		txfSentenca.setBounds(new Rectangle(15, 35, 365, 20));
		this.getContentPane().add(txfSentenca, null);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(btnVerificar, null);
		inicializaAutomato();
	}

	private void inicializaAutomato()
	{
		for (int i=0; i<alfabeto.length; i++)
			for (int j=0; j<estados.length; j++)
				matrizTransicao[i][j] = null;
	}

	private int executaTransicao(String entrada)
	{
		int resultado = TRANSICAO_INEXISTENTE;
		int indEntrada, indEstado;
		indEntrada = getIndiceEntrada(entrada);
		if (indEntrada==-1)
			return ENTRADA_INEXISTENTE;
		indEstado = getIndiceEstado(estadoAtual);
		String estadoSaida = matrizTransicao[indEntrada][indEstado];
		if (estadoSaida!=null)
		{
			estadoAtual = estadoSaida;
			resultado = TRANSICAO_ENCONTRADA;
		}

		return resultado;
	}
	private int getIndiceEntrada(String entrada)
	{
		for (int i=0; i<alfabeto.length; i++)
			if (alfabeto[i].equals(entrada))
			return i;

		return -1;
	}

	private int getIndiceEstado(String estado)
	{
		for (int i=0; i<estados.length; i++)
			if (estados[i].equals(estado))
				return i;

		return -1;
	}

	private void btnVerificar_actionPerformed(ActionEvent e)
	{
		String valorEntrada = txfSentenca.getText();
		String entradaAtual = null;
		int resultado = TRANSICAO_ENCONTRADA;
		int i=0;
		estadoAtual = estadoInicial;
		while ( (i<valorEntrada.length()) && (resultado==TRANSICAO_ENCONTRADA) )
		{
			entradaAtual = valorEntrada.charAt(i) + "";
			resultado = executaTransicao(entradaAtual);
			i++;
		}
		switch(resultado)
		{
			case TRANSICAO_INEXISTENTE : JOptionPane.showMessageDialog(null, "Não foi possível encontrar uma transição com a entrada \"" + entradaAtual + "\".\nSentença não reconhecida!", "Resultado", JOptionPane.ERROR_MESSAGE);
										break;
			case ENTRADA_INEXISTENTE :   JOptionPane.showMessageDialog(null, "A entrada \"" + entradaAtual + "\" não pertence ao alfabeto.\nSentença não reconhecida!", "Resultado", JOptionPane.ERROR_MESSAGE);
										break;
			default : if ( isReconhecedor(estadoAtual) )
						JOptionPane.showMessageDialog(null, "Sentença reconhecida!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Sentença não reconhecida!", "Resultado", JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean isReconhecedor(String estado)
	{
		for (int i=0; i<estadosReconhecedores.length; i++)
		{
			if (estadosReconhecedores[i].equals(estado))
				return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		Grafo f1 = new Grafo();
		f1.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		f1.show();
	}
}