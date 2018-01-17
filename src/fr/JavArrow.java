package fr;

import javax.swing.SwingUtilities;

import fr.eseo.javarrow.view.Window;


public class JavArrow {
	public JavArrow () {
		Window window;
    	window = Window.getInstance();
    	window.pack();
       	window.setVisible(true);
	}
	
	public static void main(String[] args){ 
    	SwingUtilities.invokeLater(new Runnable(){
    		public void run(){
    			new JavArrow ();
    		} 
    	});
    }

}