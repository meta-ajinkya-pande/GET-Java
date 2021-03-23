package operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * main class containing main  method
 */
public class GraphicMain {
	public static void main(String args[]) {
		List<Integer> parametersList = new ArrayList<Integer>();
		Screen screen = new Screen();
		Scanner scanner = new Scanner(System.in);
		int operationChoice = 0;
		while (operationChoice < 7) {
			Shape shape = null;
			System.out
					.println("\nSelect the operation you want to perform:");

			System.out
					.println("1. Add shape to screen\n"
							+ "2. Delete shape from screen\n"
							+ "3. Delete all shape of specific type from screen\n"
							+ "4. Get shape list in sorted order\n"
							+ "5. Get list of shapes enclosing a point\n"
							+ "6. Get list of shapes overlapping a shape\n"
							+ "7. Exit");
			operationChoice = scanner.nextInt();
			switch (operationChoice) {

			case 1:
				String uniqueId = screen.getUniqueIdGenerated();
				System.out
						.println("Enter the full name of shape type from below list:");

				for (ShapeType value : ShapeType.values()) {
					System.out.println(value.name());
				}

				String choice = scanner.next();
				ShapeType shapeSelected = null;
				for (ShapeType value : ShapeType.values()) {
					if (value.name().equalsIgnoreCase(choice)) {
						shapeSelected = value;
					}
				}
				if (shapeSelected == null) {
					System.out.println("Invalid shape entered !");
					break;
				}

				System.out.println("Enter origin coordinate:");
				System.out.print("X= ");
				int originX = scanner.nextInt();
				System.out.print("\nY= ");
				int originY = scanner.nextInt();

				Point point = new Point(originX, originY);
				parametersList.removeAll(parametersList);
				
				switch (shapeSelected) {
				case RECTANGLE:
					System.out.println("Enter the length: ");
					int length = scanner.nextInt();
					parametersList.add(length);
					System.out.println("Enter the width: ");
					int width = scanner.nextInt();
					parametersList.add(width);

					break;

				case SQUARE:
					System.out.println("Enter the side: ");
					int side = scanner.nextInt();
					parametersList.add(side);

					break;

				case CIRCLE:
					System.out.println("Enter the radius: ");
					int radius = scanner.nextInt();
					parametersList.add(radius);

					break;

				case TRIANGLE:
					System.out.println("Enter the side1: ");
					int side1 = scanner.nextInt();
					parametersList.add(side1);
					System.out.println("Enter the side2: ");
					int side2 = scanner.nextInt();
					parametersList.add(side2);
					System.out.println("Enter the side3: ");
					int side3 = scanner.nextInt();
					parametersList.add(side3);

					break;

				default:
					break;
				}
				shape = ShapeObjectFactory.createShape(shapeSelected, point,
						parametersList, uniqueId);
				screen.addShapeToScreen(shape);

				break;

			case 2:
				if (!screen.isListofShapeObjectEmpty()) {
					System.out.println("Enter unique Id of the shape:");
					String uniqueShapeId = scanner.next();
					int res = screen.deleteShapeFromScreen(uniqueShapeId);
					if (res == 1) {
						System.out.println("Deleted successfully");
					} else {
						System.out.println("Deletion unsuccessful !!");
					}
				} else {
					System.out.println("List of shape is empty");
				}
				break;

			case 3:
				if (!screen.isListofShapeObjectEmpty()) {
					System.out.println("Enter shape type: ");
					String shapeType = scanner.next();
					screen.deleteAllShapesOfSpecificType(shapeType);
				} else {
					System.out.println("List of shape is empty");
				}
				break;

			case 4:
				if (!screen.isListofShapeObjectEmpty()) {
					System.out.println("\nSorted based on area (ascending):");
					for (Shape value : screen.getSortedListOfShapesByArea()) {
						System.out.println("Shape Type : "
								+ value.getType().name());
						System.out.println("UniqueId : " + value.getUniqueId());
						System.out.println("Origin : " + value.getOrigin());
						System.out.println("Area : " + value.getArea());
						System.out.println("Perimeter : "
								+ value.getPerimeter());
						System.out
								.println("-----------------------------------------------------\n");
					}
				} else {
					System.out.println("List of shape is empty");
				}
				break;

			case 5:
				System.out.println("Enter x coordinate: ");
				int xCoordinate = scanner.nextInt();
				System.out.println("Enter Y coordinate: ");
				int yCoordinate = scanner.nextInt();

				if (!screen.isListofShapeObjectEmpty()) {
					Point point1 = new Point(xCoordinate, yCoordinate);
					List<Shape> resultList = screen
							.getListOfShapesEnclosingThePoint(point1);
					if (!resultList.isEmpty()) {
						for (Shape value : resultList) {
							System.out.println("Shape Type : "
									+ value.getType().name());
							System.out.println("UniqueId : "
									+ value.getUniqueId());
							System.out.println("Origin : " + value.getOrigin());
							System.out.println("Area : " + value.getArea());
							System.out.println("Perimeter : "
									+ value.getPerimeter());
							System.out
									.println("-----------------------------------------------------\n");
						}
					} else {
						System.out.println("No enclosed shape to this point!!");
					}
				} else {
					System.out.println("List of shape is empty");
				}
				break;

			case 6:
				if (!screen.isListofShapeObjectEmpty()) {
					System.out.println("Enter unique Id of the shape:");
					String uniqueShapeId = scanner.next();
					System.out
							.println("\nList of overlapped shape to shape ID: "
									+ uniqueShapeId);
					List<Shape> resultList = screen
							.getListOfOverlapShape(uniqueShapeId);
					if (!resultList.isEmpty()) {
						for (Shape value : resultList) {
							System.out.println("Shape Type : "
									+ value.getType().name());
							System.out.println("UniqueId : "
									+ value.getUniqueId());
							System.out.println("Origin : " + value.getOrigin());
							System.out.println("Area : " + value.getArea());
							System.out.println("Perimeter : "
									+ value.getPerimeter());
							System.out
									.println("-----------------------------------------------------\n");
						}
					} else {
						System.out.println("No overlapped shape !!");
					}
				} else {
					System.out.println("List of shape is empty");
				}
				break;

			case 7:
				System.out.println("Okay, bye!");

			default:
				break;

			}

		}
		scanner.close();
	}

}