package data.objects;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;

import data.objects.physics.BoundingBox;
import data.textures.TextureData;

public class TypeObject {
	
	protected TextureData texture;
	protected Vector2f position;
	protected BoundingBox hitbox;
	
	public void update() {
		//this.hitbox.updatePosition(position);
	}
	
	public void onGPU() {
		
	}

	public TextureData getTextureData() {
		return texture;
	}
	public Texture getTexture() {
		return texture.getTexture();
	}

	public void setTexture(TextureData texture) {
		this.texture = texture;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public BoundingBox getHitbox() {
		return hitbox;
	}

	public void setHitbox(BoundingBox hitbox) {
		this.hitbox = hitbox;
	}
	
}
