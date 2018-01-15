package fr.eseo.javarrow.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.Game;
import fr.eseo.javarrow.controller.Action;
import fr.eseo.javarrow.model.Character;


public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TITRE_PAR_DEFAUT = "JavArrow";
	private static Window instance = new Window();
	private Draw draw = new Draw(Draw.length,Draw.height,Draw.Color);
	private Game game = new Game(new Character("julien",100,800),new Character("corentin",1800,800),new Character("ju",100,800));

	
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
		
		JLabel label1 = new JLabel();
	    label1.setText(game.getPlayer1().getName());
	    label1.setBounds(
	    		(int)game.getPlayer1().getX(), 
				(int)game.getPlayer1().getY() - (int)game.getPlayer1().getHeight()-100,
				50,50);
	    
	    JLabel label2 = new JLabel();
	    label2.setText(game.getPlayer2().getName());
	    label2.setBounds(
	    		(int)game.getPlayer2().getX(), 
				(int)game.getPlayer2().getY() - (int)game.getPlayer2().getHeight()-100,
				50,50);
	    
		add(label1);
		add(label2);

		this.repaint();
	
}
	public static Window getInstance(){
		return instance;
	}
	
	public Draw getDraw(){
		return this.draw;
		
	}
}
