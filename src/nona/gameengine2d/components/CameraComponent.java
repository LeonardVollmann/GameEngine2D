package nona.gameengine2d.components;

import nona.gameengine2d.core.Transform;
import nona.gameengine2d.entity.EntityComponent;
import nona.gameengine2d.graphics.Camera;
import nona.gameengine2d.graphics.RenderingEngine;
import nona.gameengine2d.maths.Vector2f;

public class CameraComponent extends EntityComponent {

	private Camera camera;
	
	public CameraComponent(Camera camera) {
		this.camera = camera;
	}
	
	public CameraComponent() {
		this.camera = new Camera();
	}
	
	@Override
	public void update(Transform transform, float delta) {
		camera.setPos(new Vector2f(transform.getTranslation().getX(), transform.getTranslation().getY()));
	}
	
	public CameraComponent setAsMainCamera() {
		RenderingEngine.setCamera(this.camera);
		return this;
	}
	
}
