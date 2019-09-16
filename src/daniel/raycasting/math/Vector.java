package daniel.raycasting.math;

public class Vector {
	
	public double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector fromAngle(double angle) {
		Vector vector = new Vector(Math.cos(angle), Math.sin(angle));
		vector.normalize();
		return vector;
	}
	
	public void normalize() {
		float norm = (float) Math.sqrt((double) (x * x + y * y));
		x /= norm;
		y /= norm;
	}
	
}
