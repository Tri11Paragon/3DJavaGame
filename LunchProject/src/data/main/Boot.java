package data.main;

import data.helpers.Clock;
import data.inventory.PlayerInventory;
import data.objects.blocks.Blocks;
import data.objects.map.Map;
import data.objects.player.Player;
import data.sound.SoundManager;
import data.textures.Artist;
import data.textures.TextureData;

import org.lwjgl.Sys;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("unused")
public class Boot {
	
	public static int WIDTH = 800, HEIGHT = 600;
	
	private static long lastFrameTimePhy;
	private static float deltaThreadPhy;
	
	private static float threadPhyFps = 0;
	
	public static void main(String[] args) {
		Game.startup();
		Clock.startTime = Sys.getTime();
		Artist.BeginSession(WIDTH, HEIGHT);
		GameRegistry.setupTextures();
		Blocks.setup();
		Map.startGen();
		thread();
		
		PlayerInventory inv = new PlayerInventory(5,5);
		Player player = new Player(new TextureData(GameRegistry.playerTexture, "player"), 0,0, inv);
		//inv.setOpen(true);
		
		while(!Display.isCloseRequested()){
			Clock.update();
			required();
			Map.Draw();
			Map.updateBlocks();
			inv.updateSlots();
			
			brett(player);
			logan();
			
			Display.update();
			Display.sync(60);
		}
		AL.destroy();
		Display.destroy();
	}
	
	public static void brett(Player player) {
		player.draw();
		
		player.update();
		Map.updateCollision(player);
	}
	
	public static void thread() {
		new Thread(new Runnable() { 
			public void run() {
				while (!Display.isCloseRequested()) {
					try {
						long currentFrameTime = getCurrentTime();
						deltaThreadPhy = (currentFrameTime - lastFrameTimePhy)/1000f;
						if (deltaThreadPhy > 0.032) { deltaThreadPhy = 0.016f; }
						lastFrameTimePhy = currentFrameTime;
						threadPhyFps = 1 / getDeltaPhy();
						float time = 1000 / 60; time = time / 1000;
						float sleepTime = time - getDeltaPhy();
						long totalSleepTime = (long)Math.abs((sleepTime * 1000));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}).start();
	}
	
	public static void logan() {
		
	}
	
	public static void required() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(0, 0, 0, 1);
	}
	
	public static float getDeltaPhy() {
		return deltaThreadPhy;
	}
	
	private static long getCurrentTime() {
		return Sys.getTime()*1000/Sys.getTimerResolution();
	}

}
