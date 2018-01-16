package terrains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import entities.Entity;
import entities.EntityLiving;

public class World {
	
	/**
	 * 
	 */
	
	public List<EntityLiving> entityLivingList = Collections.synchronizedList(new ArrayList<EntityLiving>());;
	
	private Terrain terrain; 
	private int worldSize; // NOTE: this is the size of the world NOT the amount of chunks;
	private int chunkWorldSize; // NOTE: this is the amount of chunks per each direction;
	private final int chunkSize = 50;
	
	public World(Terrain terrain) {
		this.terrain = terrain;
		this.worldSize = (int) terrain.getSize();
		this.chunkWorldSize = worldSize / chunkSize;
	}
	public void addEntityLivingToWorld(EntityLiving entity) {
		entityLivingList.add(entity);
	}
	
	public Entity getEntityLivingAtPos(Vector3f pos) {
		for (int i = 0; i < entityLivingList.size(); i++) {
			if (entityLivingList.get(i).getPosition() == pos){
				return entityLivingList.get(i);
			}
		}
		return null;
	}
	
	public Entity getEntityLivingAtPos(float x, float y, float z) {
		Vector3f pos = new Vector3f(x,y,z);
		for (int i = 0; i < entityLivingList.size(); i++) {
			if (entityLivingList.get(i).getPosition() == pos){
				return entityLivingList.get(i);
			}
		}
		return null;
	}
	
	public List<Entity> getEntityLivingInRage(float x, float y, float z, float range){
		// NOTE: Range is a +- value!
		float posXN = x - range;
		float posYN = y - range;
		float posZN = z - range;
		float posXP = x + range;
		float posYP = y + range;
		float posZP = z + range;
		
		List<Entity> tempList = new ArrayList<Entity>();
		
		for (int p = 0; p < entityLivingList.size(); p++) {
			for (float i = posXN; i < posXP; i++) {
				for (float j = posYN; j < posYP; j++) {
					for (float k = posZN; k < posZP; k++) {
						if (entityLivingList.get(p).getPosition() == new Vector3f(i,j,k)) {
							tempList.add(entityLivingList.get(p));
						}
					}
				}
			}
		}
		
		return tempList;
		
	}
	
	public List<EntityLiving> getLivingEntitiesInRange(float x, float y, float z, float range){
		float posXN = x - range;
		float posYN = y - range;
		float posZN = z - range;
		float posXP = x + range;
		float posYP = y + range;
		float posZP = z + range;
		
		List<EntityLiving> tempList = new ArrayList<EntityLiving>();
		
		for (int p = 0; p < entityLivingList.size(); p++) {
			EntityLiving ent = entityLivingList.get(p);
			if (ent.getPosition().x >= posXN && ent.getPosition().x <= posXP){
				if (ent.getPosition().y >= posYN && ent.getPosition().y <= posYP) {
					if (ent.getPosition().z >= posZN && ent.getPosition().z <= posZP) {
						tempList.add(ent);
					}
				}
			}
		}
		
		return tempList;
	}
	
	public List<EntityLiving> getEntityLivingList(){
		try {
			return entityLivingList;
		}catch(Exception e) {
			return entityLivingList;
		}
	}
	
}
