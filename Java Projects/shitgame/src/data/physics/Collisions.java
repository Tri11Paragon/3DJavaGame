package data.physics;

public class Collisions {
	
	public static boolean calculateIntersect(Collider col, Collider col2) {
		return col.getX() < col2.getX() + col.getWidth() && col.getX() + col.getWidth() > col2.getX() && col.getY() < col2.getY() + col2.getHeight() && col.getY() + col.getHeight() > col2.getY();
	}
	
}
