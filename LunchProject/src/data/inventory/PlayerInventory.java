package data.inventory;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import data.main.Boot;
import data.main.Game;
import data.main.GameRegistry;
import data.objects.blocks.Blocks;
import data.objects.player.PlayerSelf;
import data.textures.Artist;

public class PlayerInventory {
	
	private Slot[] slots = new Slot[96];
	private HotBar bar;
	private boolean isOpen;
	
	int curInt = 0;
	int fod = 32;
	public PlayerInventory(int posx, int posy) {
		for (int i=posx; i<16+posx;i++) {
			for(int j=posy; j < 6+posy; j++) {
				slots[curInt] = new Slot(new ItemStack(1), new Vector2f(i*fod+2,j*fod+2), fod, fod);
				slots[curInt].setDisplay(false);
				curInt++;
			}
		}
		isOpen = false;
		setItemToNullInventory(new ItemStack(Blocks.ironOre,1),0);
		setItemToNullInventory(new ItemStack(Blocks.dirt, 1),1);
		bar = new HotBar();
	}

	public void updateSlots() {
		/**
		 * One less nested if 
		 */
		if (Keyboard.isKeyDown(Keyboard.KEY_E) && Keyboard.next() && Keyboard.getEventKeyState()) {
			this.setOpen(!isOpen);
		}
		bar.update();
		Artist.drawText(Artist.version, 0, 0,24);
		for (int o=0; o < slots.length;o++) {
			if (slots[o].getDisplay()) {
				Artist.drawQuadTexture(GameRegistry.slot, slots[o].getPosition().x-2, slots[o].getPosition().y-2, 28, 28);
				slots[o].update();
			}
		}
		if (PlayerSelf.stackInHand != null && PlayerSelf.stackInHand.getBlock() != null) {
			Artist.drawQuadTexture(PlayerSelf.stackInHand.getBlock().getTexture(), (float)Math.floor(Mouse.getX()),(float) Math.floor((Boot.HEIGHT - Mouse.getY() - 1)), 32, 32);
			Artist.drawText("" + PlayerSelf.stackInHand.getStackSize(), (float)Math.floor(Mouse.getX())+32,(float) Math.floor((Boot.HEIGHT - Mouse.getY() - 1)) +32, Color.white,24);
		}
	}
	
	@SuppressWarnings("unused")
	public boolean setItemToNullInventory(ItemStack stack) {
		try {
			for (int i = 0; i < slots.length; i++) {
				if (slots[i].getStack().getBlock() == null) {
					slots[i].setStack(stack);
					return true;
				} else {
					return false;
				}
			}
			return false;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean setItemToNullInventory(ItemStack stack, int i) {
		try {
		if (slots[i].getStack().getBlock() == null) {
			slots[i].setStack(stack);
			return true;
		}
		return false;
		} catch(Exception e) {return false;}
	}
	/**
	 * I have no fucking clue why
	 * I you don't know whats going on, don't both. I don't either.
	 * SUCH NESTING
	 * 
	 * LOL
	 * 
	 * WTF HAVE I DONE?
	 * 
	 * 
	 * THIS IS REALLY FUCKED UP
	 * 
	 * CURRENTLY ON THE FOURTH NESTED LEVEL?
	 * 
	 * HOLY FUCK
	 * 
	 * TODO: FIX ME
	 * 
	 * @param stack the stack to set to the first null inventory
	 * @return the amount to keep
	 */
	int l;
	public int addItemToNullInventory(ItemStack stack) {
		try {
			for (int i = 0; i < slots.length; i++) {
				l++;
				if (slots[i].getStack() != null) {
					if (slots[i].getStack().getBlock() != null) {
						//|| slots[i].getStack().getBlock().getTexture() == stack.getBlock().getTexture()
						if (slots[i].getStack().getBlock() == stack.getBlock() || slots[i].getStack().getBlock().getTexture() == stack.getBlock().getTexture()) {
							if (slots[i].getStack().getStackSize() + stack.getStackSize() <= slots[i].getStack().getMaxStackSize()) {
								slots[i].getStack().setStackSize(slots[i].getStack().getStackSize() + stack.getStackSize());
								return 0;
							} else {
								int sd = slots[i].getStack().getStackSize() + stack.getStackSize();
								int sdd = sd - slots[i].getStack().getMaxStackSize();
								slots[i].getStack().setStackSize(slots[i].getStack().getMaxStackSize());
								if (true) {
									for (int d=0; d < slots.length;d++) {
										if (slots[i+d].getStack().getBlock() != null) {
											//|| slots[i].getStack().getBlock().getTexture() == stack.getBlock().getTexture()
											if (slots[i+1].getStack().getBlock() == stack.getBlock() || slots[i+d].getStack().getBlock().getTexture() == stack.getBlock().getTexture()) {
												if (slots[i+d].getStack().getStackSize() + stack.getStackSize() <= slots[i+d].getStack().getMaxStackSize()) {
													slots[i+d].getStack().setStackSize(slots[i+d].getStack().getStackSize() + stack.getStackSize());
													return 0;
												} else {
													slots[i+d].getStack().setStackSize(slots[i+d].getStack().getMaxStackSize());
												}
											}
										}
										if (slots[i+d].getStack().getBlock() == null) {
											slots[i+d].setStack(stack);
											Game.log("DG");
											return 0;
										}
									}
								}
								return sdd;
							}
						}
					}
					if (slots[i].getStack().getBlock() == null) {
						slots[i].setStack(stack);
						Game.log("DG");
						return 0;
					}
				}
				if (slots[i].getStack() == null) {
					slots[i].setStack(stack);;
					Game.log("DD");
					return 0;
				}
				
			}
			Game.log("WS");
			return stack.getStackSize();
		} catch(Exception e) {
			return stack.getStackSize();
		}
	}
	
	public int addItemToInventory(ItemStack stack, int i) {
		try {
			if(slots[i].getStack().getBlock() == null) {
				slots[i].setStack(stack);
				return 0;
			} else {
				if (slots[i].getStack().getBlock() == stack.getBlock()) {
					if (slots[i].getStack().getStackSize() + stack.getStackSize() <= stack.getMaxStackSize()) {
						slots[i].getStack().setStackSize(slots[i].getStack().getStackSize() + stack.getStackSize());
						return 0;
					} else {
						int st = slots[i].getStack().getStackSize() + stack.getStackSize();
						st -= stack.getMaxStackSize();
						slots[i].getStack().setStackSize(stack.getMaxStackSize());
						System.out.println("Hello WE are at the inventory" + st);
						return st;
					}
				} else {
					return stack.getStackSize();
				}
			}
		} catch(Exception e) {
			return stack.getStackSize();
		}
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
		for (int i = 0; i < slots.length; i++) {
			slots[i].setDisplay(isOpen);
		}
	}
	
}
