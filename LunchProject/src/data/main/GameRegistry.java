package data.main;

import data.inventory.Slot;
import data.textures.Artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;


public class GameRegistry {
	
	private static Map<String, Texture> textures = new HashMap<String, Texture>();
	private static List<Slot> slots = new ArrayList<Slot>();

	public static Texture nullTexture;
	public static Texture air;
	public static Texture playerTexture;
	public static Texture grassTexture;
	public static Texture dirtTexture;
	public static Texture stoneTexture;
	public static Texture ironOreTexture;
	public static Texture[] crack = new Texture[6];
	public static Texture bullet;
	public static Texture slotOverlay;
	public static Texture inventoryBackground;
	public static Texture hotbar;
	public static Texture slot;

	/**
	 * TODO: Add texture atlas.
	 * No maybe later
	 * TODO: ADD TEXTURE ARRAY FOR THE CRACKS
	 */
	
	public static void setupTextures() {
		nullTexture = Artist.quickLoad("null");
		air = Artist.quickLoad("air");
		playerTexture = Artist.quickLoad("player");
		grassTexture = Artist.quickLoad("grass");
		dirtTexture = Artist.quickLoad("dirt2");
		ironOreTexture = Artist.quickLoad("oreIron");
		stoneTexture = Artist.quickLoad("stone");
		crack[0] = Artist.quickLoad("crack1");
		crack[1] = Artist.quickLoad("crack2");
		crack[2] = Artist.quickLoad("crack3");
		crack[3] = Artist.quickLoad("crack4");
		crack[4] = Artist.quickLoad("crack5");
		crack[5] = Artist.quickLoad("crack6");
		bullet = Artist.quickLoad("bullet");
		slotOverlay = Artist.quickLoad("slotOverlay");
		inventoryBackground = Artist.quickLoad("inventoryBackground");
		hotbar = Artist.quickLoad("hotbar");
		slot = Artist.quickLoad("slotBackground");
		
		registerTexture(nullTexture, "null");
		registerTexture(air, "air");
		registerTexture(playerTexture, "player");
		registerTexture(grassTexture, "grass");
		registerTexture(dirtTexture, "dirt");
		registerTexture(stoneTexture, "stone");
		registerTexture(ironOreTexture, "ironOre");
		registerTexture(crack[0], "crack1");
		registerTexture(crack[1], "crack2");
		registerTexture(crack[2], "crack3");
		registerTexture(crack[3], "crack4");
		registerTexture(crack[4], "crack5");
		registerTexture(crack[5], "crack6");
		registerTexture(bullet, "bullet");
		registerTexture(slotOverlay, "slotOverlay");
		registerTexture(inventoryBackground, "inventoryBackground");
		registerTexture(hotbar, "hotbar");
		registerTexture(slot, "slot");
	}

	public static Texture getTextureUnlocalized(String name) {
		return textures.get(name) != null ? textures.get(name) : nullTexture;
	}

	public static void registerTexture(Texture texture, String name) {
		textures.put(name, texture);
	}
	
	public static void registerSlot(Slot slot) {
		slots.add(slot);
	}
	public static void removeSlot(Slot slot) {
		slots.remove(slot);
	}
	public static void removeSlotD(Slot slot) {
		for(int i=0;i<slots.size();i++) {
			if (slots.get(i) == slot) {
				slots.remove(i);
			}
		}
	}
	
	public static void updateSlot() {
		for(int i=0;i<slots.size();i++) {
			slots.get(i).update();
		}
	}

}
