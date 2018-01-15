package fr.eseo.javarrow.view;

import javax.swing.SwingUtilities;


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