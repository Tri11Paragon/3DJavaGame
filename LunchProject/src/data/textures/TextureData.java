package data.textures;

import org.newdawn.slick.opengl.Texture;

public class TextureData {
	
	private Texture texture;
	private String name;
	public TextureData(Texture texture, String name) {
		super();
		this.texture = texture;
		this.name = name;
	}
	public Texture getTexture() {
		return texture;
	}
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
