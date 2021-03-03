package operations;

/*
 * Interface containing attributes of shapes
 * 
 */

public interface Shape {

	public double getArea();

	public double getPerimeter();

	public String getOrigin();

	public ShapeType getType();

	public boolean isPointEnclosed(Point point);

	public String getUniqueId();
}