package daniel.raycasting.math;

import java.awt.Point;

import daniel.raycasting.boundaries.Wall;

public class Ray {
	
	public Point position;
	public Vector direction;
	
	public Ray(Point position, Vector direction) {
		this.position = position;
		this.direction = direction;
	}
	
	public Point getIntersection(Wall[] walls) {
		double minDistance = 10000;
		Point closestIntersect = null;
		for (Wall wall : walls) {
			Point intersect = getIntersection(wall);
			if (intersect != null) {
				double x = intersect.x, y = intersect.y;
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
		int x1 = wall.a.x, y1 = wall.a.y, x2 = wall.b.x, y2 = wall.b.y;
		int x3 = position.x, y3 = position.y, x4 = position.x + (int) (direction.x * 20000), y4 = position.y + (int) (direction.y * 20000);
		double denominator = (double) (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
		if (denominator == 0) {
			return null;
		} else {
			double t = (double) (x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4), u = -1.0d * (x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3);
			t /= denominator;
			u /= denominator;
			if (t >= 0 && t <= 1) {
				int x = x1 + (int) (t * (x2 - x1));
				int y = y1 + (int) (t * (y2 - y1));
				return new Point(x, y);
			} else {
				return null;
			}
		}
	}

}
