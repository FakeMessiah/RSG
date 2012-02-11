package taatudi.rsg;

import java.util.List;
import java.util.ArrayList;

public class ScreenManager {
	private List<Screen> screens;
	
	public ScreenManager() {
		screens = new ArrayList<Screen>();
	}
	
	public void addScreen(Screen s) {
		screens.add(s);
	}
	
	public void popScreen(Screen s) {
		screens.remove(s);
	}
	
	public void draw() {
		for( Screen s : screens)
			s.draw();
	}
	
	public void update(int delta) {
		for( Screen s : screens)
			s.update(delta);
	}
}
