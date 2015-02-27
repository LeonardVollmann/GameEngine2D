package nona.gameengine2d.core;

import nona.gameengine2d.entity.Entity;


public abstract class Game {
	
	protected Entity root;
	
	public Game() {
		root = new Entity();
	}
	
	public abstract void init();
	
	public void update(float delta) {
		root.update(delta);
	}
	
	public void render() {
		root.render();
	}
	
}