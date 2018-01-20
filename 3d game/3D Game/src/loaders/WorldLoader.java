
package loaders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.lwjgl.util.vector.Vector3f;

import entities.EntityLiving;
import entities.components.BounceComponent;
import entities.components.RandomLookComponent;
import models.RawModel;
import models.TexturedModel;
import objConverter.ModelData;
import objConverter.OBJFileLoader;
import renderEngine.Loader;
import terrains.World;
import textures.ModelTexture;

public class WorldLoader {
	
	public static float TIME = -20;
	public static float CURRENTTIME = 0;
	
	public static void loadEntities(String file, World world, Loader loader) {
		FileReader fr = null;
		try {
			fr = new FileReader(new File(file));
			BufferedReader reader = new BufferedReader(fr);
			String line;
			while (true) {
				line = reader.readLine();
				String[] currentLine = line.split(" ");
				if (line.startsWith("# ")) {
					//System.out.println(line);
				} else {
					if (line.startsWith("e ")) {
						ModelData data = OBJFileLoader.loadOBJ(currentLine[2]);
						RawModel rawData = loader.loadToVAO(data.getVertices(), 
								data.getTextureCoords(), data.getNormals(), data.getIndices(), data.getModelName());
						TexturedModel model = new TexturedModel(rawData, new ModelTexture(loader.loadTexture(currentLine[3]), currentLine[3]));
						EntityLiving liv = new EntityLiving(currentLine[1],model, 
								new Vector3f(Float.parseFloat(currentLine[4]), Float.parseFloat(currentLine[5]), Float.parseFloat(currentLine[6])), 
									Float.parseFloat(currentLine[7]), Float.parseFloat(currentLine[8]), Float.parseFloat(currentLine[9]), Float.parseFloat(currentLine[10]), 
									new Vector3f(Float.parseFloat(currentLine[11]), Float.parseFloat(currentLine[12]),  Float.parseFloat(currentLine[13])),
									Boolean.parseBoolean(currentLine[14]), Boolean.parseBoolean(currentLine[15]), Boolean.parseBoolean(currentLine[16]));
						if (currentLine[1].toLowerCase().contains("sheep")) { liv.addComponent(new BounceComponent(1.35f, 70, 25.0f)); liv.addComponent(new RandomLookComponent(25, 25));}
						world.addEntityLivingToWorld(liv);
					}
					if (line.startsWith("t ")) {
						TIME = Float.parseFloat(currentLine[1]);
					}
				}
				if (line.contains("end;")) {
					break;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void saveEntities(String file, World world) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(file));
			BufferedWriter writer = new BufferedWriter(fw);
			
			for (int i = 0; i < world.entityLivingList.size(); i++) {
				EntityLiving living = world.entityLivingList.get(i);
				
				writer.flush();
				writer.write("e " + living.getName() + " " + living.getModel().getRawModel().getModelName() + " " + living.getModel().getTexture().getTextureName() + " " + living.getPosition().x + " " + living.getPosition().y + " " + living.getPosition().z + " " + 
				living.getRotX() + " " + living.getRotY() + " " + living.getRotZ() + " " + living.getScale() + " " + living.getEntityColor().x + " " + living.getEntityColor().y
				+ " " + living.getEntityColor().z + " " + living.isAllowUpdate() + " " + living.getAllowGravity() + " " + living.allowCollision());
				writer.newLine();
				
			}
			writer.write("t " + CURRENTTIME);
			writer.newLine();
			writer.write("end;");
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
