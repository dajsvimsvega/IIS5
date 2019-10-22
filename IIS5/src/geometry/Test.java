package geometry;

public class Test {

	public static void main(String[] args) {
		
		Point p = new Point();
		p.setX(10);
		p.setY(20);
		p.setSelected(true);

		System.out.println("X coordinate of point p is: " + p.getX() + '\n' +
									"Y coordinate of point p is: " + p.getY() + '\n' +
									"Point p is selected: " + p.isSelected());
		
		double rez = p.distance(30, 50);
		System.out.println("Distance between points = " + rez);
		
	}

}
