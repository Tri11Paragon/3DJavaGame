package Data.RenderingEngine;

import static org.lwjgl.opengl.GL11.*;

public class MasterRenderer {
	
	public void prepare() {
		
		glClearColor(0.4f, 0.7f, 1.0f, 1.0f);
		glClear(GL_COLOR_BUFFER_BIT);
		
	}

}
