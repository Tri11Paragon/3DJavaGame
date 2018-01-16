package Main.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Entities.Block;
import Entities.Blocks;
import Entities.Camera;

public class World {
	
	public static final int WORLD_SIZE = 5;
	
	static List<Block> entities = Collections.synchronizedList(new ArrayList<Block>());
	static List<Vector3f> usedPos = new ArrayList<Vector3f>();
	
	private Vector3f camPos;
	protected World world;
	
	public World(Camera camPos) {
		this.camPos = camPos.getPosition();
		this.world = this;
	}
	
	public void start() {
		
		/* for the most part I have no idea what this is doing.
		* I'm just trying to put this together.
		* Future me if your reading, this works.
		* If you can find a better way to do this then go ahead.
		*/
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				
				
				while (!Display.isCloseRequested()) {
					
					for (int i=(int) 0; i < 2; i++) {
						for (int k=(int) 0; k < 2; k++) {
							Chunk chunk = new Chunk(world, new Vector3f(i * 8,0, k * 8));
							chunk.generateChunk();
							chunk.onChunkModified();
						}
					}
					
					/*for (int i = 0; i < entities.size(); i++) {
						
						int distX = (int) (camPos.x - entities.get(i).getEntity().getPosition().x);
						int distZ = (int) (camPos.z - entities.get(i).getEntity().getPosition().z);
						
						if (distX < 0) {distX = -distX;}if (distZ < 0) {distZ = -distZ;}
						
						if ((distX > WORLD_SIZE) || ( distZ > WORLD_SIZE)) {
							usedPos.remove(entities.get(i).getEntity().getPosition());
							entities.remove(i);
						}
						
					}*/
					
				}
			}
			}).start();
	}
	
	public List<Block> getBlocks() {
		return entities;
	}
	
	public List<Vector3f> getUsedPos(){
		return usedPos;
	}
	
	public void addUsedPos(Vector3f pos) {
		usedPos.add(pos);
	}
	
	public void addBlock(Block block) {
		entities.add(block);
	}
	
	public Block getBlock(int index) {
		return entities.get(index);
	}
	
	public Block getBlockAtPos(Vector3f vec) {
		try {
		if (entities.size() < 1) {
			return Blocks.blockAIR;
		}
		for (Block block : entities) {
			if (block.getEntity().getPosition().x == vec.x && block.getEntity().getPosition().y == vec.y && block.getEntity().getPosition().z == vec.z) {
				return block;
			}
		}
		return Blocks.blockAIR;
		} catch (Exception e) {
			return Blocks.blockAIR;
		}
	}
	
	public Block getBlockAtPos(float x, float y, float z) {
		try {
		if (entities.size() < 1) {
			return Blocks.blockAIR;
		}
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).getEntity().getPosition().x == x && entities.get(i).getEntity().getPosition().y == y && entities.get(i).getEntity().getPosition().z == z) {
				return entities.get(i);
			}
		}
		return Blocks.blockAIR;
		} catch (Exception e) {
			return Blocks.blockAIR;
		}
	}
	
	
}
