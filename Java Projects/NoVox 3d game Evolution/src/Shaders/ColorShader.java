package Shaders;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;
import Entities.Light;
import Toolbox.Maths;

public class ColorShader extends ShaderProgram {
	
	private static final String vertexFile = "/Shaders/vertexColorShader.txt";
	private static final String fragmentFile = "/Shaders/fragmentColorShader.txt";
	
	int location_transformationMaxtrix;
	int location_projectionMatrix;
	int location_viewMatrix;
	int location_ColorVector3f;
	int location_lightPostion;
	int location_lightColor;
	
	public ColorShader() {
		super(vertexFile, fragmentFile);
	}

	@Override
	protected void bindAttributes() {		
		super.bindAttribute("position", 0);
		super.bindAttribute("textureCoords", 1);
		super.bindAttribute("normal", 2);
	}

	@Override
	protected void getAllUniformLocations() {
		
		location_transformationMaxtrix = super.getUniformLocation("transformationMaxtrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		location_ColorVector3f = super.getUniformLocation("color_info");
		location_lightPostion = super.getUniformLocation("lightPosition");
		location_lightColor = super.getUniformLocation("lightColor");
		
	}
	
	public void loadTransformationMaxtrix(Matrix4f matx) {
		super.loadMaxtrix(location_transformationMaxtrix, matx);
	}
	
	public void loadLight(Light light) {
		super.load3DVector(location_lightPostion, light.getPosition());
		super.load3DVector(location_lightColor, light.getColor());
	}
	
	public void loadColorVector3f(Vector3f vec) {
		super.load3DVector(location_ColorVector3f, vec);
	}
	
	public void loadProjectionMatrix(Matrix4f matx) {
		super.loadMaxtrix(location_projectionMatrix, matx);
	}
	
	public void loadViewMatrix(Camera cam) {
		super.loadMaxtrix(location_viewMatrix, Maths.createViewMatrix(cam));
	}
	
}
