package fr.eseo.javarrow.view;

import java.awt.Graphics2D;
import fr.eseo.javarrow.model.Arrow;


 
public class ViewArrow {
	
	protected final Arrow arrow;

	public ViewArrow(Arrow arrow) {
		this.arrow = arrow;
	}

	public Arrow getArrow() {
		return arrow;
	}
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
