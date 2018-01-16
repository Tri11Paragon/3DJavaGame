package terrains;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import entities.Entity;

public class Chunk {
	
	private int gridX;
	private int gridY;
	
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Chunk(int gridX, int gridY) {
		this.gridX = gridX;
		this.gridY = gridY;
	}
	public Chunk(int gridX, int gridY, Entity entity) {
		this.gridX = gridX;
		this.gridY = gridY;
		entities.add(entity);
	}
	public Chunk(int gridX, int gridY, List<Entity> entites) {
		this.gridX = gridX;
		this.gridY = gridY;
		this.entities = entites;
	}
	public int getGridX() {
		return gridX;
	}
	public int getGridY() {
		return gridY;
	}
	public List<Entity> getEntities() {
		return entities;
	}
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public Entity getEntityAtPos(Vector3f pos) {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).getPosition() == pos){
				return entities.get(i);
			}
		}
		return null;
	}
	
	public Entity getEntityAtPos(float x, float y, float z) {
		Vector3f pos = new Vector3f(x,y,z);
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).getPosition() == pos){
				return entities.get(i);
			}
		}
		return null;
	}
	
}
