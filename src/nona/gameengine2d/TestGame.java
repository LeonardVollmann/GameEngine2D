package nona.gameengine2d;

import nona.gameengine2d.core.Game;
import nona.gameengine2d.graphics.Mesh;
import nona.gameengine2d.graphics.Shader;
import nona.gameengine2d.graphics.Texture;
import nona.gameengine2d.graphics.Vertex;
import nona.gameengine2d.maths.Vector2f;
import nona.gameengine2d.maths.Vector3f;

public class TestGame extends Game {
	
	private Mesh mesh;
	private Shader shader;
	private Texture texture;

	@Override
	public void init() {
		Vertex[] vertices = {
				new Vertex(new Vector3f(-1,-1,0), new Vector2f(0, 0)),
				new Vertex(new Vector3f(0,1,0), new Vector2f(0.5f, 1)),
				new Vertex(new Vector3f(1,-1,0), new Vector2f(1, 1)),
		};
		
		mesh = new Mesh(vertices);
		shader = new Shader()
			.addVertexShader("basic_shader")
			.addFragmentShader("basic_shader")
			.compile();
		
		shader.addUniform("u_clampValue");
		//texture = new Texture("bricks.png");
	}
	
	float time = 0.0f;
	@Override
	public void update(float delta) {
		time += 0.01f;
		//texture.bind();
		shader.bind();
		shader.setUniformFloat("u_clampValue", (float)Math.abs(Math.sin(time)));
		//texture.unbind();
		shader.unbind();
	}

	@Override
	public void render() {
		shader.bind();
		mesh.draw();
		shader.unbind();
	}

}
