package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import terrains.Terrain;

public class StaticFirst1st extends Camera {
	
	public Vector3f position = new Vector3f(0,0,0);
	public float pitch = 10; // Z
	public float yaw; // Y
	public float roll; // X
	
	float speed = 0.5f;
	float turnSpeed = 0.1f;
	float moveAtX = 0;
	float moveAtY = 0;
	
	//private static final float TERRAIN_HEIGHT = 0;
	
	public StaticFirst1st() {
		super(new Player3rd(null, null, 0, 0, 0, 1, null));
	}
	public void move(Terrain terrain) {
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
			moveAtY = -speed;
		} else {
			moveAtY = 0;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			position.y += speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			position.y -= speed;
		}
		
		pitch += -Mouse.getDY() * turnSpeed;
		yaw += Mouse.getDX() * turnSpeed;
		
		float speed = 3.5f;
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			yaw += -speed * turnSpeed;
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			yaw += speed * turnSpeed;
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
			pitch += -speed * turnSpeed;
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			pitch += speed * turnSpeed;
		
		float dx = (float) -(moveAtX * Math.sin(Math.toRadians(yaw)));
		float dy = (float) (moveAtX * Math.sin(Math.toRadians(roll)));
		float dz = (float) (moveAtX * Math.cos(Math.toRadians(yaw)));
		
		position.x += dx;
		position.y += dy;
		position.z += dz;
		
		float terrainHeight = terrain.getHeightOfTerrain(getPosition().x, getPosition().z);
		
		float offset = 1;
		if (getPosition().y < terrainHeight + offset) {
			getPosition().y = terrainHeight + offset;
		}
	}
	
	@Override
	public Vector3f getPosition() {
		return position;
	}
	
	@Override
	public float getPitch() {
		return pitch;
	}
	
	@Override
	public float getYaw() {
		return yaw;
	}
	
	@Override
	public float getRoll() {
		return roll;
	}
	
	@Override
	public void setPosition(Vector3f position) {
		this.position = position;
	}

}
