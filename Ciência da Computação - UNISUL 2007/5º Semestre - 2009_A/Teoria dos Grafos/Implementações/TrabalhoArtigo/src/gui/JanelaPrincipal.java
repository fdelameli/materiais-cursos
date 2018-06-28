package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Caminho;
import classes.Cidade;
import classes.Rota;

/**
 * Classe responsável pela apresentação da tela principal do programa.
 * 
 * @author  Fabio Dela Bruna, Márcio Ozório Teixeira
 */
public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private Vector<Rota> rotas = new Vector<Rota>();
    private Vector<Cidade> cidades = new Vector<Cidade>();

    /**
     * Criando o FramePrincipal 
     */
    public JanelaPrincipal() {
        initComponents();
    }

    /**
     * Método responsável por inicializar os componentes
     */
    private void initComponents() {

        jPanelCidade = new JPanel();
        jLabelNomeCidade = new JLabel();
        jTextFieldlNomeCidade = new JTextField();
        jButtonInserirCidade = new JButton();
        jPanelRota = new JPanel();
        jLabelOrigem = new JLabel();
        jComboBoxOrigem = new JComboBox();
        jLabelDestino = new JLabel();
        jComboBoxDestino = new JComboBox();
        jButtonInserirRota = new JButton();
        jLabelDistancia = new JLabel();
        jTextFieldDistancia = new JTextField();
        jLabelKilometragem = new JLabel();
        jPanelResultado = new JPanel();
        jButtonCalcularResultado = new JButton();
        jLabelResultado = new JLabel();
        jLabelResultado1 = new JLabel();
        jLabelResultado2 = new JLabel();
        jBarraMenu = new JMenuBar();
        jMenuArquivo = new JMenu();
        jMenuItemSair = new JMenuItem();
        jMenuAjuda = new JMenu();
        jMenuItemSobre = new JMenuItem();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculo de Menores Rotas entre Cidades");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(1000, 2000, 0, 0));
        setName("framePrincipal");

        jPanelCidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserir Cidades", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanelCidade.setName("jPanelCidade");
        jLabelNomeCidade.setText("Nome:");
        jLabelNomeCidade.setName("jLabelNomeCidade");
        jTextFieldlNomeCidade.setName("jTextFieldNomeCidade");

        jButtonInserirCidade.setText("Inserir");
        jButtonInserirCidade.setName("jButtonInserirCidade"); 
        jButtonInserirCidade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonInserirCidadeActionPerformed(evt);
            }
        });

        GroupLayout jPanelCidadeLayout = new GroupLayout(jPanelCidade);
        jPanelCidade.setLayout(jPanelCidadeLayout);
        jPanelCidadeLayout.setHorizontalGroup(
            jPanelCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCidadeLayout.createSequentialGroup().addContainerGap().addGroup(jPanelCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCidadeLayout.createSequentialGroup().addComponent(jLabelNomeCidade).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldlNomeCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addComponent(jButtonInserirCidade, javax.swing.GroupLayout.Alignment.TRAILING)).addContainerGap())
        );
        jPanelCidadeLayout.setVerticalGroup(
            jPanelCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCidadeLayout.createSequentialGroup()
                .addGroup(jPanelCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabelNomeCidade)
                    .addComponent(jTextFieldlNomeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonInserirCidade).addContainerGap(5, Short.MAX_VALUE))
        );

        jPanelRota.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inserir Rotas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanelRota.setName("jPanelRota"); 

        jLabelOrigem.setText("Origem:");
        jLabelOrigem.setName("jLabelOrigem"); 

        jComboBoxOrigem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxOrigem.setName("jComboBoxOrigem");

        jLabelDestino.setText("Destino:");
        jLabelDestino.setName("jLabelDestino");

        jComboBoxDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxDestino.setName("jComboBoxDestino");

        jButtonInserirRota.setText("Inserir");
        jButtonInserirRota.setName("jButtonInserirRota"); 
        jButtonInserirRota.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonInserirRotaActionPerformed(evt);
            }
        });

        jLabelDistancia.setText("Distância:");
        jLabelDistancia.setName("jLabelDistancia");

        jTextFieldDistancia.setName("jTextFieldDistancia");
        jLabelKilometragem.setText("Km.");
        jLabelKilometragem.setName("jLabelKilometragem"); 

        GroupLayout jPanelRotaLayout = new GroupLayout(jPanelRota);
        jPanelRota.setLayout(jPanelRotaLayout);
        jPanelRotaLayout.setHorizontalGroup(
            jPanelRotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanelRotaLayout.createSequentialGroup()
                .addContainerGap().addGroup(jPanelRotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelRotaLayout.createSequentialGroup().addComponent(jLabelOrigem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRotaLayout.createSequentialGroup().addComponent(jLabelDistancia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextFieldDistancia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelRotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRotaLayout.createSequentialGroup().addComponent(jLabelDestino).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDestino, 0, 127, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRotaLayout.createSequentialGroup()
                        .addComponent(jLabelKilometragem).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jButtonInserirRota))).addContainerGap()));
        jPanelRotaLayout.setVerticalGroup(
            jPanelRotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanelRotaLayout.createSequentialGroup().addGroup(jPanelRotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelOrigem).addComponent(jLabelDestino).addComponent(jComboBoxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelRotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserirRota).addComponent(jLabelDistancia).addComponent(jTextFieldDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKilometragem)).addContainerGap(6, Short.MAX_VALUE)));

        jPanelResultado.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));
        jPanelResultado.setName("jPanelResultado"); 

        jButtonCalcularResultado.setText("Calcular Menor Rota");
        jButtonCalcularResultado.setName("jButtonCalcularResultado"); 
        jButtonCalcularResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCalcularResultadoActionPerformed(evt);
            }
        });

        jLabelResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultado.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultado.setAutoscrolls(true);
        jLabelResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelResultado.setName("jLabelResultado"); 
        jLabelResultado.setOpaque(true);

        jLabelResultado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultado1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelResultado1.setName("jLabelResultado1"); 

        jLabelResultado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelResultado2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelResultado2.setName("jLabelResultado2"); 

        javax.swing.GroupLayout jPanelResultadoLayout = new javax.swing.GroupLayout(jPanelResultado);
        jPanelResultado.setLayout(jPanelResultadoLayout);
        jPanelResultadoLayout.setHorizontalGroup(
            jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadoLayout.createSequentialGroup().addContainerGap()
                .addComponent(jButtonCalcularResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE).addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadoLayout.createSequentialGroup().addContainerGap()
                .addGroup(jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelResultado2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(jLabelResultado1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addContainerGap()).addComponent(jLabelResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE));
        jPanelResultadoLayout.setVerticalGroup(
            jPanelResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadoLayout.createSequentialGroup()
                .addComponent(jLabelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelResultado1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelResultado2, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalcularResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));

        jBarraMenu.setName("jBarraMenu"); 

        jMenuArquivo.setText("Arquivo");
        jMenuArquivo.setName("jMenuArquivo");

        jMenuItemSair.setText("Sair");
        jMenuItemSair.setName("jMenuItemSair"); 
        jMenuItemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemSair);

        jBarraMenu.add(jMenuArquivo);

        jMenuAjuda.setText("Ajuda");
        jMenuAjuda.setName("jMenuAjuda"); 

        jMenuItemSobre.setText("Sobre");
        jMenuItemSobre.setName("jMenuItemSobre"); 
        jMenuItemSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenuAjuda.add(jMenuItemSobre);

        jBarraMenu.add(jMenuAjuda);

        setJMenuBar(jBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelRota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelCidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRota, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        pack();
    }

    private void jMenuItemSairActionPerformed(ActionEvent evt) {
    	System.exit(0);
    }

	private void jMenuItemSobreActionPerformed(ActionEvent evt) {
	    JOptionPane.showMessageDialog(this, "Programa responsável por Calcular o\n" +
	            "Caminho Mínimo de uma rota Áerea\n" +
	            "definida entre algumas cidades.\n " +
	            "Apresentado como Trabalho Final da\n " +
	            "disciplina de Teoria de Grafos.\n\n" +
	            "Desenvolvido por:\n\tFabio Dela Bruna\n" +
	            "\tMárcio Ozório Teixeira.", "Sobre...", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * Método responsável por verificar se uma cidade ja foi inserida.
	 * @param cidades, vetor das cidades inseridas.
	 * @param cidade, cidade que está sendo inserida.
	 * @return true se encontrar a cidade, false senão encontrar.
	 */
    private boolean cidadeExiste(Vector<Cidade> cidades , Object cidade) {
        return cidades.indexOf(cidade) != -1;
    }
    
    /**
	 * Método responsável por verificar se uma rota ja foi inserida.
	 * @param rotas, vetor das rotas inseridas.
	 * @param rota, rota que está sendo inserida.
	 * @return true se encontrar a rota, false senão encontrar.
	 */
    private boolean rotaExiste(Vector<Rota> rotas , Object rota) {
        return rotas.indexOf(rota) != -1;
    }

    /**
     * Método responsável por adicionar uma cidade, caso ela ainda tenha sido inserida.
     * @param vetorCidades, vetor que contem as cidades já inseridas.
     * @param cidade, cidade que está sendo insetida.
     * @return true caso ela seja inserida com sucesso, false caso contrário.
     */
    private boolean adicionarCidade(Vector<Cidade> vetorCidades, Object cidade) {
        if (cidadeExiste(vetorCidades, cidade)){
            return false; //Cidade já existe!
        } else {
            vetorCidades.add((Cidade)cidade);
            return true;
        }
    }
    
    /**
     * Método responsável por adicionar uma rota, caso ela ainda não tenha sido inserida.
     * @param vetorRotas, vetor que contem as rotas já inseridas.
     * @param rota, rota que está sendo insetida.
     * @return true caso ela seja inserida com sucesso, false caso contrário.
     */
    private boolean adicionarRota(Vector<Rota> vetorRotas, Object rota) {
        if (rotaExiste(vetorRotas, rota)){
            return false; //Rota já existe!
        } else {
            vetorRotas.add((Rota)rota);
            System.out.println("Rota Inserida: " + rota.toString());
            return true;
        }
    }
    
    /**
     * Método responsável por limpar as labels do resultado.
     */
    private void limparCamposResultado() {
		jLabelResultado.setText("");
        jLabelResultado1.setText("");
        jLabelResultado2.setText("");
	}

    private void jButtonInserirCidadeActionPerformed(ActionEvent evt) {

	    if (jTextFieldlNomeCidade.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Digite um nome de uma Cidade para ser inserido!", "Erro", JOptionPane.WARNING_MESSAGE);
	        jTextFieldlNomeCidade.requestFocus();
	    } else {
	
	        Cidade cidade = new Cidade(jTextFieldlNomeCidade.getText().trim().toUpperCase());
	
	        if (adicionarCidade(cidades, cidade)) {
	            JOptionPane.showMessageDialog(this, "Cidade \" " + cidade.getNomeCidade() + " \" Inserida com Sucesso!", "Ok", JOptionPane.INFORMATION_MESSAGE);
	            jTextFieldlNomeCidade.setText("");
	            jTextFieldlNomeCidade.requestFocus();
	
	            //Atualizar os Combos com a nova cidade.
	            jComboBoxOrigem.addItem(cidade);
	            jComboBoxDestino.addItem(cidade);
	
	        } else {
	            JOptionPane.showMessageDialog(this, "Cidade \" "+ cidade.getNomeCidade() +" \" Já Inserida!", "Erro", JOptionPane.ERROR_MESSAGE);
	            jTextFieldlNomeCidade.setText("");
	            jTextFieldlNomeCidade.requestFocus();
	        }
	    }
    }

	private void jButtonInserirRotaActionPerformed(java.awt.event.ActionEvent evt) {
	    
        limparCamposResultado();
		
		double distancia;
	
	    if (jComboBoxOrigem.getSelectedItem() == "Selecione") {
	        JOptionPane.showMessageDialog(this, "Selecione a Cidade de Origem!", "Erro", JOptionPane.WARNING_MESSAGE);
	    } else {
	        if (jComboBoxDestino.getSelectedItem() == "Selecione") {
	            JOptionPane.showMessageDialog(this, "Selecione a Cidade de Destino!", "Erro", JOptionPane.WARNING_MESSAGE);
	        } else {
	            if (jTextFieldDistancia.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(this, "Preencha um Valor de Distância!", "Erro", JOptionPane.WARNING_MESSAGE);
	            } else {
	
	            	Cidade cidadeOrigem = (Cidade) jComboBoxOrigem.getSelectedItem();
	            	Cidade cidadeDestino = (Cidade) jComboBoxDestino.getSelectedItem();
	
	                try {
	                    distancia = Double.parseDouble(jTextFieldDistancia.getText());
	                } catch (Exception e) {
		                    JOptionPane.showMessageDialog(this, "Digite um Valor Real!", "Erro", JOptionPane.ERROR_MESSAGE);
		                    jTextFieldDistancia.setText("");
		                    jTextFieldDistancia.requestFocus();
	                    return;
	                }
	
	                if (distancia < 0) {
	                    JOptionPane.showMessageDialog(this, "Digite um Valor Positivo!", "Erro", JOptionPane.ERROR_MESSAGE);
	                    jTextFieldDistancia.setText("");
	                    jTextFieldDistancia.requestFocus();
	                } else {
	
	                    if (cidadeOrigem.compareTo(cidadeDestino) != 0) {
	
	                        Rota rota = new Rota(cidadeDestino, cidadeOrigem, distancia);
	
	                        if (adicionarRota(rotas, rota)) {
	                            JOptionPane.showMessageDialog(this, "Rota Inserida Com Sucesso!\n\n" + rota, "Ok", JOptionPane.INFORMATION_MESSAGE);
	                            jTextFieldDistancia.setText("");
	                            jComboBoxDestino.setSelectedIndex(0);
	                            jComboBoxOrigem.setSelectedIndex(0);
	                        } else {
	                            JOptionPane.showMessageDialog(this, "Rota Já Existente!", "Erro", JOptionPane.ERROR_MESSAGE);
	                            jTextFieldDistancia.setText("");
	                            jComboBoxDestino.setSelectedIndex(0);
	                            jComboBoxOrigem.setSelectedIndex(0);
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(this, "Cidade Destino deve ser Diferente da Cidade Origem!", "Erro", JOptionPane.ERROR_MESSAGE);
                            jComboBoxDestino.setSelectedIndex(0);
                            jComboBoxOrigem.setSelectedIndex(0);
	                    }
	                }
	            }
	        }
	    }
	}
	
	private void jButtonCalcularResultadoActionPerformed(ActionEvent evt) {
		
	    Cidade[] vetorLocalCidades = new Cidade[this.cidades.size()];
	
	    this.cidades.toArray(vetorLocalCidades);
	
	    Caminho caminho = new Caminho(vetorLocalCidades);
	    
	    caminho.setDistanciaTotal(0.0);
	    
	    if (jComboBoxDestino.getSelectedIndex() == 0 || jComboBoxOrigem.getSelectedIndex() == 0) {
	        JOptionPane.showMessageDialog(this, "Selecione uma Rota, com Origem e Destino!", "Erro", JOptionPane.WARNING_MESSAGE);
	    } else {
	
	        Cidade cidadeOrigem = (Cidade) jComboBoxOrigem.getSelectedItem();
	        Cidade cidadeDestino = (Cidade) jComboBoxDestino.getSelectedItem();
	
	        Cidade[] menorRotaCalculada = caminho.menorCaminho(cidadeOrigem, cidadeDestino);
	
	        String text = "A Rota de Menor Distância entre as Cidades de: \" " + cidadeOrigem.getNomeCidade() + " \" e \"" + cidadeDestino.getNomeCidade() + " \" é a seguinte:";
	        String rota = "";
	        
	        caminho.setDistanciaTotal(cidadeDestino.getDistancia() + cidadeOrigem.getDistancia()); 
	        
	        if (menorRotaCalculada != null) {
	            int count = 0;
	            for (int i = 0; i < menorRotaCalculada.length; i++) {
	                if (menorRotaCalculada[i] != null) {
	                    count++;
	
	                    if (i > 0) {
	                        rota += " »»» ";
	                    }
	                    rota += menorRotaCalculada[i];
	
	                }
	            }
	
	            if (count == 1 && menorRotaCalculada[0].getDistancia() == Caminho.valorInfinito) {
	            	jLabelResultado.setText("");
	                jLabelResultado1.setText("Inexistente.");
	                jLabelResultado2.setText("");
	                JOptionPane.showMessageDialog(this, "Não existe Rota de " + cidadeOrigem + " para " + cidadeDestino + ".", "Erro", JOptionPane.ERROR_MESSAGE);
	            } else {
	                jLabelResultado.setText(text);
	                jLabelResultado1.setText(rota);
	                jLabelResultado2.setText("Distância Total da Rota: "+ caminho.getDistanciaTotal() + " Km.");
	            }
	
	        } else {
	            JOptionPane.showMessageDialog(this, "Não Existem Cidades Vizinhas a Origem!", text, WIDTH);
	        }
	    }
	}
	
	//Declaração dos Componentes
    private JMenuBar jBarraMenu;
    private JButton jButtonCalcularResultado;
    private JButton jButtonInserirCidade;
    private JButton jButtonInserirRota;
    private JComboBox jComboBoxDestino;
    private JComboBox jComboBoxOrigem;
    private JLabel jLabelDestino;
    private JLabel jLabelDistancia;
    private JLabel jLabelKilometragem;
    private JLabel jLabelNomeCidade;
    private JLabel jLabelOrigem;
    private JLabel jLabelResultado;
    private JLabel jLabelResultado1;
    private JLabel jLabelResultado2;
    private JMenu jMenuAjuda;
    private JMenu jMenuArquivo;
    private JMenuItem jMenuItemSair;
    private JMenuItem jMenuItemSobre;
    private JPanel jPanelCidade;
    private JPanel jPanelResultado;
    private JPanel jPanelRota;
    private JTextField jTextFieldDistancia;
    private JTextField jTextFieldlNomeCidade;
}
