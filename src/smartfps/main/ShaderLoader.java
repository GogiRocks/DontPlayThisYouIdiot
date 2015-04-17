package smartfps.main;

import static org.lwjgl.opengl.Display.*;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;

public class ShaderLoader {
	
	public static StringBuilder getShader(String source) {
		
		StringBuilder shaderSource = new StringBuilder();
		
		try {
			
			BufferedReader fragReader = new BufferedReader(new FileReader(source));
			String line;
			while((line = fragReader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}
			
		} catch(IOException e) {
			e.printStackTrace();
			destroy();
			System.exit(0);
		}
		
		return shaderSource;
		
	}

}
