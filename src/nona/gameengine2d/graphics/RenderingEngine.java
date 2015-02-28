package nona.gameengine2d.graphics;

import nona.gameengine2d.entity.Entity;
import nona.gameengine2d.graphics.shaders.BasicShader;

public class RenderingEngine {
	
	private static RenderingEngine instance;
	
	public static RenderingEngine getInstance() {
		if (instance == null) {
			instance = new RenderingEngine();
		}
		
		return instance;
	}
	
	public void render(Entity entity) {
		Window.getInstance().clear(0.0f, 0.0f, 0.0f, 1.0f);
		
		entity.render(BasicShader.getInstance());
		
		Window.getInstance().swapBuffers();
	}
	
}