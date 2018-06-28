/**
 * @author Misael, Odione
 *
 * Controle de eventos e uso de uma lista.
 *
 */



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;








public class Principal extends JFrame{

	int contador = 0;
	ArrayList<String> lista = new ArrayList<String>();
	ArrayList<String> refazer = new ArrayList<String>();
	JButton botao = new JButton("Desfazer");
	JButton botao2 = new JButton("Refazer");
	JButton botao3 = new JButton("Abrir");
	JTextArea texto = new JTextArea();



	public Principal(){
		this.setTitle("CCP_Text_Editor");
		this.setLocation(100, 100);
		this.setSize(640, 480);
		this.setState(JFrame.NORMAL);




		this.botao.setBounds(25, 25, 100,25);
		this.botao2.setBounds(150, 25, 100,25);
		this.botao3.setBounds(250, 25, 100, 25);
		this.botao3.setBackground(Color.red);
		this.texto.setBounds(1, 65, 800, 800);



		//**************EVENTO DOs BOTÕES*********************************************
		botao.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(lista.isEmpty()==false){
					refazer.add(texto.getText());
					texto.setText(lista.get(lista.size()-1));
					lista.remove(lista.size()-1);
				}
			}
		});




		botao2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(refazer.isEmpty()==false){
					texto.setText(refazer.get(refazer.size()-1));
					refazer.remove(refazer.size()-1);
				}
			}
		});



		botao3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {


			}


		});







		//********************* EVENTO DO TEXTO***************************************
		this.texto.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				System.out.println("removeu");
			}



			public void insertUpdate(DocumentEvent e) {
				if(texto.getText().equalsIgnoreCase("ADEMAR VIADO")){
					JOptionPane.showMessageDialog(null, "ADEMO: This is Madness!!!\nALUNOS: This is SPARTAAAAAAA!");
				}
				contador++;

				if(contador>11){
					System.out.println("inseriu");
					lista.add(texto.getText());
					contador=0;
					//System.out.println(lista.get(lista.size()-1));
				}








			}


			public void changedUpdate(DocumentEvent e) {


			}
		});




		this.getContentPane().add(botao);
		this.getContentPane().add(botao2);
		this.getContentPane().add(texto);


		this.setLayout(null);

	}



	public static void main(String[] args) {
		Principal p = new Principal();
		p.setVisible(true);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}






}
