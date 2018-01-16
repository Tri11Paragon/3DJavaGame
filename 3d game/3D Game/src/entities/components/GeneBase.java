package entities.components;

import entities.EntityLiving;

public class GeneBase {
	
	@SuppressWarnings("unused")
	private EntityLiving entityLiving;
	@SuppressWarnings("unused")
	private float severity;
	
	public GeneBase(EntityLiving entityLiving, float severity) {
		this.entityLiving = entityLiving;
		this.severity = severity;
	}
	
	public void update() {
		
	}
	
}
