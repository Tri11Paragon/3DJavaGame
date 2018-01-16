package guis;

import org.lwjgl.util.vector.Vector2f;

public class GuiTexture {
	
	private int texture;
	private Vector2f position;
	private Vector2f scale;
	private Vector2f rotation;
	
	public GuiTexture(int texture, Vector2f position, Vector2f scale, Vector2f rotation) {
		this.texture = texture;
		this.position = position;
		this.scale = scale;
		this.rotation = rotation;
	}
	public int getTexture() {
		return texture;
	}
	public Vector2f getPosition() {
		return position;
	}
	public Vector2f getScale() {
		return scale;
	}
	public Vector2f getRotation() {
		return rotation;
	}
	
}
