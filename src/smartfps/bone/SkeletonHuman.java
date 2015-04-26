package smartfps.bone;

import smartfps.bone.Skeleton;

import smartfps.main.math.Vector3;

public class SkeletonHuman extends Skeleton {
	
	SkeletonHuman() {
		
		//root neck/head
		root(new Bone(new Vector3(0.0f, 0.3f, 0.0f), new Vector3(0.0f, 2.0f, 0.0f)));
		
		//1 spine
		addChild((short) 0, new Vector3(0.0f, 0.1f, 0.0f));
		
		//right arm
		
		//2 humerus
		addChild((short) 0, new Vector3(0.3f, 1.4f, 0.0f));
		//3 radius/ulna
		addChild((short) 2, new Vector3(0.3f, 0.9f, 0.0f));
		
		//left arm
		
		//4 humerus
		addChild((short) 0, new Vector3(-0.3f, 1.4f, 0.0f));
		//5 radius/ulna
		addChild((short) 4, new Vector3(-0.3f, 0.9f, 0.0f));
		
		//right leg
		
		//6 femur
		addChild((short) 1, new Vector3(0.2f, 0.5f, 0.0f));
		//7 tibia/fibula
		addChild((short) 6, new Vector3(0.2f, 0.0f, 0.0f));
		
		//left leg
		
		//8 femur
		addChild((short) 1, new Vector3(-0.2f, 0.5f, 0.0f));
		//9 tibia/fibula
		addChild((short) 8, new Vector3(-0.2f, 0.0f, 0.0f));
		
		update();
		
	}
	
}
