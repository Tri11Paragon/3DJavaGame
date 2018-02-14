package data.objects.physics;

import java.awt.Rectangle;

import org.lwjgl.util.vector.Vector2f;

public class BoundingBox implements IBoundingBox {

	private float x,y,width,height;

	public BoundingBox(float x, float y, float width, float height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/*public boolean getIsWidthinBoundingBox(float x, float y) {
		if (this.x == x && this.y == y)
			return true;
		System.out.println(this.width + this.x + " Hello " + x);
		if (x > this.x && x < this.width + this.x)
			return true;
		return false;
	}*/
	public boolean getIsWidthinBoundingBox(float x, float y, float width, float height) {
		Rectangle rect = new Rectangle((int) this.x,(int) this.y,(int) this.width, (int) this.height);
		Rectangle rect2 = new Rectangle((int) x, (int) y, (int) width, (int) height);
		return rect.intersects(rect2);
	}
	public boolean getIsWidthinBoundingBox(float x, float y) {
		Rectangle rect = new Rectangle((int) this.x,(int) this.y,(int) this.width, (int) this.height);
		return rect.contains((int) x, (int) y);
		//return rect.inside((int) x, (int) y);
	}
	public boolean getIsWidthinBoundingBox(BoundingBox box) {
		Rectangle rect = new Rectangle((int) this.x,(int) this.y,(int) this.width, (int) this.height);
		return rect.contains((int) box.x, (int) box.y) || rect.intersects(new Rectangle((int) box.x, (int) box.y, (int) box.width, (int) box.height));
	}
	
	public void updatePosition(Vector2f vec) {
		this.x = vec.x;
		this.y = vec.y;
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

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
