package taatudi.rsg;

import java.io.IOException;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class Font {
	private char[] charset;
	private SpriteSheet spritesheet;
	private int size;
	
	public Font(int size, String file) {
		String tmp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 .,:!?()-_<>";
		charset = tmp.toCharArray();
		this.size = size;
		
		try {
			// load texture from PNG file
			Texture texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(file));
			spritesheet = new SpriteSheet(new Image(texture), texture.getImageHeight()/2, texture.getImageHeight());
						System.out.println("Texture loaded: "+texture);
			System.out.println(">> Image width: "+texture.getImageWidth());
			System.out.println(">> Image height: "+texture.getImageHeight());
			System.out.println(">> Texture width: "+texture.getTextureWidth());
			System.out.println(">> Texture height: "+texture.getTextureHeight());
			System.out.println(">> Texture ID: "+texture.getTextureID());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawString(String str, int x, int y) {
		char[] ca = new char[str.length()];
		
		str = str.toUpperCase();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			for(int ii = 0; ii < charset.length; ii++)
				if (charset[ii] == c) {
						Color.yellow.bind();
						spritesheet.getSprite(ii,0).draw(x, y, size, size*2);
						x += size + 1;
				}
		}
	}
	
	
}
