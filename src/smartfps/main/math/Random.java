package smartfps.main.math;

public class Random {
	
	public static byte randomByte(byte min, byte max) {
		
		byte range = (byte) (max - min);
		return (byte) ((Math.random() * range) + min);
		
	}
	
	public static short randomShort(short min, short max) {
		
		short range = (short) (max - min);
		return (short) ((Math.random() * range) + min);
		
	}
	
	public static int randomInt(int min, int max) {
		
		int range = max - min;
		return (int) (Math.random() * range) + min;
		
	}
	
	public static long randomLong(long min, long max) {
		
		long range = max - min;
		return (long) ((Math.random() * range) + min);
		
	}
	
	public static float randomFloat(float min, float max) {
		
		float range = max - min;
		return (float) (Math.random() * range) + min;
		
	}
	
	public static double randomDouble(double min, double max) {
		
		double range = max - min;
		return (double) (Math.random() * range) + min;
		
	}
	
}
