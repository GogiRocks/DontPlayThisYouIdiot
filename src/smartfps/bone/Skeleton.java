package smartfps.bone;

import smartfps.main.math.Vector3;

public class Skeleton {
	
	int bonesNum;
	
	int[] parentNum;
	Bone[] bones;
	
	public void root(Bone bone) {
		
		bones[0] = bone;
		
	}
	
	/**
	 * 
	 * Add a child bone 
	 * 
	 * @param bone Parent index
	 * @param position Vector3 of positional value
	 */
	public void addChild(short bone, Vector3 position) {
		
		bonesNum++;
		
		bones[bonesNum] = new Bone();
		parentNum[bonesNum] = bone;
		
		bones[bonesNum]._1 = bones[parentNum[bone]]._2;
		bones[bonesNum]._2 = position;
		
	}
	
	public void update() {
		
		for(int i = 1; i == bonesNum; i++) {
			
			bones[i].update(bones[parentNum[i]]);
			
		}
		
	}
	
	public void changeBone(short bone, Vector3 change) {
		
		bones[bone]._2 = Vector3.add(bones[bone]._2, change);
		
	}

}
