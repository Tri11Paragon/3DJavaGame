package data.objects.blocks;

import org.lwjgl.util.vector.Vector2f;

import data.main.GameRegistry;
import data.objects.physics.BoundingBox;
import data.textures.Artist;
import data.textures.TextureData;

public class BlockDirt extends Block{

	public BlockDirt(Vector2f position) {
		super(new TextureData(GameRegistry.dirtTexture, "dirt"), position, new BoundingBox(position.x, position.y, Artist.BlockSize, Artist.BlockSize));
	}
	public BlockDirt() {
		super(new TextureData(GameRegistry.dirtTexture, "dirt"), null);
	}

	

}
