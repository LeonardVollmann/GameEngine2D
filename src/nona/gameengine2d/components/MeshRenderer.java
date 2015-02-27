package nona.gameengine2d.components;

import nona.gameengine2d.core.Transform;
import nona.gameengine2d.entity.EntityComponent;
import nona.gameengine2d.graphics.Mesh;

public class MeshRenderer extends EntityComponent {

	private Mesh mesh;
	
	public MeshRenderer(Mesh mesh) {
		this.mesh = mesh;
	}
	
	@Override
	public void render(Transform transform) {
		// TODO: Render using RenderingEngine
	}
	
}
