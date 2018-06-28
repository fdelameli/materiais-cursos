package gui;

import javax.swing.*;
import javax.swing.border.*;

public class BorderedPanel extends JPanel {
	private static final long serialVersionUID = 514901490549805915L;
	
	String caption;
	
	public BorderedPanel(String caption) {
		super();
		this.setCaption(caption);
	}
	
	public String getCaption() {
		return this.caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
		putBorder();
	}
	
	public void putBorder() {
		Border etched = BorderFactory.createEtchedBorder();
		Border border = BorderFactory.createTitledBorder(etched, caption);
		this.setBorder(border);
	}
}
