package fr;
import java.io.*;
import java.util.List;

import fr.eseo.javarrow.model.Arrow;
import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.ViewArrow;
import fr.eseo.javarrow.view.Window; 

public class Trajectory {
	
	public Trajectory (Draw draw,Arrow arrow,int pos,int x1,int x2,int y1,int y2) {
		this.arrow=arrow;
		this.draw=draw;
		Traject(pos,x1,x2,y1,y2);
	}
	
	public void Traject(int pos,int x1,int x2,int y1,int y2){
		int [][]tab=calculateTrajectory((float)pos,(float)x1,(float)x2,800-(float)y1,800-(float)y2);
		int j=1;
		while (j<tab[0].length-1 && !(tab[0][j+1]==0 && tab[1][j+1]==0)) {
			
			Arrow arrow = new Arrow(tab[0][j-1],tab[1][j-1],tab[0][j+1],tab[1][j+1]);
			/* System.out.println("/n j : "+j);
			System.out.println("/n x1 : "+tab[0][j-1]);
			System.out.println("/n y1 : "+tab[1][j-1]);
			System.out.println("/n x1 : "+tab[0][j+1]);
			System.out.println("/n y1 : "+tab[1][j+1]);*/
			this.draw.addView(new ViewArrow(arrow));
			j++;
		}
		
		
	}
	Draw draw;
	Arrow arrow;
	float characterheight=50;
	float t=0;
	int n=0;
	

	public int[][] calculateTrajectory(float x0,float x1,float x2,float y1,float y2) {
		int [][] i = new int [2][10000000];
		System.out.println("x1"+x1);
		System.out.println("y1"+y1);
		System.out.println("x2"+x2);
		System.out.println("y2"+y2);
		while(((x1-x2)*t+x0)<1800 && ((x1-x2)*t+x0)>100 && (-5*t*t+(y1-y2)*t+characterheight)<4000 && 0<(-5*t*t+(y1-y2)*t+characterheight) ) {
		i[0][n]=(int) ((x1-x2)*t+x0);
		i[1][n]=(int)(-5*t*t+(y1-y2)*t+characterheight);
		//System.out.println("/n t : "+t);
		//System.out.println("/n x : "+i[0][t]);
		//System.out.println("/n y : "+i[1][t]);
		t=(float) (t+0.25);
		n++;
		}
		return i;
		
	}
}
