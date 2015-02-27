package nona.gameengine2d.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import nona.gameengine2d.graphics.Window;

public class CoreEngine {

	public static final boolean IGNORE_FRAMECAP = true;
	
	private boolean running;
	
	private double nsPerUpdate;
	
	private Window window;
	
	private Game game;
	
	public CoreEngine(int width, int height, String title, int fps, Game game) {
		this.window = new Window(width, height, title);
		this.nsPerUpdate = 1000000000.0 / fps;
		this.game = game;
		
		this.running = false;
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
			if (window.shouldClose() == GL_TRUE) {
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
	}
	
	private void render() {
		window.clear(0.0f, 0.0f, 0.0f, 1.0f);
		
		game.render();
		
		window.swapBuffers();
	}

	private void init() {
		glFrontFace(GL_CW);
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		
		glEnable(GL_DEPTH_TEST);
		
		game.init();
	}
	
}