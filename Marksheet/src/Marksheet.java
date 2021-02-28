import java.util.Scanner;

public class Marksheet {

	private float[] grades;
	private int noOfStudents;
	Scanner in = new Scanner(System.in);

	public Marksheet() {
		System.out.println("Enter total number of students: ");
		noOfStudents = in.nextInt();
		grades = new float[noOfStudents];
		System.out.println("Enter grades of " + noOfStudents + " students: ");
		for (int i = 0; i < noOfStudents; i++) {
			grades[i] = in.nextFloat();
		}
	}
	/*Displaying report of students
	 * Calculating :
	 * - average grade
	 * - max grade
	 * - min grade
	 * - result (pass/fail)
	 */

	private void displayReport() {
		float avgMarks = 0, totalMarks = 0, maxMarks = 0, minMarks = 999;

		for (int i = 0; i < noOfStudents; i++) {
			totalMarks += grades[i];
			if (grades[i] > maxMarks) {
				maxMarks = grades[i];
			}
			if (grades[i] < minMarks) {
				minMarks = grades[i];
			}
		}
		// calculating average
		try {
			avgMarks = totalMarks / noOfStudents;
		} catch (Exception e) {
			System.out.println(e);
		}

		// displaying report
		System.out.println("\nS.No" + "\t" + "Grade" + "\t" + "Result");

		for (int i = 0; i < noOfStudents; i++) {
			System.out.println((i + 1) + "\t" + grades[i] + "\t"
					+ ((grades[i] >= 40) ? "Pass" : "Fail"));
		}
		System.out.println("\nMax grade:  " + maxMarks);
		System.out.println("Min grade:  " + minMarks);
		System.out.println("Average grade:  " + avgMarks);

	}

	public static void main(String[] args) {

		Marksheet obj = new Marksheet();
		obj.displayReport();
	}

}
