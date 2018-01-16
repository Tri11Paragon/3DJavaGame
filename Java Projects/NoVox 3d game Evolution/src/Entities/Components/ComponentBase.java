package Entities.Components;

import Entities.EntityLiving;

public class ComponentBase implements IComponent {
	
	@SuppressWarnings("unused")
	private EntityLiving entity;
	
	public ComponentBase(EntityLiving entity) {
		this.entity = entity;
	}
	
	@Override
	public void update() {
	}

}
