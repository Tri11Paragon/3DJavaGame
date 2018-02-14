package data.inventory;

import java.awt.Rectangle;

import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import data.main.Boot;
import data.main.GameRegistry;
import data.objects.player.PlayerSelf;
import data.textures.Artist;

public class Slot {
	
	private Vector2f position;
	private Vector2f size;
	private Rectangle slotRect;
	private ItemStack stack;
	private boolean display = true;
	
	public Slot(ItemStack stack, Vector2f position, float width, float height) {
		this.position = position;
		this.slotRect = new Rectangle((int)position.x, (int)position.y, (int)width, (int)height);
		this.size = new Vector2f(width,height);
		this.stack = stack;
	}
	
	/**
	 * Nested ifss how fun/
	 */
	public void update() {
		if (display) {
			Vector2f pos = new Vector2f((float)Math.floor(Mouse.getX()),(float) Math.floor((Boot.HEIGHT - Mouse.getY() - 1)));
			if (slotRect.contains((int)pos.x, (int)pos.y) && display){
				drawOverLay();
				while (Mouse.next()){
				    if (!Mouse.getEventButtonState()) {
				        if (Mouse.getEventButton() == 0) {
				        	if(stack != null && PlayerSelf.stackInHand != null){
								ItemStack tempItem = PlayerSelf.stackInHand;
								PlayerSelf.stackInHand =stack;
								stack = tempItem;
								tempItem =null;
								return;
							} else {
								if (stack != null && PlayerSelf.stackInHand == null) {
									PlayerSelf.stackInHand = stack;
									stack = null;
									return;
								} else {
									stack = PlayerSelf.stackInHand;
									PlayerSelf.stackInHand = null;
									return;
								}
							}
				        }
				    }
				}
			}
		}
		if (stack!=null&&display&&stack.getBlock()!=null) {
			Artist.drawQuadTextureRaw(stack.getBlock().getTexture(), (float)position.x+4.5f, position.y+5, size.x-16, size.y-16);
			Artist.drawText("" + stack.getStackSize(), position.x, position.y, Color.white,14);
		}
	}
	
	public void drawOverLay() {
		Artist.drawQuadTextureRaw(GameRegistry.slotOverlay, position.x, position.y, size.x, size.y);
	}
	
	public void setDisplay(boolean f) {
		this.display=f;
	}
	
	public boolean getDisplay() {
		return display;
	}

	public ItemStack getStack() {
		return stack;
	}

	public void setStack(ItemStack stack) {
		this.stack = stack;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	
	
}
