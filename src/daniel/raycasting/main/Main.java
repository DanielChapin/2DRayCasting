package daniel.raycasting.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import daniel.raycasting.boundaries.Wall;
import daniel.raycasting.math.Ray;
import daniel.raycasting.math.Vector;

public class Main extends JFrame implements MouseListener, MouseMotionListener {
	
	Canvas canvas = new Canvas();
	
	Point mouseLocation = new Point(10, 10);
	
	Ray[] rays = new Ray[2];
	Wall[] walls = new Wall[5];

	public static void main(String[] args) {
		new Main();
	}
	
	Main() {
		// Setup the JFrame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Light");
		setBackground(Color.BLACK);
		setForeground(Color.getHSBColor(0f, 0f, 0.85f));
		setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
		
		add(canvas);
		
		// Add the mouse listener for mouse inputs and mouse motion listener for mouse position
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		
		setVisible(true);
		
		mouseLocation = getRandomPoint();
		for (int i = 0; i < rays.length; i++) {
			double a = 2 * Math.PI * ((double) i / rays.length);
			rays[i] = new Ray(mouseLocation, Vector.fromAngle(a));
		}
		walls = new Wall[walls.length + 4];
		walls[0] = getBorderWall(0, 0, 1, 0);
		walls[1] = getBorderWall(1, 0, 1, 1);
		walls[2] = getBorderWall(1, 1, 0, 1);
		walls[3] = getBorderWall(0, 1, 0, 0);
		for (int i = 4; i < walls.length; i++)
			walls[i] = new Wall(getRandomPoint(), getRandomPoint());
		
		canvas.createBufferStrategy(3);
		startRendering();
	}
	
	void startRendering() {
		long now = System.nanoTime(), lastLoop = now, loopTime = 1000000000 / 30;
		while (true) {
			if ((now = System.nanoTime()) - lastLoop >= loopTime) {
				render();
				lastLoop = now;
			}
		}
	}
	
	void render() {
		// Get the current buffer of the canvas
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics g = bufferStrategy.getDrawGraphics();
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(getForeground());
		for (Ray r : rays) {
//			g.drawLine(mouseLocation.x, mouseLocation.y, mouseLocation.x + (int) (r.direction.x * 200), mouseLocation.y + (int) (r.direction.y * 200));
			Point intersect = r.getIntersection(walls);
			g.drawLine(r.position.x, r.position.y, intersect.x, intersect.y);
		}
		for (Wall w : walls)
			w.render(g);
		g.dispose();
		bufferStrategy.show();
	}
	
	Point getRandomPoint() {
		return new Point((int) (Math.random() * canvas.getWidth()), (int) (Math.random() * canvas.getHeight()));
	}
	
	Wall getBorderWall(int x1, int y1, int x2, int y2) {
		int width = canvas.getWidth() - 1, height = canvas.getHeight() - 1;
		return new Wall(x1 * width, y1 * height, x2 * width, y2 * height);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseLocation = e.getPoint();
		for (Ray r : rays) 
			r.position = mouseLocation;
	}

}
