package smartfps.player;

import smartfps.physics.PhysicsObject;

import smartfps.bone.Skeleton;
import smartfps.bone.SkeletonHuman;

import smartfps.main.math.Vector3;

public class Player extends PhysicsObject {
	
	Skeleton armature = new SkeletonHuman();
	
	public Vector3 perspective = new Vector3();
	
	public Player() {
		
		
		
	}

}

