package geometry;

public class Rectangle {

	private int height;
	private int width;
	private Point upperLeftPoint;
	private boolean selected;
	
	public Rectangle() {

	}
	
	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint, height, width);
		this.selected = selected;
	}
	
	public int area() {
		return height * width;
	}
	
	public boolean contains(int x, int y) {
		if (upperLeftPoint.getX() <= x &&
				this.getUpperLeftPoint().getY() <= y &&
				x <= this.getUpperLeftPoint().getX() + width &&
				y <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Point p) {
		if (upperLeftPoint.getX() <= p.getX() &&
				this.getUpperLeftPoint().getY() <= p.getY() &&
				p.getX() <= this.getUpperLeftPoint().getX() + width &&
				p.getY() <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle prosledjen = (Rectangle)obj;
			if (this.upperLeftPoint.equals(prosledjen.getUpperLeftPoint()) 
					&& this.height == prosledjen.getHeight() && this.width == prosledjen.getWidth()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return "Upper left point=" + upperLeftPoint + ", width=" + width + ", height=" + height;
	}
	
	
}
