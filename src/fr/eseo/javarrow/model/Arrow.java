package fr.eseo.javarrow.model;

public class Arrow {
	private float x;
	private float y;
	private float length = 10;
	
	public Arrow(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	
	
}
