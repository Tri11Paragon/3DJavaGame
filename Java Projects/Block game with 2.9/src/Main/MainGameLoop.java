package Main;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Entities.Blocks;
import Entities.Camera;
import Main.World.World;
import RenderEngine.DisplayManager;
import RenderEngine.Loader;
import RenderEngine.renderer;
import Shaders.StaticShader;
import Toolbox.Clock;
import Toolbox.Debug;
import Toolbox.Maths;

public class MainGameLoop {
	
	public static Loader loader1 = null;
	public static StaticShader shader1 = null;
	
	
	static Vector3f camPos = new Vector3f(0,0,0);
	
	
	
	
	static float fps;
	
	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		loader1 = loader;
		StaticShader shader = new StaticShader();
		shader1 = shader;
		
		Clock clock = new Clock();
		
		Camera cam = new Camera(new Vector3f(0,16,0), 0, 0, 0);
		
		fps=1;
		Blocks.setup(loader);
		
		World world = new World(cam);
		world.start();
		
		renderer render = new renderer();
		while (!Display.isCloseRequested()) {
			cam.move();
			camPos = cam.getPosition();
			clock.update();
			
			//Debug.Log(world.getBlockAtPos(0, 0, 0).getUnlocalizedname());
			
			fps = 1 / clock.Delta();
			//Debug.Log("FPS: " + fps, "MainGameLoop");
			try {
				for (int i = 0; i < world.getBlocks().size(); i++) {
					if (Maths.indexExists(world.getBlocks(), i)) {
						if (world.getBlocks().get(i).getShouldRender() == true) {
							render.processEntity(world.getBlocks().get(i));
						}
					}
				}
			} catch (IndexOutOfBoundsException e) {
				//e.printStackTrace();
			}
			render.render(cam);
			
			DisplayManager.updateDisplay();
			
		}
		//loader.cleanUp();
		render.cleanUp();
		DisplayManager.closeDisplay();

	}

}
