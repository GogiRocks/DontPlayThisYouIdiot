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
	 * @param bone
	 * @param x End of bone's x
	 * @param y End of bones
	 * @param z
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

}
