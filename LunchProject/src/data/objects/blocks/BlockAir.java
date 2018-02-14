package data.objects.blocks;

import org.lwjgl.util.vector.Vector2f;

import data.main.GameRegistry;
import data.textures.TextureData;

public class BlockAir extends Block{

	public BlockAir(Vector2f position) {
		super(new TextureData(GameRegistry.air, "air"), position);
	}
	@Override
	public Block getBlockDropped() {
		return null;
	}
	
	
}
