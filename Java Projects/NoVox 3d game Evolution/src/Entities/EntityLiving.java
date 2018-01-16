package Entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import Entities.Components.ComponentBase;
import Models.TexturedModel;
import Toolbox.Maths;
import Toolbox.TranslationMatrix;

public class EntityLiving extends Entity {
	
	TexturedModel model;
	Vector3f position;
	float rotX, rotY, rotZ;
	float scale;
	private boolean useGravity;
	public boolean isOnGround;
	Vector3f dir;
	float vel = 0;
	float drag = 0;
	
	public List<ComponentBase> componentsArrtibsList = new ArrayList<ComponentBase>();
	private List<TranslationMatrix> translationMatrixList = new ArrayList<TranslationMatrix>();
	
	public EntityLiving(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, boolean useGravity) {
		super(model, position, rotX, rotY, rotZ, scale);
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
		this.useGravity = useGravity;
	}
	
	public void addComponent(ComponentBase comp) {
		componentsArrtibsList.add(comp);
	}
	
	public List<ComponentBase> getComponent(){
		return componentsArrtibsList;
	}
	
	public void update() {
		for (ComponentBase base : componentsArrtibsList) {
			base.update();
		}
		if (vel > 0) {
			doVelocity();
		}
		if (translationMatrixList.size() > 0) {
			doTranslation();
		}
		if (vel < 0) {vel=0;}
		if (useGravity) {
			doGravity();
		}
	}
	
	public void addVelocity(Vector3f dir, float vel, float drag) {
		this.dir = dir;
		this.vel += (vel / 1000);
		this.drag += (drag / 10000);
	}
	
	public void addVelocityRaw(Vector3f dir, float vel, float drag) {
		this.dir = dir;
		this.vel += vel;
		this.drag += drag;
	}
	
	public void setVelocity(Vector3f dir, float vel, float drag) {
		this.dir = dir;
		this.vel = vel;
		this.drag = drag;
	}
	
	public void addTranslation(Vector3f startPoint, Vector3f endPos, float deltaSpeed) {
		translationMatrixList.add(new TranslationMatrix(startPoint, endPos, deltaSpeed));
	}
	
	public void doVelocity() {
		if (drag > 0){
			if (vel > 0) {
				this.translate(dir.x * vel, dir.y * vel, dir.z * vel);
				this.vel -= drag;
			}
		} else if (drag == 0) {
			this.translate(dir.x * vel, dir.y * vel, dir.z * vel);
		}
	}
	
	public void doTranslation() {
		Vector3f startPos = translationMatrixList.get(0).getStartPoint();
		Vector3f endPos = translationMatrixList.get(0).getEndPos();
		float deltaSpeed = translationMatrixList.get(0).getDeltaSpeed();
		Vector3f distace = Maths.distanceABS(startPos, endPos);
		Vector3f amountToTranslate = new Vector3f(distace.x / deltaSpeed, distace.y / deltaSpeed, distace.z / deltaSpeed);
		this.translate(amountToTranslate.x, amountToTranslate.y, amountToTranslate.z);
		if (this.getPosition() == endPos) {
			translationMatrixList.remove(0);
		}
	}
	
	public void doGravity() {
		if (isOnGround){
			
		} else {
			
		}
	}

	public boolean isUseGravity() {
		return useGravity;
	}

	public void setUseGravity(boolean useGravity) {
		this.useGravity = useGravity;
	}

	public Vector3f getDir() {
		return dir;
	}

	public void setDir(Vector3f dir) {
		this.dir = dir;
	}

	public float getVel() {
		return vel;
	}

	public void setVel(float vel) {
		this.vel = vel;
	}

	public float getDrag() {
		return drag;
	}

	public void setDrag(float drag) {
		this.drag = drag;
	}
	
	public void setIsOnGround(boolean bool) {
		this.isOnGround = bool;
	}
}
