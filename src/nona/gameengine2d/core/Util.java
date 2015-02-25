package nona.gameengine2d.core;

import java.nio.FloatBuffer;

import nona.gameengine2d.graphics.Vertex;

import org.lwjgl.BufferUtils;

public class Util {
	
	private Util() {
	}

	public static FloatBuffer createFlippedVertexBuffer(Vertex[] vertices) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * Vertex.SIZE);
		
		for (int i = 0; i < vertices.length; i++) {
			buffer.put(vertices[i].getPos().getV());
		}
		
		buffer.flip();
		return buffer;
	}
	
}
