package nona.gameengine2d.entity;

import java.util.ArrayList;
import java.util.List;

import nona.gameengine2d.core.Transform;
import nona.gameengine2d.graphics.Shader;

public class Entity {

	private Transform transform;
	
	private List<EntityComponent> components;
	private List<Entity> children;
	
	public Entity() {
		this.transform = new Transform();
		this.components = new ArrayList<EntityComponent>();
		this.children = new ArrayList<Entity>();
	}
	
	public Entity addComponent(EntityComponent component) {
		components.add(component);
		return this;
	}
	
	public Entity addChild(Entity entity) {
		children.add(entity);
		return this;
	}
	
	public void update(float delta) {
		for (Entity child : children) {
			child.update(delta);
		}
		
		for (EntityComponent component : components) {
			component.update(transform, delta);
		}
	}
	
	public void render(Shader shader) {
		for (Entity child : children) {
			child.render(shader);
		}
		
		for (EntityComponent component : components) {
			component.render(transform, shader);
		}
	}
	
	public Transform getTransform() {
		return transform;
	}
	
}