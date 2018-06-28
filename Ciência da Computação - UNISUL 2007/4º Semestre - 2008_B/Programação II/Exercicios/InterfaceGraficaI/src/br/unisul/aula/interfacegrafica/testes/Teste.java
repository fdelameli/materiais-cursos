package br.unisul.aula.interfacegrafica.testes;

import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.text.*;
import java.text.*;

public class Teste extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lbCep;
    private JLabel lbFone;
    private JLabel lbData;
    private JLabel lbCPF;
    private JLabel lbIdade;
    private JLabel lbPeso;

    private JFormattedTextField cep;
    private JFormattedTextField fone;
    private JFormattedTextField data;
    private JFormattedTextField cpf;
    private JFormattedTextField idade;      
    private JFormattedTextField peso;

    private MaskFormatter maskCep;
    private MaskFormatter maskFone;
    private MaskFormatter maskCpf;    
    private MaskFormatter masData;

    private NumberFormatter maskIdade;
    private NumberFormatter maskPeso;

    public Teste() {

          super("Exemplo de JFormattedTextField");

          setSize(400, 200);

          setLayout(new FlowLayout());

          setLocationRelativeTo(null);

          lbCep = new JLabel("CEP:");

          lbFone = new JLabel("Fone:");

          lbData = new JLabel("Data:");

          lbCPF = new JLabel("CPF:");

          lbIdade = new JLabel("Idade:");

          lbPeso = new JLabel("Peso:");

          try {

                 maskCep = new MaskFormatter("#####-###");

                 maskFone = new MaskFormatter("(##) ####-####");

                 masData = new MaskFormatter("##/##/####");

                 maskCpf = new MaskFormatter("###.###.###-##");

                 maskIdade = new NumberFormatter(NumberFormat.getIntegerInstance());

                 maskPeso = new NumberFormatter(NumberFormat.getNumberInstance());

          } catch (ParseException exp) {}

          maskCep.setPlaceholderCharacter('_');

          maskFone.setPlaceholderCharacter('_');

          masData.setPlaceholderCharacter('_');

          maskCpf.setPlaceholderCharacter('_');

          maskIdade.setAllowsInvalid(false);

          maskIdade.setMaximum(150);

          maskPeso.setMaximum(150.0);

          cep = new JFormattedTextField(maskCep);

          fone = new JFormattedTextField(maskFone);

          data= new JFormattedTextField(masData);

          cpf = new JFormattedTextField(maskCpf);

          idade = new JFormattedTextField(maskIdade);

          idade.setColumns(3);

          peso = new JFormattedTextField(maskPeso);

          peso.setColumns(6);

          add(lbCep);

          add(cep);

          add(lbFone);

          add(fone);

          add(lbData);

          add(data);

          add(lbCPF);

          add(cpf);

          add(lbIdade);

          add(idade);

          add(lbPeso);

          add(peso);

          setVisible(true);

    }

    public static void main(String[] args) {
		new Teste();
	}

}
