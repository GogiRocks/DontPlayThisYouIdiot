package smartfps.bone;

public class Bone {
	
	float x1, y1, z1, x2, y2, z2, lastx, lasty, lastz;
	
	Bone() {
		
		//nothing
		
	}
	
	Bone(float x_1, float y_1, float z_1, float x_2, float y_2, float z_2) {
		
		x1 = x_1;
		y1 = y_1;
		z1 = z_1;
		
		x2 = x_2;
		y2 = y_2;
		z2 = z_2;
		
	}
	
	void update(Bone parent) {
		
		this.x1 = parent.x2;
		this.y1 = parent.y2;
		this.z1 = parent.z2;
		
		float distancex = this.x1 - this.lastx;
		float distancey = this.y1 - this.lasty;
		float distancez = this.z1 - this.lastz;
		
		this.x2 += distancex;
		this.y2 += distancey;
		this.z2 += distancez;
		
		this.lastx = this.x1;
		this.lasty = this.y1;
		this.lastz = this.z1;
		
	}
	
}
