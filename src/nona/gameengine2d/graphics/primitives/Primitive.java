package nona.gameengine2d.graphics.primitives;

import nona.gameengine2d.graphics.Mesh;

public abstract class Primitive {

	protected Mesh mesh;
	
	public void draw() {
		mesh.draw();
	}
	
	protected abstract void construct();
	
}