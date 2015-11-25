package smartfps.main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import java.util.concurrent.TimeUnit;
import java.nio.DoubleBuffer;

import org.lwjgl.BufferUtils;

import org.lwjgl.opencl.CL;

import smartfps.main.math.Vector3;
import smartfps.player.Player;

public class Main {
	
	/**
	 * 
	 * Time between frames (milliseconds)
	 * 
	 */
	public static int delta;
	
	/**
	 * 
	 * Camera Position
	 * 
	 */
	static Vector3 cameraPosition;
	
	/**
	 * 
	 * Player object
	 * 
	 */
	public static Player player = new Player();
	
	//window requirements
	static final long monitor = glfwGetPrimaryMonitor();
	static long window;
	
	static State state = State.HOME_SCREEN;
	
	//mouse positions
	static DoubleBuffer mousex;
	static DoubleBuffer mousey;
	static DoubleBuffer lastx;
	static DoubleBuffer lasty;
	
	public static void main(String[] args) {
		
		//initialize GLFW
		if (glfwInit() != GL_FALSE ) {
			System.exit(0);
		}
		
		glfwWindowHint(GLFW_VISIBLE, GL_TRUE);
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
		
		//create window
		window = glfwCreateWindow(1920, 1080, "Don't play this you Idiots - SmartFPS", monitor, 0);
		
		glfwSetWindowSize(window, 0, 0);
		
		glfwShowWindow(window);
		
		//OpenGL setup
		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ZERO);
		
		//Mouse setup
		mousex = BufferUtils.createDoubleBuffer(1);
		mousey = BufferUtils.createDoubleBuffer(1);
		
		//OpenCL setup
		try {
			
			CL.create();
			
		} catch (Exception e) {
			
			System.err.println("Hardware does not suport OpenCL");

		}
		
		//load OpenCL math
		
		
		//loop
		while(glfwWindowShouldClose(window) == GL_FALSE) {
			
			delta = calculateDelta();
			
			glfwPollEvents();
			glfwGetCursorPos(window, mousex, mousex);
			
			if(state == State.HOME_SCREEN) {
				
				homeLoop();
				
			} else if(state == State.GAME) {
				
				gameLoop();
				
			}
			
			sync(60);
			
		}
		
		glfwDestroyWindow(window);

	}
	
	private static long lastFrame;
	
	static int calculateDelta() {
		
		long time = System.currentTimeMillis();
		delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
		
	}
	
	static void sync(int framerate) {
		
		//get framerate in milliseconds
		float time = (1 / framerate) * 1000;
		
		//wait the correct time
		try {
			
			TimeUnit.MILLISECONDS.sleep((long) (delta - time));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void homeLoop() {
		
		
		
	}
	
	private static void gameLoop() {
		
		cameraPosition.x = player.position.x;
		cameraPosition.y = player.position.y + 1;
		cameraPosition.z = player.position.z;
		
		int differencex = (int) Math.floor(mousex.get(0) - lastx.get(0));
		int differencey = (int) Math.floor(mousey.get(0) - lasty.get(0));
		
		lastx = mousex;
		lasty = mousey;

		player.perspective = Vector3.rotateY(differencex, player.perspective);
		player.perspective = Vector3.rotateX(differencey, player.perspective);
		glRotated(differencex, 0, 1, 0);
		glRotated(differencey, 1, 0, 0);
		
	}
	
	enum State {
		
		GAME,
		HOME_SCREEN;
		
	}
	
}
