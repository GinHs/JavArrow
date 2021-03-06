package fr.eseo.javarrow.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/** 
 * Panneau d'affichage de debut
 */
@SuppressWarnings("serial")
public class DrawBegin  extends JPanel{
	public static int length = 500;
	public static int height = 500;
	public static Color Color=new Color(255,255,255);
	
	/**
	 * Constructeur du panneau d'affichage du lancement du jeu
	 * @param largeur
	 * @param hauteur
	 * @param fond
	 */
	public DrawBegin(int largeur,int hauteur, Color fond) {
		super();
		Dimension d = new Dimension(largeur, hauteur);
		super.setPreferredSize(d);
		super.setBackground(fond);
		super.setVisible(true);
	}
}
