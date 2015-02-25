package nona.gameengine2d.maths;

public class Matrix4f {

	float[][] m;
	
	public Matrix4f() {
		m = new float[4][4];
	}
	
	public Matrix4f initIdentity() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == j) {
					m[i][j] = 1;
				} else {
					m[i][j] = 0;
				}
			}
		}
		
		return this;
	}
	
	public Matrix4f mul(Matrix4f r) {
		Matrix4f result = new Matrix4f();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				result.m[i][j] = m[i][0] * r.m[0][j] +
								 m[i][1] * r.m[1][j] +
								 m[i][2] * r.m[2][j] +
								 m[i][3] * r.m[3][j]; 
			}
		}
		
		return result;
	}
	
	public float get(int x, int y) {
		return m[x][y];
	}
	
	public void set(int x, int y, float value) {
		m[x][y] = value;
	}
	
	public float[][] getM() {
		return m;
	}
	
}
