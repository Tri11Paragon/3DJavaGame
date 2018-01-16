package Toolbox;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;

public class Maths {
	
	public static Matrix4f createTransformationMatrix(Vector3f translation, float rotX, float rotY, float rotZ, float scale) {
		
		Matrix4f matrix = new Matrix4f();
		
		matrix.setIdentity();
		
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotX), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotY), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotZ), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale, scale, scale), matrix, matrix);
		
		return matrix;
		
	}
	
	public static Matrix4f createViewMatrix(Camera camera) {
		
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		
		Matrix4f.rotate((float) Math.toRadians(camera.getRotX()), new Vector3f(1, 0, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getRotY()), new Vector3f(0, 1, 0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getRotZ()), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.translate(new Vector3f(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z), matrix, matrix);
		
		return matrix;
		
	}

	public static float lerp(float point1, float point2, float alpha){
	    return point1 + alpha * (point2 - point1);
	}
	
	public static Vector3f lerp(Vector3f point1, Vector3f point2, float alpha){
		float x = point1.x + alpha * (point2.x - point1.x);
		float y = point1.y + alpha * (point2.y - point1.y);
		float z = point1.z + alpha * (point2.z - point1.z);
		Debug.Log(new Vector3f(x, y, z) + "");
	    return new Vector3f(x, y, z);
	}
	public static Vector3f lerpA(Vector3f point1, Vector3f point2, float alpha){
		float x = point1.x + alpha * (point2.x - point1.x);
		float y = point1.y + alpha * (point2.y - point1.y);
		float z = point1.z + alpha * (point2.z - point1.z);
		point1.x += x;
		point1.y += y;
		point1.z += z;
		
	    return new Vector3f(x, y, z);
	}
	public static Vector3f distance(Vector3f point1, Vector3f point2) {
		Vector3f vec = new Vector3f(point1.x - point2.x, point1.y - point2.y, point1.z - point2.z);
		return vec;
	}
	public static Vector3f distanceABS(Vector3f point1, Vector3f point2) {
		Vector3f vec = new Vector3f(Math.abs(point1.x - point2.x), Math.abs(point1.y - point2.y), Math.abs(point1.z - point2.z));
		return vec;
	}
	
}
