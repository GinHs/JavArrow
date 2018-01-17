package fr.eseo.javarrow.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.Game;
import fr.Trajectory;
import fr.eseo.javarrow.model.Arrow;
import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.ViewArrow;
 

public class Controler implements MouseListener,MouseMotionListener{
	
	
	public Controler(Draw draw){
		this.draw = draw;
		associate(draw);
	};
	
	
	private Draw draw;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Arrow a = new Arrow(0,0,0,0);
	int p =101;
	int sol = 800;
	int height =100;
	
	public Draw getDraw() {
		return this.draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}
	
	public void mousePressed(MouseEvent e){
		this.x1 = e.getX();
		this.y1 = e.getY();
		
	
	}
	public void mouseReleased(MouseEvent e){
		this.x2 = e.getX();
		this.y2 = e.getY();
		if (x1<p+5 && x1>p-5 && y1<sol && y1>(sol-height)) {
			new Trajectory(this.draw,this.a,x1, x2, y1, y2);
			}
	}
	
	public void mouseClicked(MouseEvent e){
	}


	public void mouseMoved(MouseEvent e){
		
	}
	
	public void mouseDragged(MouseEvent e){
		p=(int)this.draw.getGame().getActivePlayer().getX();
		sol=(int)this.draw.getGame().getActivePlayer().getY();
		height = (int)this.draw.getGame().getActivePlayer().getHeight();
		if (x1<p+5 && x1>p-5 && y1<sol && y1>(sol-height)) {
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

	
	

	
	
}
