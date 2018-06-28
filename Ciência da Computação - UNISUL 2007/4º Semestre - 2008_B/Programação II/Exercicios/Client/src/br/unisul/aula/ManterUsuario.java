package br.unisul.aula;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ManterUsuario extends JFrame {
    private JLabel labelNome = new JLabel();
    private JTextField textEndereco = new JTextField();
    private JLabel labelEndereco = new JLabel();
    private JTextField textName = new JTextField();
    private JComboBox comboIdade = new JComboBox();
    private JLabel labelIdade = new JLabel();
    private JButton botaoSalvar = new JButton();

    public ManterUsuario() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(334, 232));
        this.setTitle( "Manter usuário" );
        labelNome.setText("Nome:");
        labelNome.setBounds(new Rectangle(5, 50, 34, 15));
        textEndereco.setBounds(new Rectangle(60, 70, 235, 20));
        labelEndereco.setText("Endereço:");
        labelEndereco.setBounds(new Rectangle(5, 75, 50, 15));
        textName.setBounds(new Rectangle(40, 45, 255, 20));
        comboIdade.setBounds(new Rectangle(40, 95, 60, 20));
        labelIdade.setText("Idade:");
        labelIdade.setBounds(new Rectangle(5, 100, 34, 15));
        botaoSalvar.setText("Salvar");
        botaoSalvar.setBounds(new Rectangle(120, 140, 71, 23));
        botaoSalvar.setMnemonic('S');
        botaoSalvar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        botaoSalvar_actionPerformed(e);
                    }
                });
        this.getContentPane().add(botaoSalvar, null);
        this.getContentPane().add(labelIdade, null);
        this.getContentPane().add(comboIdade, null);
        this.getContentPane().add(textName, null);
        this.getContentPane().add(labelEndereco, null);
        this.getContentPane().add(textEndereco, null);
        this.getContentPane().add(labelNome, null);
    }

    private void botaoSalvar_actionPerformed(ActionEvent e) {
    }
}
