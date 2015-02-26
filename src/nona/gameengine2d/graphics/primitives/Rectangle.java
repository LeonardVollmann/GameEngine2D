package nona.gameengine2d.graphics.primitives;

import nona.gameengine2d.graphics.Mesh;
import nona.gameengine2d.graphics.Vertex;
import nona.gameengine2d.maths.Vector2f;
import nona.gameengine2d.maths.Vector3f;


public class Rectangle extends Primitive {

	private float width;
	private float height;
	
	public Rectangle(float width, float height) {
		this.width = width;
		this.height = height;
		
		construct();
	}
	
	@Override
	protected void construct() {
		float xCoord = width / 2.0f;
		float yCoord = height / 2.0f;
		
		Vertex[] vertices = {
			new Vertex(new Vector3f(-xCoord, -yCoord, 0.0f), new Vector2f(0.0f, 0.0f)),
			new Vertex(new Vector3f(-xCoord,  yCoord, 0.0f), new Vector2f(0.0f, 1.0f)),
			new Vertex(new Vector3f( xCoord,  yCoord, 0.0f), new Vector2f(1.0f, 1.0f)),
			
			new Vertex(new Vector3f(-xCoord, -yCoord, 0.0f), new Vector2f(0.0f, 0.0f)),
			new Vertex(new Vector3f( xCoord,  yCoord, 0.0f), new Vector2f(1.0f, 1.0f)),
			new Vertex(new Vector3f( xCoord, -yCoord, 0.0f), new Vector2f(1.0f, 0.0f))
		};
		
		mesh = new Mesh(vertices);
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
		construct();
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
		construct();
	}
	
}