package smartfps.particles;

import smartfps.physics.DragCoefficient;
import smartfps.physics.PhysicsObject;
import static org.lwjgl.opengl.GL11.*;

public class Particle extends PhysicsObject {
	
	float red;
	float green;
	float blue;
	
	public Particle(float _red, float _green, float _blue, double mass) {
		
		//update color
		red = _red;
		green = _green;
		blue = _blue;
		
		//update physics constants
		this.mass = mass;
		this.dragCoefficient = (float) DragCoefficient.SPHERE.getValue();
		
	}
	
	public void draw() {
		
		glBegin(GL_POINT);
			
			glColor3f(red, green, blue);
			glVertex3f(position.x, position.y, position.z);
			
		glEnd();
		
	}
	
}
