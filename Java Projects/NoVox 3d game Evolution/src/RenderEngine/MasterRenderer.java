package RenderEngine;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import Shaders.ColorShader;
import Shaders.StaticShader;
import Shaders.TerrainShader;
import Terrain.Terrain;

public class MasterRenderer {
	
	Matrix4f projectionMatrix;
	
	private static final float FOV = 70f;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 10000;
	
	private TerrainRenderer terrainRenderer;
	
	private List<Terrain> terrains = new ArrayList<Terrain>();
	
	public MasterRenderer(Light sun, StaticShader shader, ColorShader shaderC, TerrainShader terrainShader) {
		prepare();
		createProjectionMatrix();
		shader.start();
		shaderC.start();
		terrainShader.start();
		terrainShader.loadLight(sun);
		shader.loadLight(sun);
		shaderC.loadLight(sun);
		shader.loadProjectionMatrix(projectionMatrix);
		shaderC.loadProjectionMatrix(projectionMatrix);
		terrainShader.loadProjectionMatrix(projectionMatrix);
		shaderC.stop();
		shader.stop();
		terrainShader.stop();
		terrainRenderer = new TerrainRenderer(terrainShader, projectionMatrix);
	}
	
	public void prepare() {
		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClearColor(0.4f, 0.7f, 1.0f, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
	}
	
	public void load() {
		terrainRenderer.render(terrains);
		terrains.clear();
	}
	
	public void processTerrain(Terrain terrain) {
		terrains.add(terrain);
	}
	
	public void render(Entity Entity, StaticShader shader) {
		EntityRenderer.render(Entity, shader);
	}
	
	public void renderColor(Entity Entity, ColorShader shader, Vector3f color) {
		EntityRenderer.renderColor(Entity, shader, color);
	}
	
	public void createProjectionMatrix() {
		
		projectionMatrix = new Matrix4f();
		
		float aspect = (float) Display.getWidth() / (float) Display.getHeight();
		float yScale = (float) (1f / Math.tan(Math.toRadians(FOV / 2f)));
		float xScale = yScale / aspect;
		float zp = FAR_PLANE + NEAR_PLANE;
		float zm = FAR_PLANE - NEAR_PLANE;
		
		projectionMatrix.m00 = xScale;
		projectionMatrix.m11 = yScale;
		projectionMatrix.m22 = -zp/zm;
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -(2*FAR_PLANE*NEAR_PLANE)/zm;
		projectionMatrix.m33 = 0;
		
	}

}
