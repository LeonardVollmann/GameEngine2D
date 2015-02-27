package nona.gameengine2d.graphics;

import nona.gameengine2d.maths.Matrix4f;
import nona.gameengine2d.maths.Vector2f;

public class Camera {

	private Vector2f pos;
	
	public Camera(Vector2f pos) {
		this.pos = pos;
	}
	
	public Matrix4f getViewMatrix() {
		return new Matrix4f().initTranslation(-pos.getX(), -pos.getY(), 0.0f);
	}
	
	public Vector2f getPos() {
		return pos;
	}
	
	public void setPos(Vector2f pos) {
		this.pos = pos;
	}
	
}
