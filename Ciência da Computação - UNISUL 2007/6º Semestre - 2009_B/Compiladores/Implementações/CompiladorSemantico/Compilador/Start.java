import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Start extends JFrame
{
  public Start()
  {
  	JWindow splashWin = GuiUtils.createSplashWindow("./icons/Compilador.jpg");
    if (splashWin != null) {
        splashWin.setVisible(true);
    }

    GuiUtils.setLocation(this);
    
	Principal pc = new Principal();
	
	
    try
    {
    	
    	Thread.sleep(270);
    	
    }catch(Exception ex)
    {
    	
    }   
    
              
    // hide splash window
    if (splashWin != null) {
        splashWin.setVisible(false);
        splashWin.dispose();
    }
    
     
    //Principal pc = new Principal();
    pc.addWindowListener(new WindowAdapter()
    {
      public void windowClosing(WindowEvent e)
      {	   
        System.gc();
        System.exit(0);
      }
    });
    pc.show();
  }
  public static void main(String[]args)
  {
  	Start st = new Start();
  }
}