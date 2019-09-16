package daniel.raycasting.math;

public class Vector {
	
	float x, y;
	
	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void normalize() {
		float norm = (float) Math.sqrt((double) (x * x + y * y));
		x /= norm;
		y /= norm;
	}

}
