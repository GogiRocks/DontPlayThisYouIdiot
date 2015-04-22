package smartfps.main;

import static org.lwjgl.opengl.Display.*;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Controllers;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

import smartfps.player.Player;

public class Main {
	
	/**
	 * 
	 * Time between frames
	 * 
	 */
	static int delta;
	
	static float[] cameraPosition = {0.5f, 2f, 0f};
	
	Player player = new Player();
	
	public static void main(String[] args) {
		
		try {
			
			//create window
			setTitle("Don't Play This You Idiot - SmartFPS");
			setDisplayMode(new DisplayMode(1920, 1080));
			create();
			
			//create inputs
			Mouse.create();
			Keyboard.create();
			Controllers.create();
			
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//OpenGL setup
		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ZERO);
		
		//loop
		while(!isCloseRequested()) {
			
			delta = calculateDelta();
			
			Mouse.poll();
			Keyboard.poll();
			Controllers.poll();
			
			
			
			update();
			sync(60);
			
		}
		
		destroy();

	}
	
	static int calculateDelta() {
		
		long time = getTime();
		long lastFrame = 0;
		delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
		
	}
	
	static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
}