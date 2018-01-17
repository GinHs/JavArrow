package fr.eseo.javarrow.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import fr.eseo.javarrow.controller.LaunchGameAction;
import fr.eseo.javarrow.model.Character;
import fr.eseo.javarrow.model.Game;


public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TITRE_PAR_DEFAUT = "JavArrow";
	private static Window instance = new Window();
	private Draw draw = new Draw(Draw.length,Draw.height,Draw.Color);
	
	private DrawBegin drawBegin = new DrawBegin(Draw.length,Draw.height,Draw.Color);
	Game game = new Game(new Character("ju",200,800,70,100),new Character("co",1700,800,70,100));
	

	public JTextField pseudo1 = new JTextField("Pseudo1",20);
	public JTextField pseudo2 = new JTextField("Pseudo2",20);
	
	private Window() {
		super(TITRE_PAR_DEFAUT);
		this.setPreferredSize(new Dimension(500,500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		this.setLayout(new BorderLayout());
		this.add(drawBegin,BorderLayout.CENTER);
		
		JButton bouton = new JButton(new LaunchGameAction());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getPreferredSize().width/2, dim.height/2-this.getPreferredSize().height/2);

		drawBegin.setLayout(new FlowLayout());
		drawBegin.setBackground(Color.WHITE);
		drawBegin.add(pseudo1);
		drawBegin.add(pseudo2);
		drawBegin.add(bouton);
 
		this.repaint();
	
}
	public static Window getInstance(){
		return instance;
	}
	
	public Draw getDraw(){
		return this.draw;
	}
	
	public DrawBegin getDrawBegin(){
		return this.drawBegin;
	}
}
