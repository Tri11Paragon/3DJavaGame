package com.main;

import org.lwjgl.opengl.Display;

import com.main.rendering.Renderer;
import com.main.shaders.StaticShader;
import com.main.tools.Artist;


public class Main {

	public static void main(String[] args) {
		DisplayManager.createDisplay();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		renderer.prepare();
		Artist artist = new Artist();
		
		while (!Display.isCloseRequested()) {
			
			artist.renderBlock(0, 0, 0, 0);
			
			DisplayManager.updateDisplay();
			
		}
		
		DisplayManager.closeDisplay();
		
	}
}
