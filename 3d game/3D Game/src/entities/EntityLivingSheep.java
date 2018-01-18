package entities;

import org.lwjgl.util.vector.Vector3f;

import entities.components.BounceComponent;
import models.TexturedModel;
import terrains.Terrain;
import terrains.World;

public class EntityLivingSheep extends EntityLiving {
	
	public World world;
	public BounceComponent bounce;
	
	
	public EntityLivingSheep(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, 
			Vector3f entityColor, boolean allowUpdate, World world, BounceComponent bounce) {
		super(model, position, rotX, rotY, rotZ, scale, entityColor, allowUpdate);
		this.world = world;
		this.bounce = bounce;
		//super.addComponent(new BreedingComponent(world, 20));
		//super.addComponent(new RandomLookComponent(10, 10));
	}
	@Override
	public void update(Terrain terrain) {
		super.update(terrain);
		//bounce.update(this);
	}
	
	
	
}
