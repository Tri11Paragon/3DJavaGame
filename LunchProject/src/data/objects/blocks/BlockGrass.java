package data.objects.blocks;

import org.lwjgl.util.vector.Vector2f;

import data.main.GameRegistry;
import data.objects.physics.BoundingBox;
import data.textures.Artist;
import data.textures.TextureData;

public class BlockGrass extends Block {

	public BlockGrass(Vector2f position) {
		super(new TextureData(GameRegistry.grassTexture, "grass"), position,
				new BoundingBox(position.x, position.y, Artist.BlockSize, Artist.BlockSize));
	}
	public BlockGrass() {
		super(new TextureData(GameRegistry.grassTexture, "grass"), null);
	}
	
	public Block getBlockDropped() {
		return new BlockDirt(position);
	}

	int j = 0;

	/*@Override
	public void update() {
		int random = Maths.randInt(0, 10);
		if (random == 2) {
			Block[] blocksAroundGrass = new Block[9];
			blocksAroundGrass[0] = Map.getBlockM((this.position.x + Artist.BlockSize), this.position.y);
			blocksAroundGrass[1] = Map.getBlockM((this.position.x - Artist.BlockSize), this.position.y);
			blocksAroundGrass[2] = Map.getBlockM((this.position.x + Artist.BlockSize), this.position.y + Artist.BlockSize);
			blocksAroundGrass[3] = Map.getBlockM((this.position.x + Artist.BlockSize), this.position.y - Artist.BlockSize);
			blocksAroundGrass[4] = Map.getBlockM((this.position.x - Artist.BlockSize), this.position.y + Artist.BlockSize);
			blocksAroundGrass[5] = Map.getBlockM((this.position.x - Artist.BlockSize), this.position.y - Artist.BlockSize);
			blocksAroundGrass[6] = Map.getBlockM((this.position.x), this.position.y + Artist.BlockSize);
			blocksAroundGrass[7] = Map.getBlockM((this.position.x), this.position.y - Artist.BlockSize);
			for (int i = 0; i < blocksAroundGrass.length; i++) {
				if (blocksAroundGrass[i] != null) {
					System.out.println("we are nulling at: " + i);
					if (blocksAroundGrass[i].getTexture() == GameRegistry.dirtTexture) {
						System.out.println("Our code is working");
					}
				}
			}
		}

	}*/

}
