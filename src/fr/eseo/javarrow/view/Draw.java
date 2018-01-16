package fr.eseo.javarrow.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import fr.eseo.javarrow.controller.Controler;

import fr.Game;
import fr.eseo.javarrow.model.Character;


public class Draw extends JPanel{
	public static int length = 500;
	public static int height = 500;
	public static Color Color=new Color(255,255,255);
	private Controler controler;
	
	
	private Game game = new Game(new Character("ju",100,800),new Character("co",1800,800));
	private Character player1 = game.getPlayer1();
	private Character player2 = game.getPlayer2();

	public Controler getControler() {
		return controler;
	}

	public void setControler(Controler controler) {
		this.controler = controler;
	}

	private List <ViewArrow> vueFormes = new ArrayList <ViewArrow>();
	
	public List<ViewArrow> getVueFormes() {
		return vueFormes;
	}

	public void setVueFormes(List<ViewArrow> vueFormes) {
		this.vueFormes = vueFormes;
	}

	public Draw(int largeur,int hauteur, Color fond) {
		super();
		Dimension d = new Dimension(largeur, hauteur);
		super.setPreferredSize(d);
		
		super.setBackground(fond);
		super.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g){ 
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		g2D.setColor(new Color(51,51,51));
		g2D.drawLine(0,800, 2000, 800);
		new ViewCharacter(player1).affiche(g2D);
		new ViewCharacter(player2).affiche(g2D);
		
		//System.out.println("ok");
		for(int i=0;i<vueFormes.size();i++)
			this.vueFormes.get(i).affiche(g2D);
		g2D.dispose(); 
	
	}

	public void addView(ViewArrow createViewArrow) {
		
		//System.out.println("hellop");
		this.vueFormes.clear();
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.vueFormes.add(createViewArrow);
		paintComponent(this.getGraphics());
		
		
	}
	

	
}
