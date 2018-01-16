package Entities;

import java.util.ArrayList;
import java.util.List;

import Models.RawModel;
import Models.TexturedModel;
import RenderEngine.Loader;
import Textures.ModelTexture;

public class Blocks {
	
	static Loader loader;
	
	// TODO: Replace with model loader.
	static float[] vertices = {-0.5f,0.5f,-0.5f,-0.5f,-0.5f,-0.5f,0.5f,-0.5f,-0.5f,0.5f,0.5f,-0.5f,-0.5f,0.5f,0.5f,-0.5f,-0.5f,0.5f,0.5f,-0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,0.5f,-0.5f,0.5f,-0.5f,-0.5f,0.5f,-0.5f,0.5f,0.5f,0.5f,0.5f,-0.5f,0.5f,-0.5f,-0.5f,-0.5f,-0.5f,-0.5f,-0.5f,0.5f,-0.5f,0.5f,0.5f,-0.5f,0.5f,0.5f,-0.5f,0.5f,-0.5f,0.5f,0.5f,-0.5f,0.5f,0.5f,0.5f,-0.5f,-0.5f,0.5f,-0.5f,-0.5f,-0.5f,0.5f,-0.5f,-0.5f,0.5f,-0.5f,0.5f};
	static float[] uvs = {0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0};
	static int[] indices = {0,1,3,3,1,2,4,5,7,7,5,6,8,9,11,11,9,10,12,13,15,15,13,14,16,17,19,19,17,18,20,21,23,23,21,22};
	
	public static Block blockAIR;
	public static Block blockDIRT;
	
	public static List<Block> blocksTypesList = new ArrayList<Block>();
	
	public static void setup(Loader l) {
		loader = l;
		blockAIR = new Block(registerBlock("null", l), "AIR");
		blocksTypesList.add(blockAIR);
		
		
		blockDIRT = new Block(registerBlock("dirtTex", l), "DIRT");
		blocksTypesList.add(blockDIRT);
		
	}
	
	public static TexturedModel registerBlock(String texturePath, Loader l) {
		RawModel model = l.loadToVAO(vertices, indices, uvs);
		ModelTexture texture = new ModelTexture(l.loadTexture(texturePath));
		TexturedModel texModel = new TexturedModel(model, texture);
		return texModel;
	}
	
	public static TexturedModel registerBlock(String texturePath) {
		RawModel model = loader.loadToVAO(vertices, indices, uvs);
		ModelTexture texture = new ModelTexture(loader.loadTexture(texturePath));
		TexturedModel texModel = new TexturedModel(model, texture);
		return texModel;
	}
	
}
