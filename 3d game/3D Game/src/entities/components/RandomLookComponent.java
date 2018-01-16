package entities.components;

import entities.EntityLiving;
import toolbox.Maths;

public class RandomLookComponent extends ComponentBase {

	private float chance;
	private float amount;
	
	public RandomLookComponent(float chance, float amount) {
		super();
		this.chance = chance;
		this.amount = amount;
	}
	
	@Override
	public void update(EntityLiving entity) {
		if (Maths.randomInt((int) -chance, (int) chance) == 0) {
			entity.rotate(0, Maths.randomFloat(-amount, amount), 0);
		}
	}

}
