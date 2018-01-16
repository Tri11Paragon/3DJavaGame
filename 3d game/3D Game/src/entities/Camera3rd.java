package entities;

import org.lwjgl.input.Mouse;

public class Camera3rd extends Camera {
	
	private float distanceFromPlayer = 50;
	private float angleAroundPlayer = 0;
	
	public Camera3rd(Player3rd player) {
		super(player);
	}
	@Override
	public void move() {
		calculateZoom();
		//calculateAngleAroundPlayer();
		calculatePitch();
		float horizontalDistance = calculateHorizontalDistance();
		float verticalDistance = calculateVerticlDistance();
		calculateCameraPosition(horizontalDistance, verticalDistance);
	}
	
	private void calculateZoom() {
		float zoomLevel = Mouse.getDWheel() * 0.1f;
		distanceFromPlayer -= zoomLevel;
	}
	
	private void calculatePitch() {
		if (Mouse.isButtonDown(1)) {
			float pitchChange = Mouse.getDY() * 0.1f;
			pitch -= pitchChange;
			if(pitch < 0)
				pitch = 0;
			else if(pitch > 45)
				pitch = 45;
		}
	}
	
	/*private void calculateAngleAroundPlayer() {
		if (Mouse.isButtonDown(0)) {
			float angleChange = Mouse.getDX() * 0.3f;
			angleAroundPlayer -= angleChange;
		}
	}*/
	
	private float calculateHorizontalDistance() {
		float hd = (float) (distanceFromPlayer * Math.cos(Math.toRadians(pitch)));
		if (hd < 1)
			hd = 1;
		return hd;
	}
	
	private float calculateVerticlDistance() {
		float vd =  (float) (distanceFromPlayer * Math.sin(Math.toRadians(pitch)));
		if (vd < 1)
			vd = 1;
		return vd;
	}
	
	private void calculateCameraPosition(float hd, float vd) {
		//float theta = player.getRotY() + angleAroundPlayer;
		//float offsetX = (float) (hd * Math.sin(Math.toRadians(theta)));
		//float offsetZ = (float) (hd * Math.cos(Math.toRadians(theta)));
		//System.out.println(offsetZ);
		this.position.x = super.getPlayer().getPosition().x;
		this.position.z = super.getPlayer().getPosition().z - -49.24f; // -49.24f is a good number
		this.position.y = super.getPlayer().getPosition().y + vd;
	}
	
	public float getDistanceFromPlayer() {
		return distanceFromPlayer;
	}

	public void setDistanceFromPlayer(float distanceFromPlayer) {
		this.distanceFromPlayer = distanceFromPlayer;
	}

	public float getAngleAroundPlayer() {
		return angleAroundPlayer;
	}

	public void setAngleAroundPlayer(float angleAroundPlayer) {
		this.angleAroundPlayer = angleAroundPlayer;
	}

}
