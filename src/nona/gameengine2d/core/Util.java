package nona.gameengine2d.core;

import java.nio.FloatBuffer;

import nona.gameengine2d.graphics.Vertex;
import nona.gameengine2d.maths.Matrix4f;

import org.lwjgl.BufferUtils;

public class Util {
	
	private Util() {
	}

	public static FloatBuffer createFlippedVertexBuffer(Vertex[] vertices) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);
		
		for (int i = 0; i < vertices.length; i++) {
			buffer.put(vertices[i].getPos().getV());
			buffer.put(vertices[i].getTexCoord().getV());
		}
		
		buffer.flip();
		return buffer;
	}
	
	public static FloatBuffer createFlippedMatrix4fBuffer(Matrix4f matrix) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				buffer.put(matrix.get(i, j));
			}
		}
		
		buffer.flip();
		return buffer;
	}
	
}
