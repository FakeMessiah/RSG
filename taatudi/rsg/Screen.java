package taatudi.rsg;

import java.util.List;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

public abstract class Screen {

	protected List<ScreenComponent> components;
	protected boolean transparent = false;

	public Screen() {
		components = new ArrayList<ScreenComponent>();
	}

	public Screen(boolean transparent) {
		components = new ArrayList<ScreenComponent>();
		this.transparent = transparent;
	}
	
	public void draw() {
		if (!transparent)
			GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		for (ScreenComponent c : components)
			c.draw();
	}
	
	public void update(int delta) {
		for (ScreenComponent c : components)
			c.update(delta);
	}

}
