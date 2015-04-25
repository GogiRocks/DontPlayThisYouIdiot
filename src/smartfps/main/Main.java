package smartfps.main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import java.util.concurrent.TimeUnit;

import smartfps.player.Player;

public class Main {
	
	/**
	 * 
	 * Time between frames (nanoseconds)
	 * 
	 */
	public static int delta;
	
	/**
	 * 
	 * Camera Position
	 * 
	 */
	static float[] cameraPosition = {0.0f, 2f, 0f};
	
	/**
	 * 
	 * Player object
	 * 
	 */
	public static Player player = new Player();
	
	//window requirements
	static long monitor = glfwGetPrimaryMonitor();
	static long window;
	
	static State state = State.HOME_SCREEN;
	
	public static void main(String[] args) {
		
		//initialize GLFW
		if (glfwInit() != GL_FALSE ) {
			System.exit(0);
		}
		
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
		
		//create window
		window = glfwCreateWindow(1920, 1080, "Don't play this you Idiots - SmartFPS", monitor, 0);
		
		glfwSetWindowSize(window, 0, 0);
		
		glfwShowWindow(window);
		
		//OpenGL setup
		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ZERO);
		
		//loop
		while(glfwWindowShouldClose(window) == GL_FALSE) {
			
			delta = calculateDelta();
			
			if(state == State.GAME) {
				
				glfwPollEvents();
			
				cameraPosition[0] = player.position.x;
				cameraPosition[1] = player.position.y + 2;
				cameraPosition[2] = player.position.z;
				
				gameLoop();
				
			}
			
			sync(60);
			
		}
		
		glfwDestroyWindow(window);

	}
	
	static int calculateDelta() {
		
		long time = System.nanoTime();
		long lastFrame = 0;
		delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
		
	}
	
	public static void sync(int framerate) {
		
		//get framerate in milliseconds
		float time = (1 / framerate) * 1000;
		
		//wait the correct time
		try {
			
			TimeUnit.MILLISECONDS.sleep((long) (delta - time));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void gameLoop() {
		
		
		
	}
	
	enum State {
		
		GAME,
		HOME_SCREEN;
		
	}
	
}
