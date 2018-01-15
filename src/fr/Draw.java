package fr;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.javarrow.controller.Controler;
import fr.eseo.javarrow.view.ViewArrow;



public class Draw extends JPanel{
	public static int length=500;
	public static int height=500;
	public static Color Color=new Color(255,255,255);
	private Controler controler;
	
	public Controler getControler() {
		return controler;
	}

	public void setControler(Controler controler) {
		this.controler = controler;
	}

	private List <ViewArrow> vueFormes = new ArrayList <ViewArrow>();
	
	public Draw(int largeur,int hauteur, Color fond) {
		super();
		Dimension d=new Dimension(largeur, hauteur);
		super.setPreferredSize(d);
		super.setBackground(fond);
		super.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g){ 
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		g2D.setColor(new Color(51,51,51));
		for(int i=0;i<vueFormes.size();i++)
			this.vueFormes.get(i).affiche(g2D);
		g2D.dispose(); 
	
	}
}
