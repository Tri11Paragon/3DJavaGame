package entities;

import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	public Vector3f position = new Vector3f(0,0,0);
	public float pitch = 10; 
	public float yaw ; 
	public float roll;
	
	private Player3rd player;
	
	public Camera(Player3rd player){this.player = player;}
	
	public void move(){
		
	}
	
	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Player3rd getPlayer() {
		return player;
	}

}
