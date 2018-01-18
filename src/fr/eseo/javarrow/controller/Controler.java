package fr.eseo.javarrow.controller;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.Trajectory;
import fr.eseo.javarrow.model.Arrow;
import fr.eseo.javarrow.model.Game;
import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.ViewArrow;
 
/**
 * Classe du controleur
 *  @version 0.1
 *
 */
public class Controler implements MouseListener,MouseMotionListener{
	
	/**
	 * Attributs de la classe Controler
	 */
	
	// Récupérer 
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private int screenWidth = gd.getDisplayMode().getWidth();
	private int screenHeight = gd.getDisplayMode().getHeight(); 
	private Draw draw;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Arrow a = new Arrow(0,0,0,0);
	private int position;
	private int sol;
	private int height;
	
	/**
	 * Associe le JPanel au controleur
	 * @param draw
	 */
	public Controler(Draw draw){
		this.draw = draw;
		associate(draw);
	};
	
	/**
	 * Récupère la position du click de la souris
	 * @param e
	 */
	public void mousePressed(MouseEvent e){
		this.x1 = e.getX();
		this.y1 = e.getY();	
	}
	
	/**
	 * Récupère la position du relachement de la souris
	 * Crée un objet trajectoire associé aux points d'appuis 
	 * et de relachements de la souris
	 * @param e 
	 */
	public void mouseReleased(MouseEvent e){
		this.x2 = e.getX();
		this.y2 = e.getY();
		if (x1<position+15 && x1>position-15 && y1<sol && y1>(sol-height)) {
			new Trajectory(this.draw,this.a,x1, x2, y1, y2);
			}
	}
	
	public void mouseClicked(MouseEvent e){
	}
	
	public void mouseMoved(MouseEvent e){
	}
	
	/**
	 * Initialise la position, 
	 * @param e 
	 */
	public void mouseDragged(MouseEvent e){
		position = (int)this.draw.getGame().getActivePlayer().getX();
		sol = (int)this.draw.getGame().getActivePlayer().getY();
		height = (int)this.draw.getGame().getActivePlayer().getHeight();
		if (x1<position+15 && x1>position-15 && y1<sol && y1>(sol-height)) {
			ViewArrow createViewArrow = new ViewArrow(new Arrow(this.x1,sol-this.y1,e.getX(),sol-e.getY()));
			this.draw.addView(createViewArrow );
		}
	}
	
	public void mouseEntered(MouseEvent e){
	}
	
	public void mouseExited(MouseEvent e){
	}
		
	public void associate(Draw draw){
		this.getDraw().setControler(this);
		this.getDraw().addMouseListener(this);
		this.getDraw().addMouseMotionListener(this);
	}
	
	public int getScreenWidth() {
		return this.screenWidth;
	}
	
	public int getScreenHeight() {
		return this.screenHeight;
	}	
	
	public Draw getDraw() {
		return this.draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}
	
}
