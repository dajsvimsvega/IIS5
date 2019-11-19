package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics g) {
		
		Point p = new Point(100, 100, false, Color.BLACK);
		p.draw(g);
		
		Point p1 = new Point(60, 60, true);
		p1.draw(g);
		
		Line l = new Line(new Point(200, 240), new Point(400, 500), false, Color.RED);
		l.draw(g);
		
		Line l1 = new Line(new Point(350, 400), new Point(500, 600), true, Color.BLACK);
		l1.draw(g);
		
	}
	
	

}
