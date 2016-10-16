package tm.imirror.gui;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	
	/**
	 * serialVersion for JFrame
	 */
	private static final long serialVersionUID = -5765178046128788471L;

	public MainFrame(){
		super("TM-IMirror");
		//settings
		setUndecorated(true);
		getContentPane().setBackground(Color.BLACK);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUpFullScreen();
		
		//set 2x2 grid with labels an buttons
		setGridLayout();
		
		//make visible
		setVisible(true);
	}

	private void setGridLayout() {
		setLayout(new GridLayout(2, 2));
		add(new JLabel("label1"));
		add(new JButton("Button2"));
		add(new JLabel("Label2"));
		add(new JButton("Button4"));
	}

	private void setUpFullScreen() {
		//setExtendedState(MAXIMIZED_BOTH);
		SwingHelper.installEscapeCloseOperation(this);
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        device.setFullScreenWindow(this);
	}
	
	
	
}
