package nona.gameengine2d.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import nona.gameengine2d.graphics.RenderingEngine;
import nona.gameengine2d.graphics.Window;
import nona.gameengine2d.input.Keyboard;

public class CoreEngine {

	public static final boolean IGNORE_FRAMECAP = true;
	
	private boolean running;
	private double nsPerUpdate;
	
	private Game game;
	
	public CoreEngine(int width, int height, String title, int fps, Game game) {
		this.nsPerUpdate = 1000000000.0 / fps;
		this.game = game;
		this.running = false;
		
		initSingletons(width, height, title);
	}
	
	public void start() {
		running = true;
		run();
	}
	
	public void stop() {
		running = false;
	}
	
	@SuppressWarnings("unused")
	private void run() {
		init();
		
		long lastTime = System.nanoTime();
		long now;
		double delta = 0;
		
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		boolean shouldRender = false;
		
		while (running) {
			if (Window.shouldClose() == GL_TRUE) {
				running = false;
				continue;
			}
			
			now = System.nanoTime();
			delta += now - lastTime;
			lastTime = now;
			
			while (delta >= nsPerUpdate) {
				delta -= nsPerUpdate;
				update((float)delta);
				updates++;
				shouldRender = true;
			}
			
			if(IGNORE_FRAMECAP || (!IGNORE_FRAMECAP && shouldRender)) {
				render();
				frames++;
				shouldRender = false;
			}
			
			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				System.out.println(updates + " updates, " + frames + " frames");
				updates = 0;
				frames = 0;
			}
		}
	}
	
	private void update(float delta) {
		glfwPollEvents();
		
		game.update(delta);
		
		Keyboard.update();
	}
	
	private void render() {
		RenderingEngine.render(game.getRootEntity());
	}

	private void init() {
		glFrontFace(GL_CW);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		
		glEnable(GL_DEPTH_TEST);
		
		game.init();
	}
	
	private void initSingletons(int width, int height, String title) {
		Keyboard.init();
		Window.init(width, height, title);
	}
	
}