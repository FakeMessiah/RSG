package taatudi.rsg;

import org.lwjgl.opengl.GL11;

public abstract class ScreenComponent {
	protected String text;
	protected Font font;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public ScreenComponent(int x, int y, int width, int height, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.font = new Font(12, "res/font2.png");
		this.text = text;
	}
	
	public void setText(String t) {
		this.text = t;
	}
	
	public void draw() {
		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(0.5f,0.5f,1.0f);
	
		// draw quad
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(x,y);
			GL11.glVertex2f(x+width,y);
			GL11.glVertex2f(x+width,y+height);
			GL11.glVertex2f(x,y+height);
		GL11.glEnd();
		
		if(text != null || !text.equals(""))
			font.drawString(text, x, y);
	
	}
	
	public void update(int delta) {
	
	}
}
