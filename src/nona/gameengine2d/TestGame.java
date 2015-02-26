package nona.gameengine2d;

import nona.gameengine2d.core.Game;
import nona.gameengine2d.graphics.Mesh;
import nona.gameengine2d.graphics.Shader;
import nona.gameengine2d.graphics.Texture;
import nona.gameengine2d.graphics.Vertex;
import nona.gameengine2d.graphics.primitives.Rectangle;
import nona.gameengine2d.maths.Vector2f;
import nona.gameengine2d.maths.Vector3f;

public class TestGame extends Game {
	
	private Mesh mesh;
	private Shader shader;
	private Texture texture;
	private Rectangle rect;

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
		rect = new Rectangle(0.5f, 0.5f);
	}
	
	float time = 0.0f;
	@Override
	public void update(float delta) {
		time += 0.01f;
		float sinTime = (float)Math.abs(Math.sin(time));
		float cosTime = (float)Math.abs(Math.cos(time));
		//texture.bind();
		shader.bind();
		shader.setUniformFloat("u_clampValue", sinTime);
		//texture.unbind();
		shader.unbind();
		
		rect.setWidth(sinTime);
		rect.setHeight(cosTime);
	}

	@Override
	public void render() {
		shader.bind();
		rect.draw();
		shader.unbind();
	}

}
