package RenderEngine;

import java.awt.Toolkit;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 150;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 200;
	private static final int FPS_CAP = 120;
	private static final String name = "BrettCraft";
	
	public static void createDisplay() {
		
		ContextAttribs attribs = new ContextAttribs(3,2)
				.withForwardCompatible(true)
				.withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle(name);
			Display.setFullscreen(true);
			GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		Mouse.setGrabbed(true);
		
	}
	
	public static void updateDisplay() {
		
		Display.sync(FPS_CAP);
		Display.update();
		
		while(Keyboard.next()) {
			if(Keyboard.getEventKeyState()) {
				
				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
					closeDisplay();
				}
				
				if(Keyboard.isKeyDown(Keyboard.KEY_E) && Mouse.isGrabbed()) {
					Mouse.setGrabbed(false);
				} else if(Keyboard.isKeyDown(Keyboard.KEY_E) && !Mouse.isGrabbed()) {
					Mouse.setGrabbed(true);
				}
				
			}
		}
		
	}
	
	public static void closeDisplay() {
		
		
		
		Display.destroy();
		System.exit(0);
		
	}

}
