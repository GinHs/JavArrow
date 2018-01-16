package fr;
import java.io.*;
import java.util.List;

import fr.eseo.javarrow.model.Arrow;
import fr.eseo.javarrow.view.Window; 

public class Trajectory {
	
	public Trajectory (Arrow arrow) {
		this.arrow=arrow;
	}
	
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
		while(((x1-x2)*t+x0)<1800 && ((x1-x2)*t+x0)>0 && (-5*t*t+(y1-y2)*t+characterheight)<4000 && 0<(-5*t*t+(y1-y2)*t+characterheight) ) {
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
