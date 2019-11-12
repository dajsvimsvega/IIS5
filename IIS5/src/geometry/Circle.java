package geometry;

public class Circle {

	private Point center;
	private int radius;
	private boolean selected;
	
	public Circle() {

	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public boolean contains(int x, int y) {
		return this.center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point p) {
		return this.center.distance(p.getX(), p.getY()) <= radius;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle prosledjen = (Circle)obj;
			if (this.center.equals(prosledjen.getCenter()) && this.radius == prosledjen.getRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return "Center=" + center + ", radius=" + radius;
	}
	
}
