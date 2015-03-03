package nona.gameengine2d.maths;

public class Vector2f extends Vector {
	
	public Vector2f() {
		super(2);
	}
	
	public Vector2f(float x, float y) {
		super(x, y);
	}
	
	public Vector2f(float[] v) {
		super(v);
	}
	
	public Vector2f(Vector2f r) {
		super(r);
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
	
	public Vector2f normalized() {
		Vector2f result = new Vector2f(this);
		result.div(length());
		
		return result;
	}
	
	public float getX() {
		return v[0];
	}
	
	public float getY() {
		return v[1];
	}
	
}