package fr;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
 

public abstract class Controler implements MouseListener,MouseMotionListener{
	
	
	public Controler(Draw draw){
		this.draw=draw;
	};
	
	
	private Draw draw;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Arrow a=new Arrow(50,50);
	
	

	
	public Draw getDraw() {
		return this.draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
	}
	
	public void mousePressed(MouseEvent e){
		this.x1=e.getX();
		this.y1=e.getY();
	
	}
	public void mouseReleased(MouseEvent e){
		Trajectory t = new Trajectory(this.a);
		t.calculateTrajectory(50,(float)x1,(float)x2,(float)y1,(float)y2);
		this.createViewArrow();
	}
	
	public void mouseClicked(MouseEvent e){
		
	}


	public void mouseMoved(MouseEvent e){
		
	}
	
	public void mouseDragged(MouseEvent e){
		this.x2=e.getX();
		this.y2=e.getY();
	}
	public void mouseEntered(MouseEvent e){
		
	}
	
	public void mouseExited(MouseEvent e){
		
	}

		
	public void associer(Draw panneau){
			this.getDraw().setControler(this);
			this.getDraw().addMouseListener(this);
			this.getDraw().addMouseMotionListener(this);
		}

	
	
	private void liberer(){
		this.getDraw().removeMouseListener(this.getDraw().getControler());
		this.getDraw().removeMouseMotionListener(this.getDraw().getControler());
	
	}
	
	public ViewArrow createViewArrow() {
		ViewArrow ve=new ViewArrow(this.a);
		return ve;
	}
}
