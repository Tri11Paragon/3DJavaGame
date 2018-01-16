package entities;

import models.TexturedModel;

import org.lwjgl.util.vector.Vector3f;

public class Entity {

	private TexturedModel model;
	private Vector3f position;
	private float rotX, rotY, rotZ;
	private float scale;
	
	public Vector3f entityColor;
	private boolean colorChanged;

	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ,
			float scale, Vector3f entityColor) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
		this.entityColor = entityColor;
		this.colorChanged = true;
	}

	public void increasePosition(float dx, float dy, float dz) {
		this.position.x += dx;
		this.position.y += dy;
		this.position.z += dz;
	}

	public void increaseRotation(float dx, float dy, float dz) {
		this.rotX += dx;
		this.rotY += dy;
		this.rotZ += dz;
	}
	
	public void increasePosition(Vector3f pos) {
		this.position.x += pos.x;
		this.position.y += pos.y;
		this.position.z += pos.z;
	}
	
	public void translate(float x, float y, float z) {
		this.position.x += x;
		this.position.y += y;
		this.position.z += z;
	}
	
	public void setPos(float x, float y, float z) {
		this.position.x = x;
		this.position.y = y;
		this.position.z = z;
	}
	
	public void rotate(float rx, float ry, float rz) {
		if (this.rotY + ry <= 360) {
			this.rotY += ry;
		} else {
			this.rotY = 0;
		}
		this.rotX += rx;
		
		this.rotZ += rz;
	}

	public TexturedModel getModel() {
		return model;
	}

	public void setModel(TexturedModel model) {
		this.model = model;
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public float getRotX() {
		return rotX;
	}

	public void setRotX(float rotX) {
		this.rotX = rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public void setRotY(float rotY) {
		this.rotY = rotY;
	}

	public float getRotZ() {
		return rotZ;
	}

	public void setRotZ(float rotZ) {
		this.rotZ = rotZ;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}
	
	public Vector3f getEntityColor() {
		return entityColor;
	}

	public void setEntityColor(Vector3f entityColor) {
		this.entityColor = entityColor;
		this.colorChanged = true;
	}

	public boolean isColorChanged() {
		return colorChanged;
	}

	public void setColorChanged(boolean colorChanged) {
		this.colorChanged = colorChanged;
	}
}
