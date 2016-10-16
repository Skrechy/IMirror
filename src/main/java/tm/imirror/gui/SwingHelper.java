package tm.imirror.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class SwingHelper {


	/**
	 * Keystroke for escape key
	 */
	private static final KeyStroke escapeStroke = 
		    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
	
	/**
	 * key for action map
	 */
	public static final String closeActionKey = 
	    "tm.imirror:WINDOW_CLOSING"; 
	
	/**
	 * connect 
	 * @param frame
	 */
	public static void installEscapeCloseOperation(final JFrame frame) { 
	    Action dispatchClosing = new AbstractAction() { 
	        public void actionPerformed(ActionEvent event) { 
	        	frame.dispatchEvent(new WindowEvent( 
	        			frame, WindowEvent.WINDOW_CLOSING 
	            )); 
	        } 
	    }; 
	    JRootPane root = frame.getRootPane(); 
	    root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put( 
	        escapeStroke, closeActionKey); 
	    root.getActionMap().put( closeActionKey, dispatchClosing); 
	}

	
}
