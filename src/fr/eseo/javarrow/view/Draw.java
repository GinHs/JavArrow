package fr.eseo.javarrow.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import fr.eseo.javarrow.controller.Controler;
import fr.eseo.javarrow.model.Character;
import fr.eseo.javarrow.model.Game;


public class Draw extends JPanel{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public int screenWidth = dim.width;
	public int screenHeight = dim.height;
	public static int height = 500;
	public static int length = 500;
	public static Color Color = new Color(255,255,255);
	private Controler controler;
	
	public Game game = new Game(this,
			new Character("ju",(int)(screenWidth*0.10),
					(int)(screenHeight*0.74),
					(int)(0.0644*screenHeight),
					(int)(0.092*screenHeight)),
			new Character("co",screenWidth-(int)(screenWidth*0.10),
					(int)(screenHeight*0.74),
					(int)(0.0644*screenHeight),
					(int)(0.092*screenHeight)));
	
	private Character player1 = game.getPlayer1();
	private Character player2 = game.getPlayer2();
	private List <ViewArrow> vueFormes = new ArrayList <ViewArrow>();
	public boolean win = false; 
	
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
		g2D.setColor(new Color(0,0,0));
		if (win) {
			Font fonte = new Font("Arial",Font.BOLD,100);
		    g2D.setFont(fonte);
		    //System.out.println(game.getPlayer1().getName()+" "+game.getScorePlayer1());
		    //System.out.println(game.getPlayer2().getHeight()+" "+game.getScorePlayer2());
			if (game.getScorePlayer1()>game.getScorePlayer2()) {
				g2D.drawString(game.getPlayer1().getName()+" a gagne",200,200);
			}else{
				g2D.drawString(game.getPlayer2().getName()+" a gagne",200,200);
			}
		}else{
		Image img = Toolkit.getDefaultToolkit().getImage("image/fond.jpg");
		Image img1 = Toolkit.getDefaultToolkit().getImage("image/Stickman.png");
		Image img2 = Toolkit.getDefaultToolkit().getImage("image/Stickman2.png");
		Character character = this.getGame().getPlayer1();
		Character character2 = this.getGame().getPlayer2();
		g2D.drawImage(img,0,0,this.screenWidth,this.screenHeight,this);
	    g2D.drawImage(img1, 
	    		(int)character.getX()-25, 
	    		(int)character.getY()-100,
	    		(int)character.width,
	    		(int)character.height, this);
	    
	    g2D.drawImage(img2, 
	    		(int)character2.getX()-40, 
	    		(int)character2.getY()-100,
	    		(int)character2.width,
	    		(int)character2.height, this);
	    
	    g2D.finalize();
	
	    Font fonte = new Font("TimesRoman ",Font.BOLD,30);
	    g2D.setFont(fonte);
	    g2D.setStroke(new BasicStroke(3.0f));

		g2D.drawString(player1.getName(), player1.getX()-10, player1.getY() - 110);
		g2D.drawString(player2.getName(), player2.getX()-20, player2.getY() - 110);
		
		for(int i=0;i<vueFormes.size();i++)
			this.vueFormes.get(i).affiche(g2D);
		
		g2D.drawLine(0,(int)(screenHeight*0.74), screenWidth, (int)(screenHeight*0.74)); 
		
		//Qui doit jouer
		g2D.drawString("A "+game.getActivePlayer().getName()+" de jouer !", screenWidth/2-(int)(screenWidth*0.10), (int)(screenHeight*0.10));
		g2D.drawString("ROUND : "+game.getRound(), screenWidth/2-(int)(screenWidth*0.065), (int)(screenHeight*0.05));
		
		//Affichage des scores
		g2D.drawString("Score : "+this.game.getScorePlayer1(), (int)(screenWidth*0.05), (int)(screenHeight*0.10));
		g2D.drawString("Score : "+this.game.getScorePlayer2(), (int)(screenWidth*0.85), (int)(screenHeight*0.10));
		g2D.dispose();
	
	}}

	public void addView(ViewArrow createViewArrow) {
		this.vueFormes.clear();
		this.vueFormes.add(createViewArrow);
		this.repaint();
		}
		
	public int getScreenWidth() {
		return this.screenWidth;
	}
	
	public int getScreenHeigth() {
		return this.screenHeight;
	}
	
	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public Controler getControler() {
		return controler;
	}

	public void setControler(Controler controler) {
		this.controler = controler;
	}
	
	public List<ViewArrow> getVueFormes() {
		return vueFormes;
	}

	public void setVueFormes(List<ViewArrow> vueFormes) {
		this.vueFormes = vueFormes;
	}

	
}
