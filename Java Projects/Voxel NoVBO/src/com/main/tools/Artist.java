package com.main.tools;

import static org.lwjgl.opengl.GL11.*;

public class Artist {
	
	/*public void renderBlock(int posx, int posy, int posz, float angle) {
		  try{
		    //t.bind();
		    GL11.glEnable(GL11.GL_CULL_FACE);
		    GL11.glCullFace(GL11.GL_BACK);// or even GL_FRONT_AND_BACK);

		    GL11.glPushMatrix();

		    GL11.glTranslatef((2*posx+0.5f),(2*posy+0.5f),(2*posz+0.5f));             // Move Right 1.5 Units And Into The Screen 6.0
		    GL11.glRotatef(angle,1.0f,1.0f,1.0f);

		    GL11.glBegin(GL11.GL_QUADS);               // Draw A Quad

		    GL11.glColor3f(0.5f, 0.4f, 0.4f);             // Set The Color To Green
		    GL11.glTexCoord2f(0,0);
		    GL11.glVertex3f( 1f, 1f,-1f);         // Top Right Of The Quad (Top)
		    GL11.glTexCoord2f(1,0);
		    GL11.glVertex3f(-1f, 1f,-1f);         // Top Left Of The Quad (Top)
		    GL11.glTexCoord2f(1,1);
		    GL11.glVertex3f(-1f, 1f, 1f);         // Bottom Left Of The Quad (Top)
		    GL11.glTexCoord2f(0,1);
		    GL11.glVertex3f( 1f, 1f, 1f);         // Bottom Right Of The Quad (Top)

		    //GL11.glColor3f(1.2f,0.5f,0.9f);             // Set The Color To Orange
		    GL11.glTexCoord2f(0,0);
		    GL11.glVertex3f( 1f,-1f, 1f);         // Top Right Of The Quad (Bottom)
		    GL11.glTexCoord2f(0,1);
		    GL11.glVertex3f(-1f,-1f, 1f);         // Top Left Of The Quad (Bottom)
		    GL11.glTexCoord2f(1,1);
		    GL11.glVertex3f(-1f,-1f,-1f);         // Bottom Left Of The Quad (Bottom)
		    GL11.glTexCoord2f(1,0);
		    GL11.glVertex3f( 1f,-1f,-1f);         // Bottom Right Of The Quad (Bottom)

		    //GL11.glColor3f(1.0f,0.0f,0.0f);             // Set The Color To Red
		    GL11.glTexCoord2f(0,0);
		    GL11.glVertex3f( 1f, 1f, 1f);         // Top Right Of The Quad (Front)
		    GL11.glTexCoord2f(1,0);
		    GL11.glVertex3f(-1f, 1f, 1f);         // Top Left Of The Quad (Front)
		    GL11.glTexCoord2f(1,1);
		    GL11.glVertex3f(-1f,-1f, 1f);         // Bottom Left Of The Quad (Front)
		    GL11.glTexCoord2f(0,1);
		    GL11.glVertex3f( 1f,-1f, 1f);         // Bottom Right Of The Quad (Front)

		    //GL11.glColor3f(1f,0.5f,0.0f);             // Set The Color To Yellow
		    GL11.glTexCoord2f(0,0);
		    GL11.glVertex3f( 1f,-1f,-1f);         // Bottom Left Of The Quad (Back)
		    GL11.glTexCoord2f(1,0);
		    GL11.glVertex3f(-1f,-1f,-1f);         // Bottom Right Of The Quad (Back)
		    GL11.glTexCoord2f(1,1);
		    GL11.glVertex3f(-1f, 1f,-1f);         // Top Right Of The Quad (Back)
		    GL11.glTexCoord2f(0,1);
		    GL11.glVertex3f( 1f, 1f,-1f);         // Top Left Of The Quad (Back)

		    //GL11.glColor3f(0.0f,0.0f,0.3f);             // Set The Color To Blue
		    GL11.glTexCoord2f(0,1);
		    GL11.glVertex3f(-1f, 1f, 1f);         // Top Right Of The Quad (Left)
		    GL11.glTexCoord2f(1,1);
		    GL11.glVertex3f(-1f, 1f,-1f);         // Top Left Of The Quad (Left)
		    GL11.glTexCoord2f(1,0);
		    GL11.glVertex3f(-1f,-1f,-1f);         // Bottom Left Of The Quad (Left)
		    GL11.glTexCoord2f(0,0);
		    GL11.glVertex3f(-1f,-1f, 1f);         // Bottom Right Of The Quad (Left)

		    //GL11.glColor3f(0.5f,0.0f,0.5f);             // Set The Color To Violet
		    GL11.glTexCoord2f(0,0);
		    GL11.glVertex3f( 1f, 1f,-1f);         // Top Right Of The Quad (Right)
		    GL11.glTexCoord2f(1,0);
		    GL11.glVertex3f( 1f, 1f, 1f);         // Top Left Of The Quad (Right)
		    GL11.glTexCoord2f(1,1);
		    GL11.glVertex3f( 1f,-1f, 1f);         // Bottom Left Of The Quad (Right)
		    GL11.glTexCoord2f(0,1);
		    GL11.glVertex3f( 1f,-1f,-1f);         // Bottom Right Of The Quad (Right)

		    //rquad+=0.0001f;
		    GL11.glEnd();
		    GL11.glPopMatrix();
		  }catch(NullPointerException t){t.printStackTrace(); System.out.println("rendering block failed");}
		}*/
	public void renderBlock(float x, float y, float width, float height) {
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
	
}
