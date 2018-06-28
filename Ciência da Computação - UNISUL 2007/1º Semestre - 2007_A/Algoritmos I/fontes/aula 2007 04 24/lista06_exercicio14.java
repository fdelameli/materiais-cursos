import javax.swing.JOptionPane;
class lista06_exercicio14 {

	static String time1, time2;
	static int gol1, gol2, penalti1, penalti2;

	public static void main(String[] args) {

		time1 = JOptionPane.showInputDialog("Digite o primeiro time");
		time2 = JOptionPane.showInputDialog("Digite o segundo time");
		gol1 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols do primeiro time"));
		gol2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols do segundo time"));
		if (gol1 > gol2){
			JOptionPane.showMessageDialog(null, "O time vencedor é " + time1);
			if ((gol1 - gol2)> 2){
				JOptionPane.showMessageDialog(null, "O time do " + time1 + " ganhou de goleada");
			}
		}
		else{
			if (gol2 > gol1){
				JOptionPane.showMessageDialog(null, "O time vencedor é " + time2);
				if ((gol2 - gol1) > 2){
					JOptionPane.showMessageDialog(null, "O time do " + time1 + " ganhou de goleada");
				}
			}
		}
		if (gol1 == gol2){
			penalti1 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols de penalti do primeiro time"));
			penalti2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols de penalti do segundo time"));
			if (penalti1 > penalti2){
				JOptionPane.showMessageDialog(null, "O time vencedor é " + time1);
			}
			else{
				JOptionPane.showMessageDialog(null, "O time vencedor é " + time2);
			}
		}
	}

}
