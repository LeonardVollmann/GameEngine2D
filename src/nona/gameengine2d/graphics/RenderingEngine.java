package nona.gameengine2d.graphics;

import nona.gameengine2d.entity.Entity;
import nona.gameengine2d.graphics.shaders.BasicShader;

public class RenderingEngine {
	
	public static void render(Entity entity) {
		Window.clear(0.0f, 0.0f, 0.0f, 1.0f);
		
		entity.render(BasicShader.getInstance());
		
		Window.swapBuffers();
	}
	
}