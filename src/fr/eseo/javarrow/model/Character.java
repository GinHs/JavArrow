package fr.eseo.javarrow.model;

public class Character {

	/**
	 * Properties of the Character
	 */
	public String name;
	public float x;
	public float y;
	public float height;
	public float width;


	/**
	 * Constructor
	 * @param name
	 * @param x
	 * @param y
	 */
	public Character(String name, float x, float y,float width, float height) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	/**
	 * Function to determine if the arrow reached the character
	 * @param x
	 * @param y
	 * @return True or False
	 */
	public boolean isReach(float x, float y) {
		return (x == this.getX()) && (y >= 800-this.getY()) && (y <= 800-this.getY()+this.getHeight());
	}
	
	
	/**
	 * Setters and getters to get properties
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
	
}
