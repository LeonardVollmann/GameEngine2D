package nona.gameengine2d.maths;

public class Vector3f extends Vector {
	
	public Vector3f() {
		super(3);
	}
	
	public Vector3f(float x, float y, float z) {
		super(x, y, z);
	}
	
	public Vector3f(float[] v) {
		super(v);
	}
	
	public Vector3f(Vector3f r) {
		super(r);
	}
	
	public Vector3f cross(Vector3f r) {
		float x = v[1] * r.v[2] - v[2] * r.v[1];
		float y = v[2] * r.v[0] - v[0] * r.v[2];
		float z = v[0] * r.v[1] - v[1] * r.v[0];
		
		return new Vector3f(x, y, z);
	}
	
	public Vector3f normalized() {
		Vector3f result = new Vector3f(this);
		result.div(length());
		
		return result;
	}
	
	public float getX() {
		return v[0];
	}
	
	public float getY() {
		return v[1];
	}
	
	public float getZ() {
		return v[2];
	}
	
}
