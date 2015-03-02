package nona.gameengine2d.components;

import nona.gameengine2d.core.Transform;
import nona.gameengine2d.entity.EntityComponent;
import nona.gameengine2d.graphics.Shader;
import nona.gameengine2d.graphics.primitives.Primitive;

public class PrimitiveRenderer extends EntityComponent {

	private Primitive primitive;
	
	public PrimitiveRenderer(Primitive primitive) {
		this.primitive = primitive;
	}
	
	@Override
	public void render(Transform transform, Shader shader) {
		shader.bind();
		shader.updateUniforms(transform);
		primitive.draw();
		shader.unbind();
	}
	
}
