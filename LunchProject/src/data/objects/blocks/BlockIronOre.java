package data.objects.blocks;

import org.lwjgl.util.vector.Vector2f;

import data.main.GameRegistry;
import data.objects.physics.BoundingBox;
import data.textures.Artist;
import data.textures.TextureData;

public class BlockIronOre extends Block {

	public BlockIronOre(Vector2f position) {
		super(new TextureData(GameRegistry.ironOreTexture, "ironOre"), position, new BoundingBox(position.x, position.y, Artist.BlockSize, Artist.BlockSize));
	}
	public BlockIronOre() {
		super(new TextureData(GameRegistry.ironOreTexture, "ironOre"), null);
	}
	
	
}
