package swing.extras;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExemploArquivo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField textoArquivo;
	private JButton salvar;
	private JTextField textoLido;
	private JButton abrir;
	private JPanel panelSalvar;
	private JPanel panelAbrir;
	
	public ExemploArquivo() {
		super("Exemplo de manipulação de arquivo");
		setLayout(new BorderLayout());
		
		add(panelSalvar = new JPanel(), BorderLayout.NORTH);
		panelSalvar.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSalvar.add(textoArquivo =  new JTextField(60));
		panelSalvar.add(salvar = new JButton("Salvar em arquivo"));
		salvar.addActionListener(this);
		
		add(panelAbrir = new JPanel(), BorderLayout.SOUTH);
		panelAbrir.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelAbrir.add(textoLido = new JTextField(60));
		panelAbrir.add(abrir = new JButton("Abrir do arquivo"));
		textoLido.setEnabled(false);
		abrir.addActionListener(this);
		
		pack();
	}

	public static void main(String[] args) {
		ExemploArquivo app = new ExemploArquivo();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvar) {
			JFileChooser fc = new JFileChooser();
			int result = fc.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					FileOutputStream out = new FileOutputStream(file);
					out.write(textoArquivo.getText().getBytes());
					out.flush();
					out.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		} else if (e.getSource() == abrir) {
			JFileChooser fc = new JFileChooser();
			int result = fc.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					FileInputStream in = new FileInputStream(file);
					byte[] bytes = new byte[(int)file.length()];
					in.read(bytes);
					textoLido.setText(new String(bytes));
					in.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
