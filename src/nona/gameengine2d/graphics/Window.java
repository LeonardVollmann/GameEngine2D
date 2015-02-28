package nona.gameengine2d.graphics;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import nona.gameengine2d.core.Transform;
import nona.gameengine2d.maths.Matrix4f;

import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GLContext;

public class Window {

	private static Window instance;
	
	public static Window getInstance() {
		if (instance == null) {
			// TODO: Proper Error handling
			System.err.println("ERROR: Call Window.init(int width, int height, String title) before Window.getInstance()");
			return null;
		}
		
		return instance;
	}
	
	public static void init(int width, int height, String title) {
		instance = new Window(width, height, title);
	}
	
	private long window;
	
	private Matrix4f projection;
	
	private Window(int width, int height, String title) {
		if (glfwInit() != GL_TRUE) {
			// TODO: Proper Error handling
			System.err.println("ERROR: Failed to initialise GLFW.");
			System.exit(1);
		}
		
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
		glfwSwapInterval(0);
		
		glfwSetWindowSizeCallback(window, new GLFWWindowSizeCallback() {
			public void invoke(long window, int width, int height) {
				updateProjection(width, height);
			}
		});
		
		updateProjection(width, height);
	}
	
	public int shouldClose() {
		return glfwWindowShouldClose(window);
	}
	
	public void clear(float r, float g, float b, float a) {
		glClearColor(r, g, b, a);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public void swapBuffers() {
		glfwSwapBuffers(window);
	}
	
	private void updateProjection(int width, int height) {
		Transform.getCamera().updateProjection((float)width / (float)height);
	}
	
}
