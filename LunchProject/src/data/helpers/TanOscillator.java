package data.helpers;

import org.lwjgl.util.vector.Vector2f;

import data.objects.TypeObject;

public class TanOscillator {
	
	public boolean useX = false;
	public boolean useY = false;

	public float amp = 10;
	public float speed = 1;

	public Vector2f startPosition;
	public TypeObject obj;

	public TanOscillator(TypeObject obj, boolean useX, boolean useY, float amp, float speed, Vector2f startPosition) {
		this.useX = useX;
		this.useY = useY;
		this.amp = amp;
		this.speed = speed;
		this.startPosition = startPosition;
		this.obj = obj;
	}
	
	public void Update ()
	{
		float x = startPosition.x;
		float y = startPosition.y;

		if(useX)
			x = (float) (x + amp*Math.tan (Clock.startTime * speed));
		if(useY)
			y = (float) (y + amp*Math.tan (Clock.startTime * speed));

		obj.setPosition(new Vector2f (x, y));
	}
	
}
