package nona.gameengine2d.graphics;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import nona.gameengine2d.input.Keyboard;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GLContext;

public class Window {
	
	private static long window;
	private static int width;
	private static int height;
	
	private static GLFWWindowSizeCallback windowSizeCallback;
	private static GLFWKeyCallback keyCallback;
	
	public static void init(int width, int height, String title) {
		if (glfwInit() != GL_TRUE) {
			// TODO: Proper Error handling
			System.err.println("ERROR: Failed to initialise GLFW.");
			System.exit(1);
		}
		
		Window.width = width;
		Window.height = height;
		
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
		
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
		GLContext.createFromCurrent();
		glfwSwapInterval(1);
		
		initCallbacks();
		
		updateProjection(width, height);
	}
	
	public static int shouldClose() {
		return glfwWindowShouldClose(window);
	}
	
	public static void clear(float r, float g, float b, float a) {
		glClearColor(r, g, b, a);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void swapBuffers() {
		glfwSwapBuffers(window);
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static float getAspect() {
		return (float)width / (float)height;
	}
	
	private static void updateProjection(int width, int height) {
		RenderingEngine.getCamera().updateProjection((float)width / (float)height);
	}
	
	private static void initCallbacks() {
		windowSizeCallback = new GLFWWindowSizeCallback() {
			@Override
			public void invoke(long window, int width, int height) {
				Window.width = width;
				Window.height = height;
				updateProjection(width, height);
			}
		};
		
		keyCallback = new GLFWKeyCallback() {
			@Override
			public void invoke(long window, int key, int scancode, int action, int mods) {
				Keyboard.setKey(key, action == GLFW_PRESS || action == GLFW_REPEAT);
			}
		};
		
		glfwSetWindowSizeCallback(window, windowSizeCallback);
		glfwSetKeyCallback(window, keyCallback);
	}
	
}
