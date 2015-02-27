package nona.gameengine2d.entity;

import nona.gameengine2d.core.Transform;

public abstract class EntityComponent {
	
	public void update(Transform transform, float delta) {}
	public void render(Transform transform) {}
	
}