package nona.gameengine2d.core;

import nona.gameengine2d.graphics.Camera;
import nona.gameengine2d.maths.Matrix4f;
import nona.gameengine2d.maths.Vector2f;
import nona.gameengine2d.maths.Vector3f;

public class Transform {

	private static Camera camera = new Camera();
	
	private Vector3f translation;
	private float rotation;
	private Vector2f scale;
	
	public Transform() {
		this.translation = new Vector3f();
		this.rotation = 0;
		this.scale = new Vector2f(1.0f, 1.0f);
	}
	
	public Matrix4f getTransformation() {
		Matrix4f translationMatrix = new Matrix4f().initTranslation(translation.getX(), translation.getY(), translation.getZ());
		Matrix4f rotationMatrix = new Matrix4f().initRotationZ(rotation);
		Matrix4f scaleMatrix = new Matrix4f().initScaleXY(scale.getX(), scale.getY());
		
		return translationMatrix.mul(rotationMatrix).mul(scaleMatrix);
	}
	
	public static Camera getCamera() {
		return camera;
	}
	
	public static void setCamera(Camera camera) {
		Transform.camera = camera;
	}
	
	public Vector3f getTranslation() {
		return translation;
	}
	
	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}
	
	public void setTranslation(float x, float y, float z) {
		this.translation = new Vector3f(x, y, z);
	}

	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Vector2f getScale() {
		return scale;
	}

	public void setScale(Vector2f scale) {
		this.scale = scale;
	}
	
	public void setScale(float x, float y) {
		this.scale = new Vector2f(x, y);
	}
	
}