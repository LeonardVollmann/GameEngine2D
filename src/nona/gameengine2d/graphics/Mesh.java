package nona.gameengine2d.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import nona.gameengine2d.core.Util;

public class Mesh {

	private int vao;
	private int count;
	
	public Mesh(Vertex[] vertices) {
		this.vao = glGenVertexArrays();
		this.count = vertices.length;
		
		glBindVertexArray(vao);
		
		int vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedVertexBuffer(vertices), GL_STATIC_DRAW);
		
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
		glVertexAttribPointer(1, 2, GL_FLOAT, false, Vertex.SIZE * 4, 12);
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		//glBindVertexArray(0);
	}

	public void draw() {
		glBindVertexArray(vao);
		
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		
		glDrawArrays(GL_TRIANGLES, 0, count);
		
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glBindVertexArray(0);
	}
	
}