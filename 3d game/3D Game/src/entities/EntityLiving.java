package entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import entities.components.ComponentBase;
import entities.components.GeneBase;
import models.TexturedModel;
import terrains.Terrain;
import toolbox.Maths;
import toolbox.TranslationMatrix;


public class EntityLiving extends Entity {
	
	TexturedModel model;
	Vector3f position;
	float rotX, rotY, rotZ;
	float scale;
	public boolean isOnGround;
	private boolean allowUpdate;
	
	public List<ComponentBase> componentsArrtibsList = new ArrayList<ComponentBase>();
	public List<GeneBase> genes = new ArrayList<GeneBase>();
	private List<TranslationMatrix> translationMatrixList = new ArrayList<TranslationMatrix>();
	
	public EntityLiving(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, Vector3f entityColor, boolean allowUpdate) {
		super(model, position, rotX, rotY, rotZ, scale, entityColor);
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
		this.allowUpdate = allowUpdate;
	}
	
	public EntityLiving(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, Vector3f entityColor, boolean allowUpdate, List<ComponentBase> bases) {
		super(model, position, rotX, rotY, rotZ, scale, entityColor);
		this.model = model;
		this.position = position;
		this.rotX = rotX;
		this.rotY = rotY;
		this.rotZ = rotZ;
		this.scale = scale;
		this.allowUpdate = allowUpdate;
		componentsArrtibsList.addAll(bases);
	}
	
	public void update(Terrain terrain) {
		if (allowUpdate) {
			for (ComponentBase base : componentsArrtibsList) {
				base.update(this);
			}
			if (translationMatrixList.size() > 0) {
				doTranslation();
			}
			doTerrainCollision(terrain);
		}
	}
	
	public void doTerrainCollision(Terrain terrain) {
		float terrainHeight = terrain.getHeightOfTerrain(getPosition().x, getPosition().z);
		if (terrainHeight == -1000) {
			float offset = 0;
			if (getPosition().y < 0 + offset) {
				getPosition().y = 0 + offset;
				isOnGround = true;
			} else {
				isOnGround = false;
			}
		} else {
		
			float offset = 0;
			if (getPosition().y < terrainHeight + offset) {
				getPosition().y = terrainHeight + offset;
				isOnGround = true;
			} else {
				isOnGround = false;
			}
		
		}
	}
	
	public void addTranslation(Vector3f startPoint, Vector3f endPos, float deltaSpeed) {
		translationMatrixList.add(new TranslationMatrix(startPoint, endPos, deltaSpeed));
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
	
	public void setIsOnGround(boolean bool) {
		this.isOnGround = bool;
	}
	
	public EntityLiving addComponent(ComponentBase comp) {
		componentsArrtibsList.add(comp);
		return this;
	}
	
	public EntityLiving addComponent(ComponentBase comp, EntityLiving entity) {
		componentsArrtibsList.add(comp);
		return this;
	}
	
	public void addAllComponent(List<ComponentBase> component) {
		this.componentsArrtibsList.addAll(component);
	}
	
	public void addAllComponent(List<ComponentBase> component, EntityLiving entity) {
		this.componentsArrtibsList.addAll(component);
	}
	
	public List<ComponentBase> getComponent(){
		return componentsArrtibsList;
	}
	
	public List<GeneBase> getGenes(){
		return this.genes;
	}
	
	public void addAllGenes(List<GeneBase> genes) {
		this.genes.addAll(genes);
	}
	
	public void addGene(GeneBase genes) {
		this.genes.add(genes);
	}

	public boolean isAllowUpdate() {
		return allowUpdate;
	}

	public void setAllowUpdate(boolean allowUpdate) {
		this.allowUpdate = allowUpdate;
	}
	
}