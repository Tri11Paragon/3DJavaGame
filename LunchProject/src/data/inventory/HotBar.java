package data.inventory;

import org.lwjgl.util.vector.Vector2f;

import data.main.Boot;
import data.main.GameRegistry;
import data.textures.Artist;

public class HotBar {
	
	Slot[] slots = new Slot[9];
	int x = Boot.WIDTH/3;
	public HotBar() {
		for (int i = 0; i < slots.length; i++) {
			slots[i] = new Slot(null, new Vector2f(x+(i*28),Boot.HEIGHT-41), 28, 28);
		}
	}
	
	public void update() {
		//Artist.drawQuadTexture(GameRegistry.hotbar, Boot.WIDTH/3f, Boot.HEIGHT-50, 400, 50);
		for (int i = 0; i < slots.length; i++) {
			Artist.drawQuadTexture(GameRegistry.slot, slots[i].getPosition().x-3, slots[i].getPosition().y-3, 28, 28);
			slots[i].update();
		}
	}
	
}
