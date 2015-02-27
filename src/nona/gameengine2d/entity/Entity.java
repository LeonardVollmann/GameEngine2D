package nona.gameengine2d.entity;

import java.util.ArrayList;
import java.util.List;

import nona.gameengine2d.core.Transform;

public class Entity {

	private Transform transform;
	
	private List<EntityComponent> components;
	private List<Entity> children;
	
	public Entity() {
		this.transform = new Transform();
		this.components = new ArrayList<EntityComponent>();
		this.children = new ArrayList<Entity>();
	}
	
	public void addComponent(EntityComponent component) {
		components.add(component);
	}
	
	public void addChild(Entity entity) {
		children.add(entity);
	}
	
	public void update(float delta) {
		for (Entity child : children) {
			child.update(delta);
		}
		
		for (EntityComponent component : components) {
			component.update(transform, delta);
		}
	}
	
	public void render() {
		for (Entity child : children) {
			child.render();
		}
		
		for (EntityComponent component : components) {
			component.render(transform);
		}
	}
	
	public Transform getTransform() {
		return transform;
	}
	
}