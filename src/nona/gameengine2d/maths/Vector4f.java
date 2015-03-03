package nona.gameengine2d.maths;

public class Vector4f extends Vector {
	 
	public Vector4f() {
		super(4);
	}
	
	public Vector4f(float x, float y, float z, float w) {
		super(x, y, z, w);
	}
	
	public Vector4f(float[] v) {
		super(v);
	}
	
	public Vector4f(Vector4f r) {
		super(r);
	}

	@Override
	public Vector normalized() {
		Vector4f result = new Vector4f(this);
		result.div(length());
		
		return result;
	}
	
}
