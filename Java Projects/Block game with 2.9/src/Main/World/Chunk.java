package Main.World;

import org.lwjgl.util.vector.Vector3f;

import Entities.Block;
import Entities.Blocks;
import Entities.Entity;
import Toolbox.TimeChecker;

public class Chunk {
	
	public final int xSize = 16;
	public int ySize = 45;
	public final int zSize = 16;
	
	World world;
	Vector3f startPos;
	
	public Chunk(World world, Vector3f pos) {
		this.world = world;
		this.startPos = pos;
	}
	
	public Chunk generateChunk() {
		for (int i = (int) startPos.x; i < xSize + startPos.x; i++) {
			for (int j = (int) startPos.y; j < ySize + startPos.y; j++) {
				for (int k = (int) startPos.z; k < zSize + startPos.z; k++) {
					Vector3f vec = new Vector3f(i, j, k);
					if (!world.getUsedPos().contains(vec)) {
						Block block = new Block(new Entity(Blocks.blockDIRT.getEntity().getModel(), vec, 0,0,0,1), Blocks.blockDIRT).markForRender();
						world.addBlock(block);
						world.addUsedPos(vec);
					}
				}
			}
		}
		//onChunkModified();
		return this;
	}
	
	public void onChunkModified() {
		TimeChecker checker = new TimeChecker();
		checker.start();
		for (int i = 0; i < world.getBlocks().size(); i++) {
			Block orgBlock = world.getBlocks().get(i);
			Vector3f pos = orgBlock.getEntity().getPosition();
			if (world.getBlockAtPos(pos.x, pos.y + 1, pos.z) == Blocks.blockAIR 
					|| world.getBlockAtPos(pos.x, pos.y - 1, pos.z) == Blocks.blockAIR 
					|| world.getBlockAtPos(pos.x + 1, pos.y, pos.z) == Blocks.blockAIR
					|| world.getBlockAtPos(pos.x - 1, pos.y, pos.z) == Blocks.blockAIR
					|| world.getBlockAtPos(pos.x, pos.y, pos.z + 1) == Blocks.blockAIR
					|| world.getBlockAtPos(pos.x, pos.y, pos.z - 1) == Blocks.blockAIR) {
				world.getBlocks().get(i).markForRender();
			} else {
				world.getBlocks().get(i).dontRender();
			}
		}
		checker.stop();
	}
	
	public void combineMeshes() {
		for (Block b : world.getBlocks()) {
			
			b.getEntity().getModel().getModel().getVaoID();
		}
	}
	
	public boolean removeBlock(Vector3f pos) {
		try {
			if (world.getBlocks().size() < 1) {
				return true;
			}
			for (int i = 0; i < world.getBlocks().size(); i++) {
				if (world.getBlocks().get(i).getEntity().getPosition().x == pos.x && world.getBlocks().get(i).getEntity().getPosition().y == pos.y && world.getBlocks().get(i).getEntity().getPosition().z == pos.z) {
					world.getBlocks().remove(i);
					onChunkModified();
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return true;
		}
		
	}
	
	public boolean removeBlock(float x, float y, float z) {
		try {
			if (world.getBlocks().size() < 1) {
				return false;
			}
			for (int i = 0; i < world.getBlocks().size(); i++) {
				if (world.getBlocks().get(i).getEntity().getPosition().x == x && world.getBlocks().get(i).getEntity().getPosition().y == y && world.getBlocks().get(i).getEntity().getPosition().z == z) {
					world.getBlocks().remove(i);
					onChunkModified();
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
}
