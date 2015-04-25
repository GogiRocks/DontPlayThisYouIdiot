package smartfps.physics;

import smartfps.main.Main;
import smartfps.main.Vector3;

public class PhysicsObject {
	
	final float airDensity = 1.225f;
	
	float dragCoefficient;
	float crossArea;
	
	boolean onGround;
	
	public Vector3 position;
	Vector3 velocity;
	Vector3 acceleration;
	
	long mass;
	
	public void update() {
		
		acceleration = newtonianGravity();
		velocity = updateSpeed();
		
	}
	
	public Vector3 newtonianGravity() {
		
		//initialize acceleration
		Vector3 acceleration = new Vector3();
		
		float forceGravity = (float) ((this.mass * 5.972e24) / Math.pow(6371 + Main.player.position.y, 2));
		float drag = (float) ((1/2) * airDensity * Math.pow(Vector3.length(velocity), 2) * dragCoefficient * crossArea);
		
		float netForce = forceGravity - drag;
		
		acceleration.y = -1 * (netForce / this.mass);
		
		acceleration.x = this.acceleration.x;
		acceleration.z = this.acceleration.z;
		
		return acceleration;
		
	}
	
	public Vector3 updateSpeed() {
		
		float x = velocity.x + acceleration.x;
		float y = velocity.y + acceleration.y;
		float z = velocity.z + acceleration.z;
		
		return new Vector3(x, y, z);
		
	}
	
}
