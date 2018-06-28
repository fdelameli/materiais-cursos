import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class Teste extends JFrame {

	public Teste() {
		super("Teste de TitledBorder");
		setLayout(null);
		setSize(300, 300);
		JPanel panel = new JPanel(); 
		panel.setSize(200, 100);
		panel.setBorder(new TitledBorder("Isso é GroupBox"));  
		panel.add(new JLabel("Label dentro do GroupBox"));
		add(panel);
	}
	
	public void mostraTela() {
		setVisible(true);
	}
	
}
