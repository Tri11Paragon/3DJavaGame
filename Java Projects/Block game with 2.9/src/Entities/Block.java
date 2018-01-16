package Entities;

import org.lwjgl.util.vector.Vector3f;

import Models.TexturedModel;

public class Block {
	
	Entity entity;
	private String unlocalizedname;
	private boolean shouldRender = false;
	
	public Block(Entity entity, Block blockType) {
		this.entity = entity;
		this.entity.setModel(blockType.getEntity().getModel());
		this.unlocalizedname = blockType.getUnlocalizedname();
	}
	
	public Block (TexturedModel model, String name) {
		this.entity = new Entity(null, null, 0, 0, 0, 1);
		this.entity.setModel(model);
		this.unlocalizedname = name;
	}
	
	public Block (Block blockType, Vector3f pos) {
		this.entity = new Entity(blockType.getEntity().getModel(), pos, 0, 0, 0, 1);
		this.unlocalizedname = blockType.getUnlocalizedname();
	}


	public Entity getEntity() {
		return entity;
	}

	public String getUnlocalizedname() {
		return unlocalizedname;
	}

	public void setUnlocalizedname(String unlocalizedname) {
		this.unlocalizedname = unlocalizedname;
	}
	
	public Block markForRender() {
		this.shouldRender = true;
		return this;
	}
	
	public boolean getShouldRender() {
		return this.shouldRender;
	}
	
	public Block dontRender() {
		this.shouldRender = false;
		return this;
	}
	
	
}
