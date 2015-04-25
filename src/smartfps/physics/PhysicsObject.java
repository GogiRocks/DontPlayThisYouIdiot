package smartfps.physics;

import smartfps.main.Main;
import smartfps.main.Vector3;

public class PhysicsObject {
	
	final float airDensity = 1.225f;
	
	public float dragCoefficient;
	public float crossArea;
	
	public Vector3 position;
	public Vector3 velocity;
	public Vector3 acceleration;
	
	public double mass;
	
	public void updatePhysics() {
		
		acceleration = newtonianGravity();
		velocity = updateSpeed();
		
		//change position using velocity
		//divided by 60 to convert from seconds to frames
		position.x += (velocity.x / 60);
		position.y += (velocity.y / 60);
		position.z += (velocity.z / 60);
		
	}
	
	public Vector3 newtonianGravity() {
		
		//initialize acceleration
		Vector3 acceleration = new Vector3();
		
		float forceGravity = (float) ((this.mass * 5.972e24) / Math.pow(6371 + Main.player.position.y, 2));
		float drag = (float) ((1/2) * airDensity * Math.pow(Vector3.length(velocity), 2) * dragCoefficient * crossArea);
		
		float netForce = forceGravity - drag;
		
		acceleration.y = (float) (-1 * (netForce / this.mass));
		
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
