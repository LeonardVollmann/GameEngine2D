package nona.gameengine2d;

import nona.gameengine2d.core.Game;
import nona.gameengine2d.core.Transform;
import nona.gameengine2d.graphics.Mesh;
import nona.gameengine2d.graphics.Shader;
import nona.gameengine2d.graphics.Texture;
import nona.gameengine2d.graphics.Vertex;
import nona.gameengine2d.graphics.primitives.Rectangle;
import nona.gameengine2d.maths.Vector2f;
import nona.gameengine2d.maths.Vector3f;

public class TestGame extends Game {
	
	private Shader shader;
	private Texture texture;
	private Rectangle rect;
	private Transform transform;

	@Override
	public void init() {
		shader = new Shader()
			.addVertexShader("basic_shader")
			.addFragmentShader("basic_shader")
			.compile();
		shader.addUniform("u_transform");
		
		//texture = new Texture("bricks.png");
		rect = new Rectangle(0.5f, 0.5f);
		transform = new Transform();
	}
	
	float time = 0.0f;
	@Override
	public void update(float delta) {
		time += 0.01f;
		float sinTime = (float)(Math.sin(time));
		float cosTime = (float)(Math.cos(time));
		transform.setTranslation(sinTime / 2.0f, cosTime / 2.0f, 0.0f);
		transform.setRotation(time);
		transform.setScale(sinTime, sinTime);
		//texture.bind();
		shader.bind();
		//texture.unbind();
		shader.setUniformMatrix4f("u_transform", transform.getTransformation());
		shader.unbind();
		
//		rect.setWidth(sinTime);
//		rect.setHeight(cosTime);
	}

	@Override
	public void render() {
		shader.bind();
		rect.draw();
		shader.unbind();
	}

}
