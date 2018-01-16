package RenderEngine;

import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import Shaders.TerrainShader;
import Terrain.Terrain;
import Toolbox.Maths;

public class TerrainRenderer {
	
	private TerrainShader shader;
	
	public TerrainRenderer(TerrainShader shader, Matrix4f projectionMatrix) {
		this.shader = shader;
	}
	
	public void render(List<Terrain> terrains) {
		for (Terrain terrain:terrains) {
			prepareTerrain(terrain);
			loadModel(terrain);
			GL11.glDrawElements(GL11.GL_TRIANGLES, terrain.getModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
			unbind();
		}
	}
	
	private void prepareTerrain(Terrain terrain) {
		GL30.glBindVertexArray(terrain.getModel().getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		GL20.glEnableVertexAttribArray(2);
		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, terrain.getTexture().getTextureID());
	}
	
	private void unbind() {
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(2);
		GL30.glBindVertexArray(0);
	}
	
	private void loadModel(Terrain entity) {
		Matrix4f transformMatrix = Maths.createTransformationMatrix(new Vector3f(entity.getX(), 0, entity.getZ()), 0, 0, 0, 1);
		shader.loadTransformationMaxtrix(transformMatrix);
	}
	
}
