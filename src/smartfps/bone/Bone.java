package smartfps.bone;

public class Bone {
	
	float x1, y1, z1, x2, y2, z2;
	
	void update(Bone parent) {
		
		this.x1 = parent.x2;
		this.y1 = parent.y2;
		this.z1 = parent.z2;
		
	}
	
}
