package nona.gameengine2d.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import nona.gameengine2d.core.Util;

public class Mesh {

	private int vao;
	private int ibo;
	private int count;
	
	public Mesh(Vertex[] vertices, short[] indices) {
		this.vao = glGenVertexArrays();
		this.ibo = glGenBuffers();
		this.count = indices.length;
		
		glBindVertexArray(vao);
		
		int vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedVertexBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
		glVertexAttribPointer(1, 2, GL_FLOAT, false, Vertex.SIZE * 4, 12);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, Util.createFlippedShortBuffer(indices), GL_STATIC_DRAW);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		
		glBindVertexArray(0);
	}

	public void draw() {
		glBindVertexArray(vao);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_SHORT, 0);
		
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
		glBindVertexArray(0);
	}
	
}