package nona.gameengine2d.maths;

public class Vector2f {

	private float[] v;
	
	public Vector2f() {
		this.v = new float[2];
	}
	
	public Vector2f(float x, float y) {
		this();
		this.v[0] = x;
		this.v[1] = y;
	}
	
	public Vector2f(float[] v) {
		this.v = v;
	}
	
	public void add(Vector2f r) {
		for (int i = 0; i < 2; i++) {
			v[i] += r.v[i];
		}
	}
	
	public void add(float r) {
		for (int i = 0; i < 2; i++) {
			v[i] += r;
		}
	}
	
	public void sub(Vector2f r) {
		for (int i = 0; i < 2; i++) {
			v[i] -= r.v[i];
		}
	}
	
	public void sub(float r) {
		for (int i = 0; i < 2; i++) {
			v[i] -= r;
		}
	}
	
	public void mul(Vector2f r) {
		for (int i = 0; i < 2; i++) {
			v[i] *= r.v[i];
		}
	}
	
	public void mul(float r) {
		for (int i = 0; i < 2; i++) {
			v[i] *= r;
		}
	}
	
	public void div(Vector2f r) {
		for (int i = 0; i < 2; i++) {
			v[i] /= r.v[i];
		}
	}
	
	public void div(float r) {
		for (int i = 0; i < 2; i++) {
			v[i] /= r;
		}
	}
	
	public float dot(Vector2f r) {
		return v[0] * r.v[0] + v[1] * r.v[1];
	}
	
	public Vector2f rotated(float angle) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		
		return new Vector2f((float)(v[0] * cos - v[1] * sin), (float)(v[0] * sin + v[1] * cos));
	}
	
	public void rotate(float angle) {
		double cos = Math.cos(angle);
		double sin = Math.sin(angle);
		
		v[0] = (float) (v[0] * cos - v[1] * sin);
		v[1] = (float) (v[0] * sin + v[1] * cos);
	}
	
	public float lengthSquared() {
		return dot(this);
	}
	
	public float length() {
		return (float) Math.sqrt(dot(this));
	}
	
	public Vector2f normalized() {
		Vector2f vector = new Vector2f(v[0], v[1]);
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
	
}