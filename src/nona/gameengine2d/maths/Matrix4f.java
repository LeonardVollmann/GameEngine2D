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
	
	public Matrix4f initTranslation(float x, float y, float z) {
		m[0][0] = 1; m[0][1] = 0; m[0][2] = 0; m[0][3] = x;
		m[1][0] = 0; m[1][1] = 1; m[1][2] = 0; m[1][3] = y;
		m[2][0] = 0; m[2][1] = 0; m[2][2] = 1; m[2][3] = z;
		m[3][0] = 0; m[3][1] = 0; m[3][2] = 0; m[3][3] = 1;
		
		return this;
	}
	
	public Matrix4f initRotationZ(float angle) {
		float sinAngle = (float)Math.sin(angle);
		float cosAngle = (float)Math.cos(angle);
		
		m[0][0] = cosAngle; m[0][1] = -sinAngle; m[0][2] = 0; m[0][3] = 0;
		m[1][0] = sinAngle; m[1][1] = cosAngle;  m[1][2] = 0; m[1][3] = 0;
		m[2][0] = 0; 		m[2][1] = 0;		 m[2][2] = 1; m[2][3] = 0;
		m[3][0] = 0; 		m[3][1] = 0; 		 m[3][2] = 0; m[3][3] = 1;
		
		return this;
	}
	
	public Matrix4f initScaleXY(float x, float y) {
		m[0][0] = x; m[0][1] = 0; m[0][2] = 0; m[0][3] = 0;
		m[1][0] = 0; m[1][1] = y; m[1][2] = 0; m[1][3] = 0;
		m[2][0] = 0; m[2][1] = 0; m[2][2] = 1; m[2][3] = 0;
		m[3][0] = 0; m[3][1] = 0; m[3][2] = 0; m[3][3] = 1;
		
		return this;
	}
	
	public Matrix4f initOrthographicProjection(float left, float right, float bottom, float top, float near, float far) {
		m[0][0] = 2.0f / (right - left); m[0][1] = 0;
		m[1][0] = 0; 					 m[1][1] = 2.0f / (top - bottom);
		m[2][0] = 0; 					 m[2][1] = 0;
		m[3][0] = 0; 					 m[3][1] = 0;
		
		m[0][2] = 0; 					m[0][3] = -((right + left) / (right - left));
		m[1][2] = 0; 					m[1][3] = -((top + bottom) / (top - bottom));
		m[2][2] = -2.0f / (far - near); m[2][3] = (far + near) / (far - near);
		m[3][2] = 0; 					m[3][3] = 1;
		
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
