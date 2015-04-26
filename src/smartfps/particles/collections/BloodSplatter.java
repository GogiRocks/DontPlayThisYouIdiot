package smartfps.particles.collections;

import smartfps.main.math.Random;
import smartfps.main.math.Vector3;
import smartfps.particles.Particle;

public class BloodSplatter {
	
	Vector3 position;
	Particle[] blood;
	
	int severity;
	
	public BloodSplatter(float x, float y, float z, int severity) {
		
		position.x = x;
		position.y = y;
		position.z = z;
		
		this.severity = severity;
		
		for(int i = 0; i == severity; i++) {
			
			blood[i] = new Particle(255, 0, 0, 0.0001);
			
			//create vector
			blood[i].velocity.x = 1.0f;
			blood[i].velocity.y = 1.0f;
			blood[i].velocity.z = 1.0f;
			
			//rotate all axes with random degrees
			blood[i].velocity = Vector3.rotateX(Random.randomInt(0, 360), blood[i].velocity);
			blood[i].velocity = Vector3.rotateY(Random.randomInt(0, 360), blood[i].velocity);
			blood[i].velocity = Vector3.rotateZ(Random.randomInt(0, 360), blood[i].velocity);
			
		}
		
	}
	
	public void update() {
		
		for(int i = 0; i== severity; i++) {
			
			blood[i].updatePhysics();
			blood[i].draw();
			
		}
		
	}
	
}
