package daniel.raycasting.math;

import java.awt.Point;

import daniel.raycasting.boundaries.Wall;

public class Vector {
	
	public double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector fromAngle(double angle) {
		return new Vector(Math.cos(angle), Math.sin(angle));
	}
	
	public void normalize() {
		float norm = (float) Math.sqrt((double) (x * x + y * y));
		x /= norm;
		y /= norm;
	}
	
	public Point getIntersection(Wall[] walls) {
		for (Wall w : walls)
			System.out.println(w.a);
		return null;
	}
	
}
