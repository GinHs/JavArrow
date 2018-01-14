package fr;

public class Character {

	public String name;
	public float x;
	public float y;
	public float height;
	public int nbWin;
	public static final float HEIGHT_PER_DEFAULT = 10;

	public Character(String name, float x, float y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.height = HEIGHT_PER_DEFAULT;
		this.nbWin = 10;
	}
	
	public boolean isReach(float x, float y) {
		return (x >= this.getX()) && (y == this.getY()) && (x <= this.getHeight());
		
	}
	
	
	/**
	 * Setters and getters 
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public int getNbWin() {
		return nbWin;
	}
	
	public void setNbWin(int nbWin) {
		this.nbWin = nbWin;
	}

}
