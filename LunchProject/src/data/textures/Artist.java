package data.textures;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.ImageIOImageData;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;


public class Artist {
	
	public static int BlockSize = 16;
	public static Font font24;
	public static org.newdawn.slick.TrueTypeFont f24;
	public static Font font18;
	public static org.newdawn.slick.TrueTypeFont f18;
	public static Font font16;
	public static org.newdawn.slick.TrueTypeFont f16;
	public static Font font14;
	public static org.newdawn.slick.TrueTypeFont f14;
	public static Font font10;
	public static org.newdawn.slick.TrueTypeFont f10;
	public static String version = "V0.0.254 Alpha - Inventory Update";
	
	public static void BeginSession(int WIDTH, int HEIGHT){
		Display.setTitle(version);
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create();
			AL.create();
			try {
				Display.setIcon(new ByteBuffer[] {
				        new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("res/game/icon.png")), false, false, null),
				        new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("res/game/icon1.png")), false, false, null)
				        });
			} catch (IOException e) {
				e.printStackTrace();
			}
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
		font14 = new Font("Arial", Font.PLAIN,(int) 14);
		f14 = new org.newdawn.slick.TrueTypeFont(font14, true);
		font24 = new Font("Arial", Font.PLAIN,(int) 24);
		f24 = new org.newdawn.slick.TrueTypeFont(font24, true);
		font10 = new Font("Arial", Font.PLAIN,(int) 10);
		f10 = new org.newdawn.slick.TrueTypeFont(font10, true);
	}
	
	public static void drawText(String text, float x, float y, Color color, int size) {
		/**
		 * More efficient then just re-init the font every time.
		 */
		switch(size) {
		case 14:
			f14.drawString(x, y, text, color);
			break;
		case 24:
			f24.drawString(x, y, text, color);
			break;
		case 10:
			f10.drawString(x, y, text, color);
			break;
		default:
			f14.drawString(x, y, text, color);
			break;
		}
		Color.white.bind();
	}
	
	public static void drawText(String text, float x, float y, int size) {
		/**
		 * More efficient then just re-init the font every time.
		 */
		switch(size) {
		case 14:
			f14.drawString(x, y, text);
			break;
		case 24:
			f24.drawString(x, y, text);
			break;
		case 10:
			f10.drawString(x, y, text);
			break;
		case 16:
			f16.drawString(x, y, text);
			break;
		case 18:
			f18.drawString(x, y, text);
			break;
		default:
			f14.drawString(x, y, text);
			break;
		}
	}
	public static void drawQuad(float x, float y, float width, float height){
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x, y + height);
		glEnd();
	}
	public static void drawLine(float x, float y, float x2, float y2) {
		GL11.glColor3f(0.0f, 1.0f, 1.0f);
	    GL11.glBegin(GL11.GL_LINE);
	    GL11.glLineWidth(5.0f);
	    GL11.glVertex2d(x, y);
	    GL11.glVertex2d(x2, y2);
	    GL11.glEnd();
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
	public static void drawQuadTexture(Texture texture, float x, float y, float width, float height, float angle){
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
	
	public static void drawQuadTextureRaw(Texture texture, float x, float y, float width, float height){
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