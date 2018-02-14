package data.helpers;

import data.inventory.Slot;
import data.objects.blocks.Block;
import data.textures.Artist;

public class LoganHelper {
	
	
	public static void drawBlock(Block block) {
		Artist.drawQuadTexture(block.getTexture(), block.getPosition().x, block.getPosition().y, Artist.BlockSize, Artist.BlockSize);
	}
	
	public static void drawSlot(Slot slot) {
		slot.update();
	}
	
}
