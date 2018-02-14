package data.objects.blocks;

import org.lwjgl.util.vector.Vector2f;

import data.main.GameRegistry;
import data.objects.physics.BoundingBox;
import data.textures.Artist;
import data.textures.TextureData;

public class BlockStone extends Block {

	public BlockStone() {
		super(new TextureData(GameRegistry.stoneTexture, "stone"), null);
	}
	public BlockStone(Vector2f position) {
		super(new TextureData(GameRegistry.stoneTexture, "stone"), position, new BoundingBox(position.x, position.y, Artist.BlockSize, Artist.BlockSize));
	}

}
