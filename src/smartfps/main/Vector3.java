package smartfps.main;

public class Vector3 {
	
	public float x;
	public float y;
	public float z;
	
	public Vector3() {
		
		//nothing
		
	}
	
	public Vector3(float _x, float _y, float _z) {
		
		this.x = _x;
		this.y = _y;
		this.z = _z;
		
	}
	
	/**
	 * 
	 * Add two vectors together
	 * 
	 */
	public static Vector3 add(Vector3 vector1, Vector3 vector2) {
		
		float x = vector1.x + vector2.x;
		float y = vector1.y + vector2.y;
		float z = vector1.z + vector2.z;
		
		return new Vector3(x, y, z);
		
	}
	
	/**
	 * 
	 * Subtract two vectors
	 * 
	 */
	public static Vector3 subtract(Vector3 vector1, Vector3 vector2) {
		
		float x = vector1.x - vector2.x;
		float y = vector1.y - vector2.y;
		float z = vector1.z - vector2.z;
		
		return new Vector3(x, y, z);
		
	}
	
	/**
	 * 
	 * Get dot product of two vectors
	 * 
	 */
	public static Vector3 dot(Vector3 vector1, Vector3 vector2) {
		
		float x = vector1.x * vector2.x;
		float y = vector1.x * vector2.y;
		float z = vector1.z * vector2.z;
		
		return new Vector3(x, y, z);
		
	}
	
	/**
	 * 
	 * Get cross product of two vectors
	 *
	 */
	public static Vector3 cross(Vector3 vector1, Vector3 vector2) {
		
		float x = vector1.y * vector2.z;
		float y = vector1.z * vector2.x;
		float z = vector1.x * vector2.y;
		
		return new Vector3(x, y, z);
		
	}
	
	/**
	 * 
	 * Multiply vector by scalar
	 * 
	 */
	public static Vector3 scalar(Vector3 vector, float scalar) {
		
		float x = vector.x * scalar;
		float y = vector.y * scalar;
		float z = vector.z * scalar;
		
		return new Vector3(x, y, z);
		
	}
	
	/**
	 * 
	 * Get length of a vector
	 * 
	 */
	public static double length(Vector3 vector) {
		
		return Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2));
		
	}
	
	/**
	 * 
	 * Normalize vector (turn it into a unit vector)
	 * 
	 */
	public static Vector3 normalize(Vector3 vector) {
		
		double length = length(vector);
		
		float x = (float) (vector.x / length);
		float y = (float) (vector.y / length);
		float z = (float) (vector.z / length);
		
		return new Vector3(x, y, z);
		
	}
	
	// rotation
	public static Vector3 rotateX(int degrees, Vector3 vector) {
		
		float z = vector.z;
		float y = vector.y;
		
		float z_ = (float) ((z * Math.cos(degrees)) - (y * Math.sin(degrees)));
		float y_ = (float) ((z * Math.sin(degrees)) + (y * Math.cos(degrees)));
		
		return new Vector3(vector.x, y_, z_);
		
	}
	
	public static Vector3 rotateY(int degrees, Vector3 vector) {
		
		float z = vector.z;
		float x = vector.x;
		
		float z_ = (float) ((z * Math.cos(degrees)) - (x * Math.sin(degrees)));
		float x_ = (float) ((z * Math.sin(degrees)) + (x * Math.cos(degrees)));
		
		return new Vector3(x_, vector.y, z_);
		
	}
	
	public static Vector3 rotateZ(int degrees, Vector3 vector) {
		
		float x = vector.z;
		float y = vector.x;
		
		float x_ = (float) ((x * Math.cos(degrees)) - (y * Math.sin(degrees)));
		float y_ = (float) ((x * Math.sin(degrees)) + (y * Math.cos(degrees)));
		
		return new Vector3(x_, y_, vector.z);
		
	}
	
}
