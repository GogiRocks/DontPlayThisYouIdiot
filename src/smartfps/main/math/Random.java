package smartfps.main.math;

public class Random {
	
	public static int randomInt(int min, int max) {
		
		int range = max - min;
		return (int) (Math.random() * range) + min;
		
	}
	
	public static float randomFloat(float min, float max) {
		
		float range = max - min;
		return (float) (Math.random() * range) + min;
		
	}
	
}
