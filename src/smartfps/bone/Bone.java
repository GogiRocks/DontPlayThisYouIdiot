package smartfps.bone;

import smartfps.main.math.Vector3;

public class Bone {
	
	Vector3 _1, _2, last;
	
	Bone() {
		
		//nothing
		
	}
	
	Bone(Vector3 position1, Vector3 position2) {
		
		_1 = position1;
		_2 = position2;
		
	}
	
	void update(Bone parent) {
		
		_1 = parent._2;
		
		Vector3 distance = Vector3.subtract(_1, last);
		_2 = Vector3.add(_2, distance);
		
		last = _1;
		
	}
	
}
