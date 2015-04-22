package smartfps.bone;

import smartfps.bone.Skeleton;

public class SkeletonHuman extends Skeleton {
	
	SkeletonHuman() {
		
		//root neck/head
		root(new Bone(0.0f, 0.3f, 0.0f, 0.0f, 2.0f, 0.0f));
		
		//1 spine
		addChild((short) 0, 0.0f, 0.1f, 0.0f);
		
		//right arm
		
		//2 humerus
		addChild((short) 0, 0.3f, 1.4f, 0.0f);
		//3 radius/ulna
		addChild((short) 2, 0.3f, 0.9f, 0.0f);
		
		//left arm
		
		//4 humerus
		addChild((short) 0, -0.3f, 1.4f, 0.0f);
		//5 radius/ulna
		addChild((short) 4, -0.3f, 0.9f, 0.0f);
		
		//right leg
		
		//6 femur
		addChild((short) 1, 0.2f, 0.5f, 0.0f);
		//7 tibia/fibula
		addChild((short) 6, 0.2f, 0.0f, 0.0f);
		
		//left leg
		
		//8 femur
		addChild((short) 1, -0.2f, 0.5f, 0.0f);
		//9 tibia/fibula
		addChild((short) 8, -0.2f, 0.0f, 0.0f);
		
		update();
		
	}
	
}
