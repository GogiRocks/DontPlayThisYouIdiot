package smartfps.main;

import static org.lwjgl.glfw.GLFW.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CL_Loader {
	
	public static String getCL(String source) {
		
		StringBuilder clSource = new StringBuilder();
		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(CL_Loader.class.getResourceAsStream(source)));
			String line;
			while((line = reader.readLine()) != null) {
				clSource.append(line);
			}
			reader.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			glfwDestroyWindow(Main.window);
			System.exit(0);
		}
		
		return clSource.toString();
		
	}

}
