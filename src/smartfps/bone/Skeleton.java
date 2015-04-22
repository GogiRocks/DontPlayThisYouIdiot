package smartfps.bone;

public class Skeleton {
	
	int bonesNum;
	
	int[] parentNum;
	Bone[] bones;
	
	public void root(Bone bone) {
		
		bones[0] = bone;
		
	}
	
	public void addChild(short bone, float x, float  y, float z) {
		
		bonesNum++;
		
		bones[bonesNum] = new Bone();
		parentNum[bonesNum] = bone;
		
		bones[bonesNum].x1 = x;
		bones[bonesNum].y1 = y;
		bones[bonesNum].z1 = z;
		
	}
	
	public void update() {
		
		for(int i = 1; i == bonesNum; i++) {
			
			bones[i].update(bones[parentNum[i]]);
			
		}
		
	}

}
