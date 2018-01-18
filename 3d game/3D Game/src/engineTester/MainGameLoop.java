package engineTester;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import models.RawModel;
import models.TexturedModel;
import objConverter.ModelData;
import objConverter.OBJFileLoader;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import settings.MasterSettingsLocationList;
import terrains.Terrain;
import terrains.World;
import textures.ModelTexture;
import textures.TerrainTexture;
import textures.TerrainTexturePack;
import entities.EntityLiving;
import entities.EntityLivingSheep;
import entities.Light;
import entities.StaticFirst1st;
import entities.components.BounceComponent;
import entities.components.RandomLookComponent;
import guis.GuiRenderer;
import guis.GuiTexture;

public class MainGameLoop {
	
	private static long lastFrameTimePhy;
	private static float deltaThreadPhy;
	
	private static float threadMainFps = 0;
	private static float threadPhyFps = 0;
	
	public static void main(String[] args) {

		DisplayManager.createDisplay();
		
		/**
		 * Load the main objects that are needed for the game to run.
		 */
		MasterSettingsLocationList.loadSettings();
		Loader loader = new Loader();
		MasterRenderer renderer = new MasterRenderer(loader);
		GuiRenderer guiRenderer = new GuiRenderer(loader);
		StaticFirst1st camera = new StaticFirst1st();
		
		/**
		 * Its time to load the terrain textures into memory.
		 * This should be done for each terrain as having
		 * the same terrain repeating is not fun.
		 */
		TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grassy"));
		TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("dirt"));
		TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("pinkFlowers"));
		TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("path"));
		TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
		TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendMap"));
		
		/**
		 * Time to setup the terrain.
		 */
		Terrain terrain = new Terrain(0,-1,loader, texturePack, blendMap, "heightmaps/SmallSarnia");
		World world = new World(terrain);
		float su = 1.1f;
		float po = 1.0f;
		Light theSun = new Light(new Vector3f(0,1000,-2000),new Vector3f(su,su,su));
		Light pointLight = new Light(new Vector3f(20,20,-20),new Vector3f(po,po,po), new Vector3f(1,0.01f,0.002f));
		//Light theSun2 = new Light(new Vector3f(-20000,20000,-2000),new Vector3f(0,0,1));
		List<Light> lights = new ArrayList<Light>();
		lights.add(theSun);
		lights.add(pointLight);
		//lights.add(theSun2);
		/**
		 * Add the GUIs to the GUI list for rendering.
		 * Passing by value might not be the best
		 * idea but, why make a variable you will only use once?
		 * Its better and saves space.
		 */
		List<GuiTexture> guis = new ArrayList<GuiTexture>();
		
		guis.add(new GuiTexture(loader.loadTexture("topbar"), new Vector2f(0.1f,0.15f), new Vector2f(2.5f, 0.85f), new Vector2f(0, 0)));
		
		/**
		 * Models and other's time to be rendered
		 * this includes the trees because they are not
		 * built into the terrain mesh.
		 */
		RawModel treeModel = OBJLoader.loadObjModel("tree", loader); 
		
		TexturedModel staticModel = new TexturedModel(treeModel,new ModelTexture(loader.loadTexture("tree")));
		
		ModelData data = OBJFileLoader.loadOBJ("bettersheep");
		RawModel sheep = loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());
		
		TexturedModel sheepModel = new TexturedModel(sheep,new ModelTexture(loader.loadTexture("white")));
		
		Random random = new Random();
		for(int i=0;i<500;i++){
			float posX = random.nextFloat()*800;
			float posZ = random.nextFloat() * -600;
			EntityLiving worldTree = new EntityLiving(staticModel, new Vector3f(posX,terrain.getHeightOfTerrain(posX, posZ),posZ),0,0,0,3, new Vector3f(random.nextFloat(),random.nextFloat(),random.nextFloat()), false);
			//worldTree.addComponent(new BounceComponent(1.35f, 70, 100.0f));
			world.addEntityLivingToWorld(worldTree);
			
		}
		EntityLiving testEntity = new EntityLivingSheep(sheepModel, new Vector3f(0, 1, 0),0,0,0,3, new Vector3f(1f,1,1), true, world, new BounceComponent(1.35f, 70, 100.0f));
		testEntity.addComponent(new BounceComponent(1.35f, 70, 25.0f));
		//testEntity.addComponent(new BreedingComponent(world, 20));
		testEntity.addComponent(new RandomLookComponent(25, 25));
		world.addEntityLivingToWorld(testEntity);
		
		EntityLiving testEntity1 = new EntityLivingSheep(sheepModel, new Vector3f(250, 20, -250),0,0,0,3, new Vector3f(1f,0,0), true, world, new BounceComponent(1.35f, 70, 100.0f));
		testEntity1.addComponent(new BounceComponent(1.35f, 70, 25.0f));
		//testEntity1.addComponent(new BreedingComponent(world, 20));
		testEntity1.addComponent(new RandomLookComponent(25, 25));
		world.addEntityLivingToWorld(testEntity1);
		
		/**
		 *  Now its time to setup all the threads.
		 *  TODO: add threadpool.
		 */
		
		if (MasterSettingsLocationList.useMultithreading) {
			new Thread(new Runnable() { 
				public void run() {
					while (!Display.isCloseRequested()) {
						try {
						
							for (int i = 0; i < world.getEntityLivingList().size(); i++) {
								EntityLiving entity = world.getEntityLivingList().get(i);
								entity.update(terrain);
							}
							
							long currentFrameTime = getCurrentTime();
							deltaThreadPhy = (currentFrameTime - lastFrameTimePhy)/1000f;
							if (deltaThreadPhy > 0.032) { deltaThreadPhy = 0.016f; }
							lastFrameTimePhy = currentFrameTime;
							threadPhyFps = 1 / getDeltaPhy();
							float time = 1000 / MasterSettingsLocationList.PhysicsFps; time = time / 1000;
							float sleepTime = time - getDeltaPhy();
							long totalSleepTime = (long)Math.abs((sleepTime * 1000));
							if (totalSleepTime > (1000 / MasterSettingsLocationList.PhysicsFps)) totalSleepTime = (1000 / MasterSettingsLocationList.PhysicsFps);
							//System.out.println("Physics: " + deltaThreadPhy + " ; Render: " + DisplayManager.getDelta());
							
							if (threadMainFps < threadPhyFps) {
								try {
									Thread.sleep(totalSleepTime);
								} catch (InterruptedException e) {
									e.printStackTrace();
									System.out.println("ERROR HERE");
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
				}
			}).start();
		}
		while(!Display.isCloseRequested()){
			camera.move(terrain);
			renderer.processTerrain(terrain);
			try {
				for(EntityLiving entity:world.getEntityLivingList()){
					entity.setAllowUpdate(false);
					renderer.processEntity(entity);
					entity.setAllowUpdate(true);
				}
			} catch (ConcurrentModificationException e) {
				
			}
			renderer.render(lights, camera);
			guiRenderer.render(guis);
			DisplayManager.updateDisplay();
			
		}

		guiRenderer.cleanUp();
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
		threadMainFps = 1 / DisplayManager.getDelta();
	}
	
	public static float getDeltaPhy() {
		return deltaThreadPhy;
	}
	
	private static long getCurrentTime() {
		return Sys.getTime()*1000/Sys.getTimerResolution();
	}

}
