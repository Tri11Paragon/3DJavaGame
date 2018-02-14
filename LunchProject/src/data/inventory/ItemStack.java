package data.inventory;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.opengl.Texture;

import data.objects.blocks.Block;
import data.textures.TextureData;

public class ItemStack {
	
	private Block block;
	private int stackSize;
	private int maxStackSize;
	
	public ItemStack(Block block, int stackSize, int maxStackSize) {
		this.block = block;
		this.stackSize = stackSize;
		this.maxStackSize = maxStackSize;
	}
	public ItemStack(Block block, int stackSize) {
		this.block = block;
		this.stackSize = stackSize;
		this.maxStackSize = 128;
	}
	public ItemStack(int stackSize) {
		this.block = null;
		this.stackSize = stackSize;
		this.maxStackSize = 128;
	}
	public ItemStack(Texture texture, int stackSize) {
		this.block = new Block(new TextureData(texture, "n"), new Vector2f(0,0));
		this.stackSize = stackSize;
		this.maxStackSize = 128;
	}
	public int getStackSize() {
		return stackSize;
	}
	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}
	public int getMaxStackSize() {
		return maxStackSize;
	}
	public void setMaxStackSize(int maxStackSize) {
		this.maxStackSize = maxStackSize;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	
}
