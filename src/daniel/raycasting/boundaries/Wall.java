package daniel.raycasting.boundaries;

import java.awt.Graphics;
import java.awt.Point;

public class Wall {
	
	public Point a, b;
	
	public Wall(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	public Wall(int x1, int y1, int x2, int y2) {
		this(new Point(x1, y1), new Point(x2, y2));
	}
	
	public void render(Graphics g) {
		g.drawLine(a.x, a.y, b.x, b.y);
	}

}
