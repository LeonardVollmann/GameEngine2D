package nona.gameengine2d;

import nona.gameengine2d.components.MeshRenderer;
import nona.gameengine2d.core.Game;
import nona.gameengine2d.core.Transform;
import nona.gameengine2d.entity.Entity;
import nona.gameengine2d.graphics.Camera;
import nona.gameengine2d.graphics.Mesh;
import nona.gameengine2d.graphics.Shader;
import nona.gameengine2d.graphics.Vertex;
import nona.gameengine2d.graphics.primitives.Rectangle;
import nona.gameengine2d.input.Keyboard;
import nona.gameengine2d.maths.Vector2f;
import nona.gameengine2d.maths.Vector3f;

public class TestGame extends Game {
	
	private Shader shader;
//	private Texture texture;
	private Rectangle rect;
	private Transform transform;
	private Camera camera;
	
	public TestGame() {
		super();
	}
	
	@Override
	public void init() {
		shader = new Shader()
			.addVertexShader("basic_shader")
			.addFragmentShader("basic_shader")
			.compile();
		shader.addUniform("u_transform");
		shader.addUniform("u_projection");
		shader.addUniform("u_view");
		
		//texture = new Texture("bricks.png");
		rect = new Rectangle(0.5f, 0.5f);
		transform = new Transform();
		camera = new Camera(new Vector2f(0.0f, 0.0f));
		
		float xCoord = 0.5f;
		float yCoord = 0.5f;
		Vertex[] vertices = {
			new Vertex(new Vector3f(-xCoord, -yCoord, 0.0f), new Vector2f(0.0f, 0.0f)),
			new Vertex(new Vector3f(-xCoord,  yCoord, 0.0f), new Vector2f(0.0f, 1.0f)),
			new Vertex(new Vector3f( xCoord,  yCoord, 0.0f), new Vector2f(1.0f, 1.0f)),
			new Vertex(new Vector3f( xCoord, -yCoord, 0.0f), new Vector2f(1.0f, 0.0f))
		};
			
		short[] indices = {
			0, 1, 2,
			0, 2, 3
		};
		
		Mesh mesh = new Mesh(vertices, indices);
		root.addChild(new Entity().addComponent(new MeshRenderer(mesh)));
	}
	
	float time = 0.0f;
	@Override
	public void update(float delta) {
		super.update(delta);

		time += 0.01f;
		float sinTime = (float)(Math.sin(time));
		float cosTime = (float)(Math.cos(time));
//		transform.setTranslation(sinTime / 2.0f, cosTime / 2.0f, 0.0f);
//		transform.setRotation(time);
//		transform.setScale(sinTime, sinTime);
		camera.setPos(new Vector2f(cosTime, sinTime));
		//texture.bind();
		shader.bind();
		//texture.unbind();
		shader.setUniformMatrix4f("u_transform", transform.getTransformation());
		shader.setUniformMatrix4f("u_projection", Transform.getCamera().getProjection());
		shader.setUniformMatrix4f("u_view", camera.getViewMatrix());
		shader.unbind();
		
//		rect.setWidth(sinTime);
//		rect.setHeight(cosTime);
//		System.out.println(Keyboard.getKey(Keyboard.KEY_SPACE));
		if (Keyboard.getKey(Keyboard.KEY_SPACE)) {
			System.out.println("Space");
		}
	}

//	@Override
//	public void render() {
//		super.render();
//		
//		shader.bind();
//		rect.draw();
//		shader.unbind();
//	}

}
