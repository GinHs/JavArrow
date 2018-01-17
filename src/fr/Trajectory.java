package fr;
import java.io.*;
import java.util.List;

import fr.eseo.javarrow.model.Arrow;
import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.ViewArrow;
import fr.eseo.javarrow.view.Window; 
import fr.eseo.javarrow.model.Game;

public class Trajectory {
	
	public Draw draw;
	public Arrow arrow;
	public float characterheight = 50;
	public float t = 0;
	public int n = 0;
	
	
	public Trajectory (Draw draw,Arrow arrow,int x1,int x2,int y1,int y2) {
		this.arrow=arrow;
		this.draw=draw;
		this.characterheight=this.draw.getGame().getActivePlayer().getHeight();
		int sol = (int) this.draw.getGame().getActivePlayer().getY();
		Traject(this.draw.getGame().getActivePlayer().getX(),x1,x2,sol-y1,sol-y2);
	}
	
	public void Traject(float pos,int x1,int x2,int y1,int y2){
		int [][]tab=calculateTrajectory((float)pos,(float)x1,(float)x2,(float)y1,(float)y2);
		int j=1;
		while (j<tab[0].length-1 && !(tab[0][j+1]==0 && tab[1][j+1]==0)) {
			Arrow arrow = new Arrow(tab[0][j-1],tab[1][j-1],tab[0][j+1],tab[1][j+1]);
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.draw.addView(new ViewArrow(arrow));
			this.draw.paintComponent(this.draw.getGraphics());
			j++;
		}
		
		if (this.draw.getGame().getNotActivePlayer().isReach(tab[0][j],tab[1][j])) {
			draw.getGame().increaseRound();
		}else {
			draw.getGame().changeActivePlayer();;
		}
		this.draw.repaint();
		
	}
	
	public int[][] calculateTrajectory(float x0,float x1,float x2,float y1,float y2) {
		int [][] i = new int [2][10000];
		int PosP1 =(int) this.draw.getGame().getPlayer1().getX();
		int PosP2 = (int) this.draw.getGame().getPlayer2().getX();
		
		//Limitation de la force maximum pour rendre le jeu plus difficile
		if ((x1-x2)>75) {
			x2=x1-75;
		} else if ((x1-x2)<-75){
			x2=x1+75;
		}
		
		//calcul de la trajectoire
		while(((x1-x2)*t+x0)<(PosP2+1) && ((x1-x2)*t+x0)>(PosP1-1) && (-5*t*t+(y1-y2)*t+characterheight)<4000 && 0<(-5*t*t+(y1-y2)*t+characterheight) ) {
		i[0][n]=(int) ((x1-x2)*t+x0);
		i[1][n]=(int)(-5*t*t+(y1-y2)*t+characterheight);
		t=(float) (t+0.25);
		n++;
		}
		if (n>2) {
		//Rectification pour que la derni�re fleche soit sur le sol ou les murs
			if (((x1-x2)*t+x0)>PosP2){
				i[0][n]=PosP2;
				i[1][n]=i[1][n-1]+(-i[1][n-2]+i[1][n-1]);
			}
			if (((x1-x2)*t+x0)<(PosP1)){
				i[0][n]=PosP1;
				i[1][n]=i[1][n-1]+(-i[1][n-2]+i[1][n-1]);
			}
			if (0>(-5*t*t+(y1-y2)*t+characterheight)) {
				i[0][n]=i[0][n-1]+(-i[0][n-2]+i[0][n-1]);
				i[1][n]=0;
			}
		}
			
		return i;
		
	}
	
	
}
