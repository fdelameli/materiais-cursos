package Janelas;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class JanelaDoScore extends JDialog{
	
	private JLabel mainLabel;
	
	//the ScoreGui Method displays the scores in order from lowest to highest.
    public void mostrarScore()
    {
        Container contentPanel = getContentPane();
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
        });
        contentPanel.add(ok,BorderLayout.SOUTH);
             try{
                    String line = "";
                    String[] myScoreArray = new String[100];
                    for(int i=0; i<myScoreArray.length;i++)
                        myScoreArray[i]=" ";
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("scores.txt")));//read in the scores data
                    int recordsCount=0;
                    while((line = br1.readLine()) != null) 
                    {
                        line = br1.readLine();
                        if(line!="")
                        {
                            recordsCount+=1;
                            int tempPOS = line.indexOf("*");//use the star to indicate the next charator is going to be the maze level which we will sort by.
                            String pos=line.substring(tempPOS+1);
                            int index = Integer.parseInt(pos);
                            if(myScoreArray[index] == " ")
                                myScoreArray[index]=line;//add in the score to the array.
                          else
                          {
                               for(int i=0; i<myScoreArray.length;i++)
                               {
                                   if(index+i<myScoreArray.length)//prevent array out of bounds errors.
                                   {
                                   if(myScoreArray[index+i].equals(" "))
                                   {
                                       myScoreArray[index+1]=line;//add in a score to the next available area of the array
                                   }
                                   }//end first if
                               }//end for loop
                           }//end else
                             JPanel scorePanel = new JPanel();
                             scorePanel.setLayout(new GridLayout(recordsCount,recordsCount));
                                 for(int i=0; i<myScoreArray.length;i++)
                                 {
                                     if(myScoreArray[i]!=" ")
                                     {
                                         mainLabel=new JLabel(myScoreArray[i], JLabel.LEFT);//display the score on the screen
                                         scorePanel.add(mainLabel);
                                     }
                                 }//end for loop
                                contentPanel.add(scorePanel); 
                           }//end very first if
                     }//end first while loop            
                }//end try
                catch(IOException ex) {
                    JFrame frame = new JFrame("Alert");
                    JOptionPane.showMessageDialog(frame, "Problem with scores.txt file.  Cant load high Scores");
                }//end catch
        pack();
        setVisible (true);
    }
}