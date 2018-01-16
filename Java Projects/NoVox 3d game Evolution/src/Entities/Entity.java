package Entities;

import org.lwjgl.util.vector.Vector3f;

import Models.TexturedModel;

public class Entity {
	
	TexturedModel model;
	Vector3f position;
	float rotX, rotY, rotZ;
	float scale;
	
	public Vector3f entityColor;
	
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, Vector3f entityColor) {
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
		this.entityColor = entityColor;
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
		this.rotX += rx;
		this.rotY += ry;
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
	}
	
}
