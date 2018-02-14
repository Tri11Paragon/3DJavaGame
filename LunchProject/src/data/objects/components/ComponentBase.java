package data.objects.components;

import org.lwjgl.util.vector.Vector2f;

import data.objects.TypeObject;

public class ComponentBase implements IComponent {
	
	protected Vector2f masterPosition;
	protected int masterEntityId;
	protected String masterName;
	protected TypeObject master;
	
	public ComponentBase(TypeObject master) {
		this.master=master;
	}
	
	@Override
	public void update() {
		this.masterPosition = master.getPosition();
	}

	@Override
	public void render() {
		
	}

	public Vector2f getMasterPosition() {
		return masterPosition;
	}

	public void setMasterPosition(Vector2f masterPosition) {
		this.masterPosition = masterPosition;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public int getMasterEntityId() {
		return masterEntityId;
	}

	public TypeObject getMaster() {
		return master;
	}

}
