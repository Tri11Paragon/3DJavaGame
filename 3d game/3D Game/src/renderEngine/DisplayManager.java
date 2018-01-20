package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.PixelFormat;

import guis.GuiRenderer;
import loaders.SettingsLoader;
import loaders.WorldLoader;
import terrains.World;

public class DisplayManager {
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 120;
	private static final String name = "V0.0.03";
	
	private static long lastFrameTime;
	private static float delta;
	
	public static void createDisplay(){		
		ContextAttribs attribs = new ContextAttribs(3,2)
		.withForwardCompatible(true)
		.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat().withSamples(SettingsLoader.MSAA).withDepthBits(SettingsLoader.DEPTHBUFFERBITS), attribs);
			Display.setTitle(name);
			if (SettingsLoader.ENABLEAA)
				GL11.glEnable(GL13.GL_MULTISAMPLE);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		GL11.glViewport(0,0, WIDTH, HEIGHT);
		Mouse.setGrabbed(true);
		lastFrameTime = getCurrentTime();
	}
	
	public static void updateDisplay(GuiRenderer render, MasterRenderer renderer, Loader loader, World world){
		
		Display.sync(FPS_CAP);
		Display.update();
		long currentFrameTime = getCurrentTime();
		delta = (currentFrameTime - lastFrameTime)/1000f;
		lastFrameTime = currentFrameTime;
		try {
		while(Keyboard.next()) {
			if(Keyboard.getEventKeyState()) {
				
				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
					closeDisplay(render, renderer, loader, world);
				}
				
				if(Keyboard.isKeyDown(Keyboard.KEY_E) && Mouse.isGrabbed()) {
					Mouse.setGrabbed(false);
				} else if(Keyboard.isKeyDown(Keyboard.KEY_E) && !Mouse.isGrabbed()) {
					Mouse.setGrabbed(true);
				}
				
			}
		}
		} catch (Exception e) {}
		
	}
	
	public static float getDelta() {
		return delta;
	}
	
	public static void closeDisplay(GuiRenderer render, MasterRenderer renderer, Loader loader, World world){
		
		WorldLoader.saveEntities("worlds/base.WORLDSAVE", world);
		render.cleanUp();
		renderer.cleanUp();
		loader.cleanUp();
		Display.destroy();
		System.exit(0);
		
	}
	
	private static long getCurrentTime() {
		return Sys.getTime()*1000/Sys.getTimerResolution();
	}

}
