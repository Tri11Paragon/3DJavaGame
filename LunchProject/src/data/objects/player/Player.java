package data.objects.player;

import java.awt.Rectangle;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import data.helpers.Clock;
import data.helpers.Facing;
import data.inventory.ItemStack;
import data.inventory.PlayerInventory;
import data.main.Boot;
import data.main.GameRegistry;
import data.objects.TypeObject;
import data.objects.blocks.BlockAir;
import data.objects.blocks.BlockDirt;
import data.objects.blocks.BlockGrass;
import data.objects.blocks.BlockIronOre;
import data.objects.blocks.BlockStone;
import data.objects.blocks.Blocks;
import data.objects.map.Map;
import data.objects.physics.BoundingBox;
import data.textures.Artist;
import data.textures.TextureData;

@SuppressWarnings("unused")
public class Player extends TypeObject {
	
	private BoundingBox playerBox = new BoundingBox(0,0,1,1);
	
	private boolean isColliding = false;
	public boolean[] canMoveIn = new boolean[4];

	private Facing facing = Facing.Up;
	public int recheckCollision = 0;
	private PlayerInventory inv;
	
	private int[] direction = new int[3];
	
	public static Vector2f position;
	
	
	public Player(TextureData texture, float x, float y, PlayerInventory inv) {
		this.texture = texture;
		super.position = new Vector2f(x,y);
		position = new Vector2f(x,y); 
		this.playerBox = new BoundingBox(position.x, position.y, 32, 32);
		canMoveIn[0] = true;
		canMoveIn[1] = true;
		canMoveIn[2] = true;
		canMoveIn[3] = true;
		this.inv = inv;
	}
	
	public void draw() {
		Artist.drawQuadTexture(this.texture.getTexture(), position.x, position.y, 32, 32);
	}
	
	public void updateCollision(BoundingBox box) {
		/*isColliding = playerBox.getIsWidthinBoundingBox(box);
		//System.out.println(playerBox.getY() + " " + playerBox.getX() + " " + box.getY() + " " + box.getX());
		this.playerBox.updatePosition(position);
		if (isColliding){
			direction[1] = 0;
			direction[0] = 0;
			float con = 1.7f; //TODO: Add some fancy math;
			if (this.facing == Facing.Up){
				canMoveIn[0] = false;
				this.position.y += con;
			} else if (this.facing == Facing.Down){
				canMoveIn[1] = false;
				this.position.y += -(con);
			} else if (this.facing == Facing.Left){
				canMoveIn[2] = false;
				this.position.x += con;
				this.position.y -= 1f;
			} else if (this.facing == Facing.Right){
				canMoveIn[3] = false;
				this.position.x += -con;
				this.position.y -= 1f;
			}
		}*/
		
	}
	
