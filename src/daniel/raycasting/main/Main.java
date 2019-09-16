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

public class Main extends JFrame implements MouseListener, MouseMotionListener {
	
	Canvas canvas = new Canvas();
	
	Point mouseLocation = new Point(10, 10);

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
		setForeground(Color.CYAN);
		setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 16));
		
		add(canvas);
		
		// Add the mouse listener for mouse inputs and mouse motion listener for mouse position
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		
		setVisible(true);
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
		
		g.dispose();
		bufferStrategy.show();
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
	}

}
