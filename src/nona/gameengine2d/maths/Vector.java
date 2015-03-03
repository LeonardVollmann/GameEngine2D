package nona.gameengine2d.maths;

public abstract class Vector {

	protected int size;
	protected float v[];
	
	public Vector(float... v) {
		this.size = v.length;
		this.v = v;
	}
	
	public Vector(int size) {
		this.size = size;
		this.v = new float[size];
	}
	
	public Vector(Vector r) {
		this.size = r.size;
		this.v = r.v;
	}
	
	public void add(Vector r) {
		for (int i = 0; i < (size < r.size ? size : r.size); i++) {
			v[i] += r.v[i];
		}
	}
	
	public void add(float r) {
		for (int i = 0; i < size; i++) {
			v[i] += r;
		}
	}
	
	public void sub(Vector r) {
		for (int i = 0; i < (size < r.size ? size : r.size); i++) {
			v[i] -= r.v[i];
		}
	}
	
	public void sub(float r) {
		for (int i = 0; i < size; i++) {
			v[i] -= r;
		}
	}
	
	public void mul(Vector r) {
		for (int i = 0; i < (size < r.size ? size : r.size); i++) {
			v[i] *= r.v[i];
		}
	}
	
	public void mul(float r) {
		for (int i = 0; i < size; i++) {
			v[i] *= r;
		}
	}
	
	public void div(Vector r) {
		for (int i = 0; i < (size < r.size ? size : r.size); i++) {
			v[i] /= r.v[i];
		}
	}
	
	public void div(float r) {
		for (int i = 0; i < size; i++) {
			v[i] /= r;
		}
	}
	
	public float dot(Vector r) {
		float dot = 0;
		for (int i = 0; i < (size < r.size ? size : r.size); i++) {
			dot += v[i] * r.v[i];
		}
		
		return dot;
	}
	
	public float lengthSquared() {
		return dot(this);
	}
	
	public float length() {
		return (float) Math.sqrt(dot(this));
	}
	
	public abstract Vector normalized();
	
	public void normalize() {
		div(length());
	}
	
	@Override
	public String toString() {
		String s = "(";
		for (int i = 0; i < size - 1; i++) {
			s += v[i] + ", ";
		}
		s += v[size - 1] + ")";
		
		return s;
	}
	
	public float get(int i) {
		return v[i];
	}
	
	public float[] getV() {
		return v;
	}
	
}