	@Override
	public void update() {
		//world.removeBody(body);
		//body.translate(new Vector2(this.position.x, this.position.y));
		//world.addBody(body);
		
		mousePicker();
		if (canMoveIn[1]) {
			//this.position.y += 1;
			//this.facing = Facing.Down;
			//canMoveIn[0] = true;
			//canMoveIn[2] = true;
			//canMoveIn[3] = true;
		}
		while (Keyboard.next()) {
			direction[0] = resetDir(direction[0]);
			direction[1] = resetDir(direction[0]);
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)&&canMoveIn[0]) {
				direction[0] = -1;
				this.facing = Facing.Up;
				canMoveIn[1] = true;
				canMoveIn[2] = true;
				canMoveIn[3] = true;
				recheckCollision = 1;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				direction[0] = 1;
				this.facing = Facing.Down;
				canMoveIn[0] = true;
				canMoveIn[2] = true;
				canMoveIn[3] = true;
				recheckCollision = 1;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_A)&&canMoveIn[2]) {
				direction[1] = -1;
				this.facing = Facing.Left;
				canMoveIn[0] = true;
				canMoveIn[1] = true;
				canMoveIn[3] = true;
				recheckCollision = 1;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D)&&canMoveIn[3]) {
				direction[1] = 1;
				this.facing = Facing.Right;
				canMoveIn[0] = true;
				canMoveIn[2] = true;
				canMoveIn[1] = true;
				recheckCollision = 1;
			}
			if(Keyboard.getEventKey() == Keyboard.KEY_ESCAPE && Keyboard.getEventKeyState()){
				Display.destroy();
				System.exit(0);
			}
		}
		position.y+=direction[0]*Clock.Delta()*120;
		position.x+=direction[1]*Clock.Delta()*120;
	}
	int i = 0;
	public void mousePicker() {
		if (Keyboard.isKeyDown(Keyboard.KEY_O) && !Keyboard.getEventKeyState()) {
			for (int x=0; x<Map.getMap().length;x++) {
				for (int y=0; y<Map.getMap()[0].length;y++) {
					int returnedVal = 0;
					try {
						returnedVal = this.inv.addItemToNullInventory(new ItemStack(Map.getBlock(x, y).getBlockDropped(), 1));
					} catch(Exception e) {}
					Map.setBlock(x, y, new BlockAir(new Vector2f(x, y)));
				}
			}
		}
		if (Mouse.isButtonDown(0) && !inv.isOpen()) {
			Vector2f posd = new Vector2f((float)Math.floor(Mouse.getX()),(float) Math.floor((Boot.HEIGHT - Mouse.getY() - 1)));
			if (!new Rectangle(Boot.WIDTH/3-20,Boot.HEIGHT-50,285,70).contains(posd.x, posd.y)) {
				i++;
				i %=30;
				Vector2f pos = new Vector2f((float)Math.floor(Mouse.getX() / Artist.BlockSize),(float) Math.floor((Boot.HEIGHT - Mouse.getY() - 1)/Artist.BlockSize));
				//System.out.println(i);
				if (i==29) {
					int returnedVal = 0;
					/*if (Map.getBlock(pos.x, pos.y).getBlockDropped() instanceof BlockGrass) {
						returnedVal = this.inv.addItemToNullInventory(new ItemStack(Blocks.dirt, 1));
					} else if (Map.getBlock(pos.x, pos.y).getBlockDropped() instanceof BlockStone) {
						returnedVal = this.inv.addItemToNullInventory(new ItemStack(Blocks.stone, 1));
					} else if (Map.getBlock(pos.x, pos.y).getBlockDropped() instanceof BlockDirt) {
						returnedVal = this.inv.addItemToNullInventory(new ItemStack(Blocks.dirt, 1));
					} else if (Map.getBlock(pos.x, pos.y).getBlockDropped() instanceof BlockIronOre) {
						returnedVal = this.inv.addItemToNullInventory(new ItemStack(Blocks.ironOre, 1));
					}*/
					try {
						returnedVal = this.inv.addItemToNullInventory(new ItemStack(Map.getBlock(pos.x, pos.y).getBlockDropped(), 1));
					} catch(Exception e) {}
					if (returnedVal > 0) {
						return;
					}
					//SoundManager manger = new SoundManager("explosion.wav");
					Map.setBlock(pos.x, pos.y, new BlockAir(new Vector2f(pos.x, pos.y)));
					//manger.killALData();
				}
				if (i>0 && i < 5) {
					Artist.drawQuadTexture(GameRegistry.crack[0], pos.x*Artist.BlockSize, pos.y*Artist.BlockSize, Artist.BlockSize, Artist.BlockSize);
				} else if (i>5 && i < 10) {
					Artist.drawQuadTexture(GameRegistry.crack[1], pos.x*Artist.BlockSize, pos.y*Artist.BlockSize, Artist.BlockSize, Artist.BlockSize);
				} else if (i>10 && i < 15) {
					Artist.drawQuadTexture(GameRegistry.crack[2], pos.x*Artist.BlockSize, pos.y*Artist.BlockSize, Artist.BlockSize, Artist.BlockSize);
				} else if (i>15 && i < 20) {
					Artist.drawQuadTexture(GameRegistry.crack[3], pos.x*Artist.BlockSize, pos.y*Artist.BlockSize, Artist.BlockSize, Artist.BlockSize);
				}else if (i>20 && i < 25) {
					Artist.drawQuadTexture(GameRegistry.crack[4], pos.x*Artist.BlockSize, pos.y*Artist.BlockSize, Artist.BlockSize, Artist.BlockSize);
				}else if (i>25 && i < 30) {
					Artist.drawQuadTexture(GameRegistry.crack[5], pos.x*Artist.BlockSize, pos.y*Artist.BlockSize, Artist.BlockSize, Artist.BlockSize);
				}
			}
		}
	}
	private int resetDir(int dir) {
		return (dir != 0 || isColliding) ? 0 : dir;
	}
}
