package entities.components;

import engineTester.MainGameLoop;
import entities.EntityLiving;
import renderEngine.DisplayManager;
import toolbox.Maths;

public class BounceComponent extends ComponentBase {
	
	private float cooldown;
	private float bounceHeight;
	private float range;
	private float curr;
	float upwardsSpeed = 0;
	float moveAtX = 25.5f;
	
	public static final float GRAVITY = -500;
	
	public BounceComponent(float cooldown, float bounceHeight, float range) {
		super();
		this.cooldown = cooldown;
		this.bounceHeight = bounceHeight;
		this.range = range;
	}

	@Override
	public void update(EntityLiving entity) {
		upwardsSpeed += GRAVITY * MainGameLoop.getDeltaPhy();
		float dx = (float) -(Math.sin(Math.toRadians(-entity.getRotY())));
		float dz = (float) (Math.cos(Math.toRadians(-entity.getRotY())));
		float delta = MainGameLoop.getDeltaPhy();
		if (delta == 0.000f) { delta = 0.001f; }
		if (delta == 0.001f) { delta = 0.016f; }
		if (delta > 0.032) { delta = 0.016f; }
		System.out.println(delta);
		if (!entity.isOnGround) {
			entity.increasePosition(dx * delta * moveAtX, 0, dz * delta * moveAtX);
		}
		entity.increasePosition(0, upwardsSpeed * delta, 0);
		if (entity.isOnGround)
			curr -= DisplayManager.getDelta();
		if (curr > 0) {
			return;
		}
		if (entity.isOnGround) {
			this.upwardsSpeed = bounceHeight + Maths.randomFloat(range / 2, range);
		}
		if (curr <= 0){
			curr = cooldown;
		}
		return;
	}

	public float getCooldown() {
		return cooldown;
	}

	public float getBounceHeight() {
		return bounceHeight;
	}

	public float getRange() {
		return range;
	}

	public float getCurr() {
		return curr;
	}

	public float getUpwardsSpeed() {
		return upwardsSpeed;
	}

	public float getMoveAtX() {
		return moveAtX;
	}

	public static float getGravity() {
		return GRAVITY;
	}
	
}
