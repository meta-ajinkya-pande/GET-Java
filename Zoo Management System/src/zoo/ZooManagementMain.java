package zoo;

import java.util.Scanner;

/*
 * class containing main method
 * 
 */
public class ZooManagementMain {

	// method is used to display menu options
	public static void MainPage() {
		System.out.println("----------------Zoo Management--------------  ");
		System.out.println("1. Add An Animal");
		System.out.println("2. Add Cage ");
		System.out.println("3. Add Zone");
		System.out.println("4. Remove an animal ");
		System.out.println("5. EXIT ");

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// call method for menu

		Zoo zoo = new Zoo();
//		MainPage();

		while (true) {
			MainPage();
			int choosedInput = scan.nextInt();
			switch (choosedInput) {
			case 1:
				zoo.getAnimalDetails();
				break;
			case 2:
				zoo.addCage();
				break;
			case 3:
				int status = zoo.addZone();
				if (status == 0)
					MainPage();
				break;
			case 4:
				zoo.removeAnimal();
				break;
			case 5:
				System.out.println("Okay bye !");
				System.exit(0);
			default:
				System.out.println("Invalid input !");
			}
		}

	}
}
