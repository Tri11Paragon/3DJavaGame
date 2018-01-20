package models;

public class RawModel {
	
	private int vaoID;
	private int vertexCount;
	private String modelName;
	
	public RawModel(int vaoID, int vertexCount, String modelName){
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
		this.modelName = modelName;
	}

	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	public String getModelName() {
		return modelName;
	}
	
	

}
