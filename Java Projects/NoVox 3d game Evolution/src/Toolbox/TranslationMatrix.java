package Toolbox;

import org.lwjgl.util.vector.Vector3f;

public class TranslationMatrix {
	
	Vector3f startPoint; 
	Vector3f endPos; 
	float deltaSpeed;
	public TranslationMatrix(Vector3f startPoint, Vector3f endPos, float deltaSpeed) {
		this.startPoint = startPoint;
		this.endPos = endPos;
		this.deltaSpeed = deltaSpeed;
	}
	public Vector3f getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Vector3f startPoint) {
		this.startPoint = startPoint;
	}
	public Vector3f getEndPos() {
		return endPos;
	}
	public void setEndPos(Vector3f endPos) {
		this.endPos = endPos;
	}
	public float getDeltaSpeed() {
		return deltaSpeed;
	}
	public void setDeltaSpeed(float deltaSpeed) {
		this.deltaSpeed = deltaSpeed;
	}
}
