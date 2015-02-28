package nona.gameengine2d.graphics;

import nona.gameengine2d.maths.Matrix4f;
import nona.gameengine2d.maths.Vector2f;

public class Camera {

	private Vector2f pos;
	private Matrix4f projection;
	
	public Camera(Vector2f pos) {
		this.pos = pos;
	}
	
	public Camera() {
		this(new Vector2f(0, 0));
	}
	
	public Matrix4f getViewMatrix() {
		return new Matrix4f().initTranslation(-pos.getX(), -pos.getY(), -1.0f);
	}
	
	public Matrix4f getViewProjection() {
		return projection.mul(getViewMatrix());
	}
	
	public void updateProjection(float aspect) {
		projection = new Matrix4f().initOrthographicProjection(-aspect, aspect, -1, 1, -1.00001f, 100.0f);
	}
	
	public Vector2f getPos() {
		return pos;
	}
	
	public void setPos(Vector2f pos) {
		this.pos = pos;
	}
	
	public Matrix4f getProjection() {
		return projection;
	}
	
	public void setProjection(Matrix4f projection) {
		this.projection = projection;
	}
	
}
