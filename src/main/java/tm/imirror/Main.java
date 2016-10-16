package tm.imirror;

import java.awt.EventQueue;

import tm.imirror.gui.MainFrame;

/**
 * This class is used to start the programm and set up the environment.
 * @author Timo Haeckel
 *
 */
public class Main {
	
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
	}
}
