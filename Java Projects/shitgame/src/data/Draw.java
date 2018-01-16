package data;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import data.physics.Collider;

public class Draw extends JComponent {
	
	public int currentTagLevel = 0;
	
	public List<Collider> colliders = new ArrayList<Collider>();
	
	private static final long serialVersionUID = -2609409411705101651L;
    
    public void add(Collider c) {
    	for (int i=0; i < colliders.size(); i++) {
	        if (colliders.get(i).getTag() == c.getTag()) {
	        	System.err.println("Please use a differnt tag!!! (" + c.getTag() + ")");
	        	return;
	        }
	        repaint();
	    }
    	currentTagLevel = c.getTag();
    	colliders.add(c);
    	repaint();
    }
    
    public void Move(float x, float y, int tag) {
    	for (int i=0; i < colliders.size(); i++) {
	        if (colliders.get(i).getTag() == tag) {
	        	colliders.get(i).setX(colliders.get(i).getX() + x);
	        	colliders.get(i).setY(colliders.get(i).getY() + y);
	        }
	        repaint();
	    }
    	repaint();
    }
    public void moveTo(float x, float y, int tag) {
    	for (int i=0; i < colliders.size(); i++) {
	        if (colliders.get(i).getTag() == tag) {
	        	colliders.get(i).setX(x);
	        	colliders.get(i).setY(y);
	        }
	        repaint();
	    }
    	repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
	    for (int i=0; i < colliders.size(); i++) {
	        colliders.get(i).paint(g);
	        repaint();
	    }
    }
	
}
