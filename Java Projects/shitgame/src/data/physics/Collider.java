package data.physics;

import java.awt.Color;
import java.awt.Graphics;

public class Collider {
	
	private float x;
	private float y;
	private float width;
	private float height;
	private boolean isAlive = true;
	private Color c;
	private int tag;
	
	public Collider(int tag, float x, float y, float width, float height, Color c) {
		this.tag = tag;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
	}
	
	public void paint(Graphics g) {
		if (getIsAlive()) {
			g.setColor(c);
			g.drawRect((int)x, (int)y,(int) width, (int)width);
	        g.fillRect((int)x, (int)y, (int)width, (int)width);
	        g.setColor(c);
		}
	}
	
	public void kill() {
		this.x = -500;
		this.y = -500;
		this.width = 0;
		this.height = 0;
		isAlive = false;
	}
	
	public boolean overlaps (Collider r) {
	    return x < r.getX() + r.getWidth() && x + width > r.getX() && y < r.getY() + r.getHeight() && y + height > r.getY();
	}
	
	public Color getColor() {
		return c;
	}
	
	public boolean getIsAlive() {
		return isAlive;
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
	public float getWidth() {
		return width;
	}
	public float getHeight() {
		return height;
	}
	
	public int getTag() {
		return tag;
	}

	
	
}
