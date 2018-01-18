package fr.eseo.javarrow.view;

import java.awt.Graphics2D;
import fr.eseo.javarrow.model.Arrow;


 /**
  * Affichage d'une flèche
  */
public class ViewArrow {
	protected final Arrow arrow;

	/**
	 * Constructeur de la vue d'une fleche
	 * @param arrow fleche
	 */
	public ViewArrow(Arrow arrow) {
		this.arrow = arrow;
	}

	public Arrow getArrow() {
		return arrow;
	}
	/**
	 * Crée une ligne représentant la flèche
	 * @param g2d graphics en 2d
	 */
	public void affiche(Graphics2D g2d) {
		g2d.drawLine((int)arrow.getX1(), ytoY((int)arrow.getY1()),(int)arrow.getX2(),ytoY((int) arrow.getY2()));
	}
	
	public int ytoY(int y) {
		return 800-y;
	}
	
	public int Ytoy(int Y) {
		return 800-Y;
	}
	
}
