package RenderEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entities.Block;
import Entities.Camera;
import Entities.Entity;
import Models.TexturedModel;
import Shaders.StaticShader;

public class renderer {
	
	private StaticShader shader = new StaticShader();
	private MasterRenderer renderer = new MasterRenderer(shader);
	
	private Map<TexturedModel, List<Entity>> entities = new HashMap<TexturedModel, List<Entity>>();
	
	public void render(Camera camera) {
		renderer.prepare();
		shader.start();
		shader.loadViewMatrix(camera);
		renderer.render(entities);
		shader.stop();
		entities.clear();
	}
	
	public void processEntity(Entity entity) {
		TexturedModel entityModel = entity.getModel();
		List<Entity> batch = entities.get(entityModel);
		if (batch != null) {
			batch.add(entity);
		} else {
			List<Entity> newBatch = new ArrayList<Entity>();
			newBatch.add(entity);
			entities.put(entityModel, newBatch);
		}
	}
	
	public void processEntity(Block entity) {
		TexturedModel entityModel = entity.getEntity().getModel();
		List<Entity> batch = entities.get(entityModel);
		if (batch != null) {
			batch.add(entity.getEntity());
		} else {
			List<Entity> newBatch = new ArrayList<Entity>();
			newBatch.add(entity.getEntity());
			entities.put(entityModel, newBatch);
		}
	}
	
	public void cleanUp() {
		shader.cleanUp();
	}
	
}
