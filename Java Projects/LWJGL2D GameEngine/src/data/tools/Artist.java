package data.tools;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Artist {
	
	public static final int TILE_SIZE = 16;
	public static int WIDTH = 1280, HEIGHT = 960;
	
	public static void BeginSession(){
		Display.setTitle("V0.0.1 - Beta");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
			Display.sync(60);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	public static void MoveCamara(int x, int y, int toX, int toY){
		GLU.gluLookAt(x+toX, y+toY, 0, x+toX, y+toY, 0.0f, 0f, 1f, 0f);
	}
	public static boolean CheckCollision(float x1, float y1, float width1, float height1, float x2, float y2, float width2, float height2){
		if(x1 + width1 > x2 && x1 < x2 + width2 && y1 + height1 > y2 && y1 < y2 + height2){
			return true;
		}
		return false;
	}
	
	public static void drawQuad(float x, float y, float width, float height){
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x, y + height);
		glEnd();
	}
	public static void drawQuadTexture(Texture texture, float x, float y, float width, float height){
		texture.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		
		glEnd();
		glLoadIdentity();
	}
	public static void drawQuadTextureRot(Texture texture, float x, float y, float width, float height, float angle){
		texture.bind();
		glTranslatef(x + width / 2, y + height / 2, 0);
		glRotatef(angle, 0, 0, 1);
		glTranslatef(- width / 2, - height / 2, 0);
		
		glBegin(GL_QUADS);
		
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		
		glEnd();
		glLoadIdentity();
	}
	
	public static Texture loadTexture(String path, String FileType){
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try {tex= TextureLoader.getTexture(FileType, in);} catch (IOException e) {e.printStackTrace();}
		return tex;
	}
	
	public static Texture quickLoad(String name){
		Texture tex=null;
		tex = loadTexture("res/" + name + ".png", "PNG");
		return tex;
	}
	
}
