package smartfps.physics;

public enum DragCoefficient {
	
	HUMAN(1.2f),
	SPHERE(0.47);
	
	private double number;
	
	DragCoefficient(double number) {
		
		this.number = number;
		
	}
	
	public double getValue() { return number; }
	
}
