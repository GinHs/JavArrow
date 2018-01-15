package fr;
import java.io.*;

import fr.eseo.javarrow.model.Arrow; 

public class Trajectory {
	
	public Trajectory (Arrow arrow) {
		this.arrow=arrow;
	}
	
	Arrow arrow;
	float characterheight=50;
	int t=0;

	public void calculateTrajectory(float x0,float x1,float x2,float y1,float y2) throws InterruptedException {

		while(this.arrow.getY()<500 || this.arrow.getX()<500 ) {
		this.arrow.setX((x1-x2)*t+x0);
		this.arrow.setY(-5*t*t+(y1-y2)*t+characterheight);
		Thread.sleep(100);
		t++;
		
		}
	}
}
