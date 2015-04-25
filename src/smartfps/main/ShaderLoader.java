package smartfps.main;

import static org.lwjgl.glfw.GLFW.*;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;

public class ShaderLoader {
	
	public static StringBuilder getShader(String source) {
		
		StringBuilder shaderSource = new StringBuilder();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(source));
			String line;
			while((line = reader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			reader.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			glfwDestroyWindow(Main.window);
			System.exit(0);
		}
		
		return shaderSource;
		
	}

}
