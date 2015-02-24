package nona.gameengine2d.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWvidmode;

public class CoreEngine {

	public static final boolean IGNORE_FRAMECAP = true;
	
	private boolean running;
	
	private double nsPerUpdate;
	
	private long window;
	private int width;
	private int height;
	private String title;
	
	public CoreEngine(int width, int height, String title, int fps) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.nsPerUpdate = 1000000000.0 / fps;
		
		this.running = false;
	}
	
	public void start() {
		running = true;
		init();
		run();
	}
	
	public void stop() {
		running = false;
	}
	
	private void run() {
		long lastTime = System.nanoTime();
		long now;
		double delta = 0;
		
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		boolean shouldRender = false;
		
		while (running) {
			if (glfwWindowShouldClose(window) == GL_TRUE) {
				running = false;
				continue;
			}
			
			now = System.nanoTime();
			delta += now - lastTime;
			lastTime = now;
			
			while (delta >= nsPerUpdate) {
				delta -= nsPerUpdate;
				update((float) delta);
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
	}
	
	private void render() {
		glfwSwapBuffers(window);
	}
	
	private void init() {
		if (glfwInit() != GL_TRUE) {
			// TODO: Proper Error handling
			System.err.println("ERROR: Failed to initialise GLFW.");
			System.exit(1);
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(width, height, title, NULL, NULL);
		if (window == NULL) {
			// TODO: Proper Error handling
			System.err.println("ERROR: Failed to create window.");
			System.exit(1);
		}
		
		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (GLFWvidmode.width(vidmode) - width) / 2, (GLFWvidmode.height(vidmode) - height) / 2);
		
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
	}
	
}
