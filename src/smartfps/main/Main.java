package smartfps.main;

import static org.lwjgl.opengl.Display.*;

import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Controllers;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

import smartfps.player.Player;

import java.lang.Math;

public class Main {
	
	/**
	 * 
	 * Time between frames
	 * 
	 */
	static int delta;
	
	static float[] lookingAt = {1, 0, 0};

	public static void main(String[] args) {
		
		try {
			
			setTitle("Don't Play This You Idiot - SmartFPS");
			setDisplayMode(new DisplayMode(1920, 1080));
			create();
			
			Keyboard.create();
			Controllers.create();
			
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		//OpenGL setup
		glEnable(GL_BLEND);
		glBlendFunc(GL_ONE, GL_ZERO);
		
		Player player = new Player();
		
		//loop
		while(!isCloseRequested()) {
			
			delta = calculateDelta();
			
			Keyboard.poll();
			Controllers.poll();
			
			gluLookAt(player.x, player.y, player.z, lookingAt[0], lookingAt[1], lookingAt[2], 0, 1, 0);
			
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
	
	/**
	 * turn perspective to the side
	 * 
	 * @param amount degrees
	 * @param right turn right
	 */
	public static void nudgeViewSide(int amount, boolean right) {
		
		int degrees;
		
		//if it is turning right, make the degrees negative
		if (right) {
			degrees = amount;
		} else {
			degrees = amount * -1;
		}
		
		/*
		 * Math to rotate vector:
		 * 
		 * x = x cos (theta) - y sin (theta),
		 * y = x cos (theta) - y sin (theta)
		 * 
		 * (wouldn't let me use theta character)
		 * 
		 */
		
		float x = lookingAt[0];
		float z = lookingAt[2];
		
		//rotate x axis
		lookingAt[0] = (float) ((x * Math.cos(degrees)) - (z * Math.sin(degrees)));
		
		//rotate z axis
		lookingAt[2] = (float) ((x * Math.cos(degrees)) + (z * Math.sin(degrees)));
		
	}
	
	/**
	 * nudge perspective up
	 * 
	 * @param amount degrees
	 * @param up look up
	 */
	public static void nudgeViewUp(int amount, boolean up) {
		
		int degrees;
		
		//if it is trying to look up, make degrees negative
		if(up) {
			degrees = amount;
		}else {
			degrees = amount * -1;
		}
		
		float x = lookingAt[0];
		float y = lookingAt[1];
		
		//see nudgeViewSide
		
		//rotate x axis
		lookingAt[0] = (float) ((x * Math.cos(degrees)) - (y * Math.sin(degrees)));
		
		//rotate y axis
		lookingAt[1] = (float) ((x * Math.cos(degrees)) - (y * Math.sin(degrees)));
		
	}
	
}
