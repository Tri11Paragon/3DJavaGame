package entities;

import org.lwjgl.util.vector.Vector3f;

import entities.components.BounceComponent;
import entities.components.BreedingComponent;
import entities.components.RandomLookComponent;
import models.TexturedModel;
import terrains.Terrain;
import terrains.World;
import toolbox.Maths;

public class EntityLivingSheep extends EntityLiving {
	
	public World world;
	
	public EntityLivingSheep(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale, Vector3f entityColor, boolean allowUpdate, World world) {
		super(model, position, rotX, rotY, rotZ, scale, entityColor, allowUpdate);
		this.world = world;
		//super.addComponent(new BounceComponent(1.35f, 70, 100.0f));
		//super.addComponent(new BreedingComponent(world, 20));
		super.addComponent(new RandomLookComponent(10, 10));
	}
	
	public void update(Terrain terrain) {
		super.update(terrain);
		if (Maths.randInt(0, 10) == 0) {
			this.world.entityLivingList.remove(this);
		}
	}
	
	
	
}
