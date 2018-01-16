package Shaders;

import org.lwjgl.util.vector.Matrix4f;

import Entities.Camera;
import Entities.Light;
import Toolbox.Maths;

public class TerrainShader extends ShaderProgram {
	
	private static final String vertexFile = "/Shaders/terrainVertexShader.txt";
	private static final String fragmentFile = "/Shaders/terrainFragmentShader.txt";
	
	int location_transformationMaxtrix;
	int location_projectionMatrix;
	int location_viewMatrix;
	int location_lightPostion;
	int location_lightColor;
	
	public TerrainShader() {
		super(vertexFile, fragmentFile);
	}

	@Override
	protected void bindAttributes() {		
		super.bindAttribute("position", 0);
		super.bindAttribute("textureCoords", 1);
		super.bindAttribute("normal", 2);
		location_lightPostion = super.getUniformLocation("lightPosition");
		location_lightColor = super.getUniformLocation("lightColor");
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
	
	public void loadLight(Light light) {
		super.load3DVector(location_lightPostion, light.getPosition());
		super.load3DVector(location_lightColor, light.getColor());
	}
	
	public void loadProjectionMatrix(Matrix4f matx) {
		super.loadMaxtrix(location_projectionMatrix, matx);
	}
	
	public void loadViewMatrix(Camera cam) {
		super.loadMaxtrix(location_viewMatrix, Maths.createViewMatrix(cam));
	}
	
}
