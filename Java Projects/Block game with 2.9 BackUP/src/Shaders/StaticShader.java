package Shaders;

import org.lwjgl.util.vector.Matrix4f;

import Entities.Camera;
import Toolbox.Maths;

public class StaticShader extends ShaderProgram {
	
	private static final String vertexFile = "/Shaders/vertexShader.txt";
	private static final String fragmentFile = "/Shaders/fragmentShader.txt";
	
	int location_transformationMaxtrix;
	int location_projectionMatrix;
	int location_viewMatrix;
	
	public StaticShader() {
		super(vertexFile, fragmentFile);
	}

	@Override
	protected void bindAttributes() {		
		super.bindAttribute("position", 0);
		super.bindAttribute("textureCoords", 1);
	}

	@Override
	protected void getAllUniformLocations() {
		
		location_transformationMaxtrix = super.getUniformLocation("transformationMaxtrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
	}
	
	public void loadTransformationMaxtrix(Matrix4f matx) {
		super.loadMaxtrix(location_transformationMaxtrix, matx);
	}
	
	public void loadProjectionMatrix(Matrix4f matx) {
		super.loadMaxtrix(location_projectionMatrix, matx);
	}
	
	public void loadViewMatrix(Camera cam) {
		super.loadMaxtrix(location_viewMatrix, Maths.createViewMatrix(cam));
	}
}
