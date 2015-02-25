package nona.gameengine2d;

import nona.gameengine2d.core.Game;
import nona.gameengine2d.graphics.Mesh;
import nona.gameengine2d.graphics.Shader;
import nona.gameengine2d.graphics.Vertex;
import nona.gameengine2d.maths.Vector3f;

public class TestGame extends Game {
	
	private Mesh mesh;
	private Shader shader;

	@Override
	public void init() {
		Vertex[] vertices = {
				new Vertex(new Vector3f(-1,-1,0)),
				new Vertex(new Vector3f(0,1,0)),
				new Vertex(new Vector3f(1,-1,0)),
		};
		
		mesh = new Mesh(vertices);
		shader = new Shader()
			.addVertexShader("basic_shader")
			.addFragmentShader("basic_shader")
			.compile();
		
		shader.addUniform("u_clampValue");
	}
	
	float time = 0.0f;
	@Override
	public void update(float delta) {
		time += 0.01f;
		shader.bind();
		shader.setUniformFloat("u_clampValue", (float)Math.abs(Math.sin(time)));
		shader.unbind();
	}

	@Override
	public void render() {
		shader.bind();
		mesh.draw();
		shader.unbind();
	}

}
