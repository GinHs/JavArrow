package fr.eseo.javarrow.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
	private Arrow a = new Arrow(50,50);
	
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
	
		Trajectory t = new Trajectory(this.a);
		try {
			t.calculateTrajectory(50,(float)x1,(float)x2,(float)y1,(float)y2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.createViewArrow();
		
	}
	
	public void mouseClicked(MouseEvent e){
	}


	public void mouseMoved(MouseEvent e){
		
	}
	
	public void mouseDragged(MouseEvent e){
		this.x2 = e.getX();
		this.y2 = e.getY();
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

	
	
	private void liberate(){
		this.getDraw().removeMouseListener(this.getDraw().getControler());
		this.getDraw().removeMouseMotionListener(this.getDraw().getControler());
	
	}
	
	public ViewArrow createViewArrow() {
		ViewArrow ve=new ViewArrow(this.a);
		return ve;
	}
}
