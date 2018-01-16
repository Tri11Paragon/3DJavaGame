package data;

import org.lwjgl.opengl.Display;

import data.tools.Artist;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		Artist.BeginSession();
		
		while(!Display.isCloseRequested()){
			//Clock.update();
			Display.update();
			Display.sync(60);
			
			//grid.Draw();
			Artist.drawQuadTexture(Artist.quickLoad("Sun"), 75 * 16,  10, 32, 32);
			
		}
		
	}

}
