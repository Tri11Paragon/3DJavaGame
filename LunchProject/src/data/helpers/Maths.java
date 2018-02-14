package data.helpers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;


public class Maths {
	
	public static enum colors { NULL, COLOR_RED, COLOR_BLUE, COLOR_GREEN };

	public static Matrix4f createTransformationMatrix(Vector3f translation, float rx, float ry,
			float rz, float scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1,0,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0,1,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rz), new Vector3f(0,0,1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale,scale,scale), matrix, matrix);
		return matrix;
	}
	
	public static Matrix4f createTransformationMatrix(Vector2f translation, Vector2f rotation, Vector2f scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.scale(new Vector3f(scale.x, scale.y, 1f), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotation.x), new Vector3f(1,0,0), matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotation.y), new Vector3f(0,1,0), matrix, matrix);
		return matrix;
	}
	public static float barryCentric(Vector3f p1, Vector3f p2, Vector3f p3, Vector2f pos) {
		float det = (p2.z - p3.z) * (p1.x - p3.x) + (p3.x - p2.x) * (p1.z - p3.z);
		float l1 = ((p2.z - p3.z) * (pos.x - p3.x) + (p3.x - p2.x) * (pos.y - p3.z)) / det;
		float l2 = ((p3.z - p1.z) * (pos.x - p3.x) + (p1.x - p3.x) * (pos.y - p3.z)) / det;
		float l3 = 1.0f - l1 - l2;
		return l1 * p1.y + l2 * p2.y + l3 * p3.y;
	}
	
	/*public static Matrix4f createViewMatrix(Camera camera) {
		Matrix4f viewMatrix = new Matrix4f();
		viewMatrix.setIdentity();
		Matrix4f.rotate((float) Math.toRadians(camera.getPitch()), new Vector3f(1, 0, 0), viewMatrix,
				viewMatrix);
		Matrix4f.rotate((float) Math.toRadians(camera.getYaw()), new Vector3f(0, 1, 0), viewMatrix, viewMatrix);
		Vector3f cameraPos = camera.getPosition();
		Vector3f negativeCameraPos = new Vector3f(-cameraPos.x,-cameraPos.y,-cameraPos.z);
		Matrix4f.translate(negativeCameraPos, viewMatrix, viewMatrix);
		return viewMatrix;
	}*/
	
	public static float lerp(float point1, float point2, float alpha){
	    return point1 + alpha * (point2 - point1);
	}
	
	public static Vector3f lerp(Vector3f point1, Vector3f point2, float alpha){
		float x = point1.x + alpha * (point2.x - point1.x);
		float y = point1.y + alpha * (point2.y - point1.y);
		float z = point1.z + alpha * (point2.z - point1.z);
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
	
	public static Vector3f decodeRGB255(int r, int g, int b) {
		return new Vector3f(r/255,g/255,b/255);
	}
	
	public static float decodeRGB255(int b) {
		return b / 255;
	}
	
	public static double roundDown5(double d) {
	    return (long) (d * 1e5) / 1e5;
	}
	public static double roundDown4(double d) {
	    return (long) (d * 1e4) / 1e4;
	}
	public static double roundDown3(double d) {
	    return (long) (d * 1e3) / 1e3;
	}
	public static double roundDown2(double d) {
	    return (long) (d * 1e2) / 1e2;
	}
	// Don't use!
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public static int randomInt(int min, int max) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
	
	public static colors getEntityColor(Vector3f color) {
		if (color.x > color.y && color.x > color.z){
			return colors.COLOR_RED;
		} else if (color.y > color.x && color.y > color.z) {
			return colors.COLOR_GREEN;
		} else if (color.z > color.y && color.z > color.x) {
			return colors.COLOR_BLUE;
		}
		System.err.println("We are at the end of the line \n Please fix this method!");
		return colors.NULL;
	}
	
	public static Vector3f distance2(Vector3f first, Vector3f last) {
		return new Vector3f(first.x - last.x, first.y - last.y, first.z - last.z);
	}
	
	public static float randomFloat(float min, float max) {
		return (float) (min + Math.random() * (max - min));
	}

	/*// Or this. Slightly slower, but faster than creating objects. ;)
	public static double roundDown5(double d) {
	    return Math.floor(d * 1e5) / 1e5;
	}*/
	
}
