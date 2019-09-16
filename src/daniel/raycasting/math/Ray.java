package daniel.raycasting.math;

import java.awt.Point;

import daniel.raycasting.boundaries.Wall;

public class Ray {
	
	Point position;
	Vector direction;
	
	public Ray(Point position, Vector direction) {
		this.position = position;
		this.direction = direction;
	}
	
	public Point getIntersection(Wall[] walls) {
		double minDistance = 0;
		Point closestIntersect = null;
		for (Wall wall : walls) {
			Point intersect = getIntersection(wall);
			double x = intersect.x, y = intersect.y;
			if (intersect != null) {
				double distance = Math.sqrt(x * x + y * y);
				if (distance < minDistance) {
					minDistance = distance;
					closestIntersect = intersect;
				}
			}
		}
		return closestIntersect;
	}
	
	public Point getIntersection(Wall wall) {
		
	}

}
