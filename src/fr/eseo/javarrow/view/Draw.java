package fr.eseo.javarrow.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import fr.eseo.javarrow.controller.Controler;
import fr.eseo.javarrow.model.Character;
import fr.eseo.javarrow.model.Game;


public class Draw extends JPanel{
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int screenWidth = gd.getDisplayMode().getWidth();
	int screenHeight = gd.getDisplayMode().getHeight();
	public static int length = 500;
	public static int height = 500;
	public static Color Color=new Color(255,255,255);
	private Controler controler;
	public Game game;
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}


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

	public Draw(int largeur,int hauteur, Color fond,Game game) {
		super();
		this.game=game;
		Dimension d = new Dimension(largeur, hauteur);
		super.setPreferredSize(d);
		super.setBackground(fond);
		super.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g){ 
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		

		Image img1 = Toolkit.getDefaultToolkit().getImage("image/Stickman.png");
		Image img2 = Toolkit.getDefaultToolkit().getImage("image/Stickman2.png");
		Character character = this.getGame().getPlayer1();
		Character character2 = this.getGame().getPlayer2();
	    g2D.drawImage(img1, (int)character.getX()-25, (int)character.getY()-100,(int)character.width,(int)character.height, this);
	    g2D.drawImage(img2, (int)character2.getX()-50, (int)character2.getY()-100,(int)character2.width,(int)character2.height, this);
	    
	    
	    g2D.finalize();
		

		g2D.drawString(player1.getName(), player1.getX()-10, player1.getY() - 110);
		g2D.drawString(player2.getName(), player2.getX()-20, player2.getY() - 110);
		

		for(int i=0;i<vueFormes.size();i++)
			this.vueFormes.get(i).affiche(g2D);
		 
		Stroke s = g2D.getStroke();
		// trait �pais

		//g2D.setStroke(new BasicStroke(5)); // Mettre largeur de 5
		g2D.setColor(new Color(51,51,51));

		g2D.drawLine(0,800, 2000, 800); 
		
		
		//g2D.setStroke(s); // Mettre largeur de 5

		//Qui doit jouer.
		g2D.drawString("A "+game.getActivePlayer().getName()+" de jouer !", 900, 100);
		
		//Affichage des scores
		g2D.drawString("Score : "+player1.getScore(), 100, 100);
		g2D.drawString("Score : "+player2.getScore(), 1700, 100);

		g2D.dispose();
	
	}

	public void addView(ViewArrow createViewArrow) {
		
		//System.out.println("hellop");
		this.vueFormes.clear();
		
		this.vueFormes.add(createViewArrow);
		paintComponent(this.getGraphics());
		
		
	}
	
	public int calculateRelativeLength(int length) {
		return 0;
	}
	
	public int getScreenWidth() {
		return this.screenWidth;
	}
	
	public int getScreenHeigth() {
		return this.screenHeight;
	}

	
}
