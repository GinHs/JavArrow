package fr.eseo.javarrow.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import fr.eseo.javarrow.controller.Action;


public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TITRE_PAR_DEFAUT = "JavArrow";
	private static Window instance = new Window();
	private Draw draw = new Draw(Draw.length,Draw.height,Draw.Color);
	
	
	private Window() {
		super(TITRE_PAR_DEFAUT);
		this.setPreferredSize(new Dimension(1920,1080));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		this.setLayout(new BorderLayout());
		this.add(draw,BorderLayout.CENTER);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fichierMenu = new JMenu();
		fichierMenu.setText("Fichier");
		menuBar.add(fichierMenu);
		JMenuItem ouvrirMenu = new JMenuItem(new Action());
		fichierMenu.add(ouvrirMenu);
		
		
		this.repaint();
	
}
	public static Window getInstance(){
		return instance;
	}
	
	public Draw getDraw(){
		return this.draw;
		
	}
}
