import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

/**
 * Esta classe foi criada por Rana Bhattacharyya e alterada para este aplicativo
 * 
 * author mailto:rana_b@yahoo.com Rana Bhattacharyya
 */
public
class GuiUtils {
	
	private static final GuiUtils SELF_REF   = new GuiUtils();    
    /**
     * Create image icon.
     */
    public static ImageIcon createImageIcon(String imgResource) {
        InputStream is = null;
        ByteArrayOutputStream out = null;
        try {
            is = SELF_REF.getClass().getClassLoader().getResourceAsStream(imgResource);
            if (is != null) {
                out = new ByteArrayOutputStream();
                byte buff[] = new byte[1024];
                int count = 0;
                while ( -1 != (count = is.read(buff)) ) {
                    out.write(buff, 0, count);
                }
                buff = out.toByteArray();
                if (buff.length != 0){
                   return new ImageIcon(buff); 
                }
            }
        }
        catch(IOException ex) {
        }
        finally {
            
        }
        return null;
    }


    /**
     * Create splash window. Returns null if image not found.
     */
    public static JWindow createSplashWindow(String imgResource) {

        ImageIcon icon = createImageIcon(imgResource);
        if (icon == null) {
            return null;
        }

        JLabel lab = new JLabel();
        lab.setIcon(icon);

        Dimension iDim = new Dimension(icon.getIconWidth(), icon.getIconHeight());

        JWindow splashWin = new JWindow();
        splashWin.getContentPane().add(lab);
        splashWin.setSize(iDim);
        setLocation(splashWin);
        return splashWin;
    }


    /**
     * Position properly - center.
     */
    public static void setLocation(Component comp) {
        Dimension cDim = comp.getSize();
        Dimension wDim = Toolkit.getDefaultToolkit().getScreenSize();
        comp.setLocation((wDim.width - cDim.width)/2, (wDim.height - cDim.height)/2);
    }     
}
