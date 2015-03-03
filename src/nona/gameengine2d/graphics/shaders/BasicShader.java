package nona.gameengine2d.graphics.shaders;

import nona.gameengine2d.core.Transform;
import nona.gameengine2d.graphics.RenderingEngine;
import nona.gameengine2d.graphics.Shader;

public class BasicShader extends Shader {

	private static BasicShader instance;
	
	public static BasicShader getInstance() {
		if (instance == null) {
			instance = new BasicShader();
		}
		
		return instance;
	}
	
	private BasicShader() {
		super();
		addVertexShader("basic_shader");
		addFragmentShader("basic_shader");
		compile();
		
		addUniform("u_transform");
		addUniform("u_projection");
		addUniform("u_view");
	}
	
	@Override
	public void updateUniforms(Transform transform) {
		setUniformMatrix4f("u_transform", transform.getTransformation());
		setUniformMatrix4f("u_projection", RenderingEngine.getCamera().getProjection());
		setUniformMatrix4f("u_view", RenderingEngine.getCamera().getViewMatrix());
	}
	
}
