package nona.gameengine2d.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import nona.gameengine2d.core.Util;

public class Mesh {

	private int vbo;
	private int size;
	
	public Mesh(Vertex[] vertices) {
		this.vbo = glGenBuffers();
		this.size = vertices.length;
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedVertexBuffer(vertices), GL_STATIC_DRAW);
	}

	public void draw() {
		glEnableVertexAttribArray(0);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
		
		glDrawArrays(GL_TRIANGLES, 0, size);
		
		glDisableVertexAttribArray(0);
	}
	
}