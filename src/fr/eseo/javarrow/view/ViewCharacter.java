package fr.eseo.javarrow.view;

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
		g2d.drawLine(
				(int)character.getX()+50, 
				(int)character.getY()+50,
				(int)character.getX()-50,
				(int)character.getY()-50);
	}
	
}
