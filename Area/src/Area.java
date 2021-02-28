import java.util.Scanner;

public class Area {

	double area;

	/*
	 * Area of Triangle
	 * 
	 * @param width, width of Triangle
	 * 
	 * @param height, height of Triangle
	 * 
	 * @return area, calculated area of Triangle
	 */
	private double areaTriangle(double width, double height) {
		try {
			area = 0.5 * width * height;

		} catch (Exception e) {
			System.out.print(e);
		}
		return area;
	}

	/*
	 * Area of Rectangle
	 * 
	 * @param width, width of Rectangle
	 * 
	 * @param height, height of Rectangle
	 * 
	 * @return area, calculated area of Rectangle
	 */
	private double areaRectangle(double width, double height) {
		try {
			area = width * height;
		} catch (Exception e) {
			System.out.print(e);
		}
		return area;
	}

	/*
	 * Area of Square
	 * 
	 * @param width, width of Square
	 * 
	 * @param height, height of Square
	 * 
	 * @return area, calculated area of Square
	 */
	private double areaSquare(double width) {
		try {
			area = width * width;
		} catch (Exception e) {
			System.out.print(e);
		}
		return area;
	}

	/*
	 * Area of Circle
	 * 
	 * @param width, width of Circle
	 * 
	 * @param height, height of Circle
	 * 
	 * @return area, calculated area of Circle
	 */
	private double areaCircle(double radius) {
		try {
			area = 3.14 * radius * radius;
		} catch (Exception e) {
			System.out.print(e);
		}
		return area;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		double width, height, radius;
		// Triangle
		System.out.println("Enter width and height of triangle:");
		Area triangle = new Area();
		width = in.nextDouble();
		height = in.nextDouble();
		System.out.println("Area of triangle: "
				+ triangle.areaTriangle(width, height));
		// Rectangle
		System.out.println("\nEnter width and height of rectangle:");
		Area rectangle = new Area();
		width = in.nextDouble();
		height = in.nextDouble();
		System.out.println("Area of rectangle: "
				+ triangle.areaRectangle(width, height));
		// Square
		System.out.println("\nEnter width of square:");
		Area square = new Area();
		width = in.nextDouble();
		System.out.println("Area of square: " + triangle.areaSquare(width));
		// Circle
		System.out.println("\nEnter radius of circle:");
		Area circle = new Area();
		radius = in.nextDouble();
		System.out.println("Area of triangle: " + triangle.areaCircle(radius));

	}

}
