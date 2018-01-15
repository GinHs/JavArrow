package fr.eseo.javarrow.view;

import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.javarrow.model.Character;

public class ViewCharacter {

	
	protected final Character character;

	public ViewCharacter(Character character) {
		this.character = character;
	}

	public Character getCharacter() {
		return character;
	}
	public void affiche(Graphics2D g2d) {
		g2d.setColor(new Color(237,0,0));
		g2d.drawLine(
				(int)character.getX(), 
				(int)character.getY() - (int)character.getHeight(),
				(int)character.getX(),
				(int)character.getY());
	}
	
}
