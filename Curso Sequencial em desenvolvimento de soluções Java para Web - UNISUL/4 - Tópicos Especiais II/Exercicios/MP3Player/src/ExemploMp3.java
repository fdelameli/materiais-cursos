

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.media.Manager;
import javax.media.Player;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploMp3 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Player player;
	private JFileChooser fc = new JFileChooser();
	private JButton btNewMusic;
	private JButton btStop;
	private String fileName;
	private JPanel panel1;
	private JPanel panel2;

	public void createFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		btNewMusic = new JButton("Nova Música");
		btStop = new JButton("Parar");
		panel1 = new JPanel();
		panel2 = new JPanel();

		btNewMusic.addActionListener(this);
		btStop.addActionListener(this);

		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setPreferredSize(new Dimension(getWidth(), 25));

		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(btStop);
		panel2.add(btNewMusic);

		setSize(250, 100);
		setLayout(new BorderLayout());
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
	}

	public void openFile() {
		int button = fc.showOpenDialog(this);
		if (button == JFileChooser.APPROVE_OPTION) {
			fileName = fc.getSelectedFile().toString();
			try {
				URL url = new URL("file", null, fileName);//cria uma URL passando como parâmetro o arquivo escolhido pelo usuário
				player = Manager.createRealizedPlayer(url); //cria um player para reproduzir o arquivo
				player.start();//inicializa o player
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Component control = player.getControlPanelComponent(); //cria os controles do player 

		control.setSize(getWidth()-5, 20);
		panel1.add(control);
		btNewMusic.setEnabled(false);
		btStop.setEnabled(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btNewMusic) {
			openFile();
		} else if (e.getSource() == btStop) {
			panel1.remove(player.getControlPanelComponent());
			panel1.repaint();
			panel1.revalidate();
			//--
			player.stop();
			player.close(); 
			//--
			btNewMusic.setEnabled(true);
			btStop.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		ExemploMp3 sample = new ExemploMp3();
		sample.createFrame();
		sample.setVisible(true);
		//--
		sample.openFile();
	}

}
