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
		
		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);
		
		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1
		p.setX(p1.getY());
		System.out.println("X of p1 = " + p.getX());
		
		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1
		
		Line l1 = new Line();
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		
		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		
		l1.getEndPoint().setY(23);
		System.out.println("Y of end point of line l1 is " + l1.getEndPoint().getY());
		
		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println("x of start point of l1 is " + l1.getStartPoint().getX());
		
		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		
		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));
		System.out.println("x of end point of l1 is " + l1.getEndPoint().getX());
		
		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		
		Rectangle r1 = new Rectangle();
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("X of upper left point of r1 is " + r1.getUpperLeftPoint().getX() + '\n'
				+ "Y of upper left point of r1 is " + r1.getUpperLeftPoint().getY());
		
		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		
		Circle c1 = new Circle();
		c1.setCenter(r1.getUpperLeftPoint());
		
		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		
		r1.setHeight(20);
		r1.setWidth(30);
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println("X of center of c1 = " + c1.getCenter().getX());
		
		Point p2 = new Point(20, 30);
		Line l2 = new Line(p1, new Point(100, 200), true);
		
		System.out.println(p2.toString());
		System.out.println(l2.toString());
		c1.setRadius(34);
		System.out.println(c1.toString());
		System.out.println(r1.toString());
		
		Point p4 = new Point(10, 20);
		Point p5 = new Point(10, 20);
		
		System.out.println(p4 == p5); // false
		
		System.out.println(p4.equals(p5)); // true
		System.out.println(p4.equals(r1)); // false
		System.out.println(p4.equals(p)); // false
		
		String s = "Hello";
		String s1 = "Hello";
		
		System.out.println(s == s1); // true
		
		String s2 = new String("Hello");
		String s3 = new String("Hello");
		
		System.out.println(s2 == s3);
		System.out.println(s2.equals(s3));
		
		System.out.println(r1.contains(500, 600));
		System.out.println(r1.contains(p));
		
	}

}
