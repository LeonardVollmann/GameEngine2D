package nona.gameengine2d.graphics;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Shader {
	
	protected int program;
	
	public static String loadShaderSource(String path, String extension) {
		StringBuilder shaderSource = new StringBuilder();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader("./res/shaders/" + path + extension));
			String line;
			while ((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return shaderSource.toString();
	}
	
	public Shader() {
		this.program = glCreateProgram();
		if (program == 0) {
			// TODO: Proper Error handling
						System.err.println("ERROR: Shader program creation failed.");
		}
		
		glBindAttribLocation(program, 0, "in_position");
	}
	
	public Shader addVertexShader(String path) {
		addProgram(loadShaderSource(path, ".vs"), GL_VERTEX_SHADER);
		return this;
	}
	
	public Shader addFragmentShader(String path) {
		addProgram(loadShaderSource(path, ".fs"), GL_FRAGMENT_SHADER);
		return this;
	}
	
	public Shader addGeometryShader(String path) {
		addProgram(loadShaderSource(path, ".gs"), GL_GEOMETRY_SHADER);
		return this;
	}
	
	public Shader compile() {
		glLinkProgram(program);
		if (glGetProgrami(program, GL_LINK_STATUS) == 0) {
			System.err.println(glGetProgramInfoLog(program, 1024));
		}
		
		glValidateProgram(program);
		if (glGetProgrami(program, GL_VALIDATE_STATUS) == 0) {
			System.err.println(glGetProgramInfoLog(program, 1024));
		}
		
		return this;
	}
	
	public void bind() {
		glUseProgram(program);
	}
	
	public void unbind() {
		glUseProgram(0);
	}
	
	private void addProgram(String source, int type) {
		int shader = glCreateShader(type);
		if (shader == 0) {
			// TODO: Proper Error handling
			System.err.println("ERROR: Shader creation failed.");
		}
		
		glShaderSource(shader, source);
		glCompileShader(shader);
		
		if (glGetShaderi(shader, GL_COMPILE_STATUS) == 0) {
			System.err.println(glGetShaderInfoLog(shader, 1024));
		}
		
		glAttachShader(program, shader);
	}
	
}