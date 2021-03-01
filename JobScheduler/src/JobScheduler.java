import java.util.Scanner;

public class JobScheduler {

	private int noOfJob, noOfTimes = 2, i, j;
	private int[][] arr;
	private int[] waitingTime;
	private int[] completionTime;
	private int[] turnAroundTime;
	Scanner input = new Scanner(System.in);

	private void inputJobs() {
		System.out.println("Enter number of jobs: ");
		noOfJob = input.nextInt();
		arr = new int[noOfJob][noOfTimes];
		// Input jobs
		for (i = 0; i < noOfJob; i++) {
			System.out.println("Enter arrival and burst time of job : "
					+ (i + 1));
			for (j = 0; j < noOfTimes; j++) {
				arr[i][j] = input.nextInt();
			}
		}
	}

	private void outputJobs() {
		for (i = 0; i < noOfJob; i++) {
			for (j = 0; j < noOfTimes; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println("\n");
		}

	}

	private void calcCompletion() {
		completionTime = new int[noOfJob];
		completionTime[0] = arr[0][1] - arr[0][0];
		for (i = 1; i < noOfJob; i++) {
			if (arr[i][0] > (arr[i - 1][0] + arr[i - 1][1])) {
				completionTime[i] = arr[i][0] + arr[i][1];
			} else {
				completionTime[i] = completionTime[i - 1] + arr[i][1];
			}
		}
	}

	private void calcTurnAround() {
		turnAroundTime = new int[noOfJob];
		for (i = 0; i < noOfJob; i++) {
			turnAroundTime[i] = completionTime[i] - arr[i][0];
		}
	}

	private void calcWaiting() {
		waitingTime = new int[noOfJob];
		for (i = 0; i < noOfJob; i++) {
			waitingTime[i] = turnAroundTime[i] - arr[i][1];
		}
	}

	private void avgWaiting(String s, int[] arr) {
		float avgW = 0, totalWaiting = 0;
		for (i = 0; i < noOfJob; i++) {
			totalWaiting += arr[i];
		}
		avgW = totalWaiting / noOfJob;
		System.out.println("\nAverage " + s + " time of processes is: "
				+ String.format("%.02f", avgW));
	}

	private void maxArr(String s, int[] arr) {
		int i;
		int max = arr[0];
		for (i = 1; i < noOfJob; i++)
			if (arr[i] > max)
				max = arr[i];
		System.out.println("\nMaximum " + s + " time of processes is: " + max);
	}

	private void printTimes(String s, int[] arr) {
		System.out.println(s + " Time of processes are:");
		for (i = 0; i < noOfJob; i++) {
			System.out.println("P" + (i + 1) + " = " + arr[i]);
		}
	}

	public static void main(String[] args) {
		JobScheduler obj = new JobScheduler();
		// input jobs
		obj.inputJobs();
		// output jobs
		obj.outputJobs();
		// completion
		obj.calcCompletion();
		obj.printTimes("Completion", obj.completionTime);
		// turnAround
		obj.calcTurnAround();
		obj.printTimes("Turn Around", obj.turnAroundTime);
		// waiting
		obj.calcWaiting();
		obj.printTimes("Waiting", obj.waitingTime);

		// average waiting
		obj.avgWaiting("waiting", obj.waitingTime);
		// maximum waiting
		obj.maxArr("waiting", obj.waitingTime);
	}

}
