package data.objects.map;


import org.lwjgl.util.vector.Vector2f;

import data.helpers.LoganHelper;
import data.helpers.Maths;
import data.main.Boot;
import data.objects.blocks.Block;
import data.objects.blocks.BlockAir;
import data.objects.blocks.BlockDirt;
import data.objects.blocks.BlockGrass;
import data.objects.blocks.BlockIronOre;
import data.objects.blocks.BlockStone;
import data.objects.player.Player;
import data.textures.Artist;

public class Map {
	
	private static Block[][] map = new Block[Boot.WIDTH/Artist.BlockSize][Boot.HEIGHT/Artist.BlockSize];
	
	public Map() {
		/*for (int i =0;i<Boot.WIDTH/Artist.BlockSize;i++){
			for (int j=0;j<Boot.HEIGHT/Artist.BlockSize;j++) {
				setBlock(i,j,new Block(new TextureData(GameRegistry.nullTexture, "null"), new Vector2f(Artist.BlockSize*i,Artist.BlockSize*j)));
				//setBlock(i,j+2,new Block(new TextureData(GameRegistry.dirtTexture, "dirt"), new Vector2f(Artist.BlockSize*i,Artist.BlockSize*j+2), new BoundingBox(Artist.BlockSize*i,Artist.BlockSize*j+1, Artist.BlockSize,Artist.BlockSize)));
			}
		}*/
		
	}
	public static boolean setBlock(float x, float y, Block type){
		try {
			map[(int) x][(int) y] = type;
		} catch (Exception e) {return false;}
		return true;
	}
	public static Block getBlock(float x, float y) {
		try {
			return map[(int) x][(int) y];
		} catch(Exception e) {
			//System.err.println("HEY BUDDY! YOU FORGOT THE MAP DIMSENSONS!");
			return new BlockAir(new Vector2f(x* Artist.BlockSize, y * Artist.BlockSize));
		}
	}
	public static Block getBlockM(float x, float y) {
		try {
			return map[(int) x/Artist.BlockSize][(int) y/Artist.BlockSize];
		} catch(Exception e) {
			//System.err.println("HEY BUDDY! YOU FORGOT THE MAP DIMSENSONS!");
			return new BlockAir(new Vector2f(x* Artist.BlockSize, y * Artist.BlockSize));
		}
	}
	public static void startGen() {
		int xStartG = 0;
		int yStartG = 5;
		for (int i =0+xStartG;i<Boot.WIDTH/Artist.BlockSize+xStartG;i++){
			for (int j=0;j<6;j++) {
				setBlock(i,j,new BlockAir(new Vector2f(Artist.BlockSize*i, Artist.BlockSize*j)));
				//setBlock(i,j+2,new Block(new TextureData(GameRegistry.dirtTexture, "dirt"), new Vector2f(Artist.BlockSize*i,Artist.BlockSize*j+2), new BoundingBox(Artist.BlockSize*i,Artist.BlockSize*j+1, Artist.BlockSize,Artist.BlockSize)));
			}
			for (int j=yStartG;j<1+yStartG;j++) {
				setBlock(i,j,new BlockGrass(new Vector2f(Artist.BlockSize*i, Artist.BlockSize*j)));
				//setBlock(i,j+2,new Block(new TextureData(GameRegistry.dirtTexture, "dirt"), new Vector2f(Artist.BlockSize*i,Artist.BlockSize*j+2), new BoundingBox(Artist.BlockSize*i,Artist.BlockSize*j+1, Artist.BlockSize,Artist.BlockSize)));
			}
			for (int j=yStartG+1;j<1+yStartG+4;j++) {
				setBlock(i,j,new BlockDirt(new Vector2f(Artist.BlockSize*i, Artist.BlockSize*j)));
			}
			for (int j=yStartG+4;j<1+yStartG+31;j++) {
				setBlock(i,j,new BlockStone(new Vector2f(Artist.BlockSize*i, Artist.BlockSize*j)));
			}
		}
		for (int i =0+xStartG;i<Boot.WIDTH/Artist.BlockSize+xStartG;i++){
			for (int j=yStartG+4;j<1+yStartG+31;j++) {
				if (Maths.randInt(0, 20) == 2) {
					setBlock(i,j,new BlockIronOre(new Vector2f(i*Artist.BlockSize,j*Artist.BlockSize)));
				}
			}
		}
	}
	
	public static void updateCollision(Player player) {
		for (int i=0; i < map.length; i++) {
			for (int j=0; j < map[i].length; j++) {
				if (map[i][j] != null) {
					try {
						map[i][j].updatePosition();
						player.updateCollision(map[i][j].box);
						if (player.recheckCollision == 1) {
							player.recheckCollision = 0;
							player.canMoveIn[1] = true;
						}
					}catch(Exception e){
						System.out.println("WE HAVE A NULL!");
					}
				}
			}
		}
	}
	
	public static void updateBlocks() {
		for (int i=0; i < map.length; i++) {
			for (int j=0; j < map[i].length; j++) {
				if (map[i][j] != null){
					map[i][j].update();
				}
			}
		}
	}
	
	public static void Draw(){
		for (int i=0; i < map.length; i++) {
			for (int j=0; j < map[i].length; j++) {
				if (map[i][j] != null) {
					LoganHelper.drawBlock(map[i][j]);
				}
			}
		}
	}
	
	public static Block[][] getMap() {
		return map;
	}

}
