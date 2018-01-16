package com.main.entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	Vector3f position;
	float rotX;
	float rotY;
	float rotZ;
	
	float speed = 0.1f;
	float turnSpeed = 0.1f;
	float moveAtX = 0;
	float moveAtY = 0;
	
	public Camera(Vector3f position, float rotX, float rotY, float rotZ) {
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
	}

	public void move() {
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			moveAtX = -speed;
		}
		else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			moveAtX = speed;
		} else {
			moveAtX = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			moveAtY = speed;
		} else
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			moveAtY = speed;
		} else {
			moveAtY = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			position.y += speed / 2;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			position.y -= speed / 2;
		}
		
		rotX += -Mouse.getDY() * turnSpeed;
		rotY += Mouse.getDX() * turnSpeed;
		
		float dx = (float) -(moveAtX * Math.sin(Math.toRadians(rotY)));
		//float dy = (float) (moveAtX * Math.sin(Math.toRadians(rotX)));
		float dz = (float) (moveAtX * Math.cos(Math.toRadians(rotY)));
		
		position.x += dx;
		//position.y += dy;
		position.z += dz;
		
	}
	
	public Vector3f getPosition() {
		return position;
	}

	public float getRotX() {
		return rotX;
	}

	public float getRotY() {
		return rotY;
	}

	public float getRotZ() {
		return rotZ;
	}
	
}
