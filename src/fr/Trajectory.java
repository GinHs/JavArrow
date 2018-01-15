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
	int t=0;
	

	public int[][] calculateTrajectory(float x0,float x1,float x2,float y1,float y2) {
		int [][] i = new int [2][1000];
		while(this.arrow.getY()<500 || this.arrow.getX()<500 ) {
		i[0][t]=(int) ((x1-x2)*t+x0);
		i[1][t]=(int)(-5*t*t+(y1-y2)*t+characterheight);
		t++;
		
		}
		return i;
		
	}
}
