package smartfps.physics;

public enum DragCoefficient {
	
	HUMAN(1.2f),
	SPHERE(0.47);
	
	@SuppressWarnings("unused")
	private double number;
	
	DragCoefficient(double number) {
		
		this.number = number;
		
	}
	
}
