package fr.eseo.javarrow.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JLabel;

import fr.eseo.javarrow.model.Character;

public class ViewCharacter {
	protected final Character character; 

	public ViewCharacter(Character character) {
		this.character = character;
	}

	public Character getCharacter() {
		return character;
	}
	
	public void affiche(Graphics2D g2d,Draw draw) {
		Image img1 = Toolkit.getDefaultToolkit().getImage("image/Stickman.png");
	    g2d.drawImage(img1, (int)character.getX()-25, (int)character.getY()-100,(int)character.width,(int)character.height, draw);
	    g2d.finalize();	    
	}
	
}
