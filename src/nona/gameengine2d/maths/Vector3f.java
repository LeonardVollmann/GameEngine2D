package nona.gameengine2d.maths;

public class Vector3f {

	private float[] v;
	
	public Vector3f() {
		this.v = new float[3];
	}
	
	public Vector3f(float x, float y, float z) {
		this();
		this.v[0] = x;
		this.v[1] = y;
		this.v[2] = z;
	}
	
	public Vector3f(float[] v) {
		this.v = v;
	}
	
	public void add(Vector3f r) {
		for (int i = 0; i < 3; i++) {
			v[i] += r.v[i];
		}
	}
	
	public void add(float r) {
		for (int i = 0; i < 3; i++) {
			v[i] += r;
		}
	}
	
	public void sub(Vector3f r) {
		for (int i = 0; i < 3; i++) {
			v[i] -= r.v[i];
		}
	}
	
	public void sub(float r) {
		for (int i = 0; i < 3; i++) {
			v[i] -= r;
		}
	}
	
	public void mul(Vector3f r) {
		for (int i = 0; i < 3; i++) {
			v[i] *= r.v[i];
		}
	}
	
	public void mul(float r) {
		for (int i = 0; i < 3; i++) {
			v[i] *= r;
		}
	}
	
	public void div(Vector3f r) {
		for (int i = 0; i < 3; i++) {
			v[i] /= r.v[i];
		}
	}
	
	public void div(float r) {
		for (int i = 0; i < 3; i++) {
			v[i] /= r;
		}
	}
	
	public float dot(Vector3f r) {
		return v[0] * r.v[0] + v[1] * r.v[1] + v[2] * r.v[2];
	}
	
	public Vector3f cross(Vector3f r) {
		float x = v[1] * r.v[2] - v[2] * r.v[1];
		float y = v[2] * r.v[0] - v[0] * r.v[2];
		float z = v[0] * r.v[1] - v[1] * r.v[0];
		
		return new Vector3f(x, y, z);
	}
	
	public float lengthSquared() {
		return dot(this);
	}
	
	public float length() {
		return (float) Math.sqrt(dot(this));
	}
	
	public Vector3f normalized() {
		Vector3f vector = new Vector3f(v[0], v[1], v[2]);
		vector.div(length());
		
		return vector;
	}
	
	public void normalize() {
		div(length());
	}
	
	public String toString() {
		return "(" + v[0] + ", " + v[1] + ")";
	}
	
	public float get(int index) {
		return v[index];
	}
	
	public float[] getV() {
		return v;
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
