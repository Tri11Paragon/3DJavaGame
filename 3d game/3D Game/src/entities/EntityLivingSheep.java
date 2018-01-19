package entities;

import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;
import terrains.World;

public class EntityLivingSheep extends EntityLiving {
	
	public World world;
	
	
	public EntityLivingSheep(String entityName, TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, 
			Vector3f entityColor, boolean allowUpdate, boolean allowGravity, boolean allowCollision, World world) {
		super(entityName, model, position, rotX, rotY, rotZ, scale, entityColor, allowUpdate, allowGravity, allowCollision);
		this.world = world;
		//super.addComponent(new BreedingComponent(world, 20));
		//super.addComponent(new RandomLookComponent(10, 10));
	}
	@Override
	public void update(World terrain) {
		super.update(terrain);
		//bounce.update(this);
	}
	
	
	
}
