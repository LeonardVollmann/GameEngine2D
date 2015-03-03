package nona.gameengine2d.graphics;

import nona.gameengine2d.entity.Entity;
import nona.gameengine2d.graphics.shaders.BasicShader;

public class RenderingEngine {
	
	private static Camera camera = new Camera();
	
	public static void render(Entity entity) {
		Window.clear(0.0f, 0.0f, 0.0f, 1.0f);
		
		entity.render(BasicShader.getInstance());
		
		Window.swapBuffers();
	}
	
	public static Camera getCamera() {
		return camera;
	}
	
	public static void setCamera(Camera camera) {
		RenderingEngine.camera = camera;
	}
	
}