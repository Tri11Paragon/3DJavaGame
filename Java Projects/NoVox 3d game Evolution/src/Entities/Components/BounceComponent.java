package Entities.Components;

import org.lwjgl.util.vector.Vector3f;

import Entities.Entity;
import Entities.EntityLiving;
import Toolbox.Clock;
import Toolbox.Debug;
import Toolbox.Maths;

@SuppressWarnings("unused")
public class BounceComponent extends ComponentBase {
	
	private EntityLiving entity;
	private int cooldown;
	private int bounceHeight;
	private Clock clock;
	int curr;
	
	public BounceComponent(EntityLiving entity, int cooldown, int bounceHeight, Clock clock) {
		super(entity);
		this.entity = entity;
		this.cooldown = cooldown;
		this.bounceHeight = bounceHeight;
		this.clock = clock;
	}

	@Override
	public void update() {
		//Debug.Log("HACKS FOR YOU: " + curr + " : " + clock.Delta());
		curr -= clock.Delta();
		if (curr > 0) {
			return;
		}
		for(int i = 0; i < bounceHeight; i++) {
			//entity.getPosition().y += i;
			entity.addVelocity(new Vector3f(0.1f, 1, 0), 10f, 0.01f);
		}
		curr = cooldown;
	}
}
