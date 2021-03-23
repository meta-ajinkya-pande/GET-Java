package zoo;

import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * class contains the methods related to zoo management
 */
public class Zoo {

	private int uidZone = 1, uidCage = 1;
	private boolean zoneFlag = false, cageFlag = false;

	/* map containing information of all zones in zoo */
	Map<Integer, Zone> zoneMap = new LinkedHashMap<Integer, Zone>();
	/* map containing information of all cages in zoo */
	Map<Integer, Cage> cageMap = new LinkedHashMap<Integer, Cage>();
	/* map containing information of all animals in zoo */
	Map<String, Animal> animalMap = new LinkedHashMap<String, Animal>();

	private Scanner scanner = new Scanner(System.in);

	// method is used to get details of the animal to be added
	public void getAnimalDetails() {
		if (zoneFlag == true && cageFlag == true) {
			int indexNumber = 1;
			System.out.println("Enter animal Name(FULL NAME) from below list:");
			System.out.println("index\t\tNames\n");

			for (AnimalsName value : AnimalsName.values()) {
				System.out.println(indexNumber + "\t\t" + value.name());
				indexNumber++;
			}
			System.out.println();

			String name = scanner.next();
			for (AnimalsName value : AnimalsName.values()) {

				if (name.equalsIgnoreCase(value.name())) {
					name = value.name();
					break;
				}
			}
			indexNumber = 1;
			System.out.println("Enter animal category(FULL NAME) from list:\n");
			System.out.println("index\t\tCategory\n");
			for (CategoryEnum value : CategoryEnum.values()) {
				System.out.println(indexNumber + "\t\t" + value.name());
				indexNumber++;
			}
			System.out.println();
			String animalCategory = scanner.next();

			for (CategoryEnum value : CategoryEnum.values()) {
				if (animalCategory.equalsIgnoreCase(value.name())) {
					animalCategory = value.name();
					break;
				}
			}
			System.out.println("Enter age of the animal:");
			int ageOfAnimal = scanner.nextInt();
			System.out.println("Enter the weight of the animal:");
			double weight = scanner.nextDouble();
			System.out
					.println("Enter the type of sound animal make (eg. Lion Roars):");
			String soundOfAnimal = scanner.next();
			String animalUniqueId = uniqueIdGenerator();
			System.out
					.println("Enter the suitable habitation of the animal:(eg. Lion lives on land)");
			String habitation = scanner.next();

			Animal newAnimal = AnimalObjectFactory.getAnimalObject(name,
					animalCategory, ageOfAnimal, weight, soundOfAnimal,
					habitation, animalUniqueId);
			int status = addAnimal(newAnimal);
			if (status == 1) {
				System.out.println("Animal get added !");
			}
		} else {
			System.out
					.println("There is no zone or cage present in the zoo. Please add a zone and cage first!");
		}

	}

	/*
	 * method adds the animal in the cage of the zone
	 * 
	 * @param animal object
	 * 
	 * @return 1 if animal is added successfully else return 0
	 */
	public int addAnimal(Animal animal) {
		System.out
				.println("Enter the zone Id in which you want to add this animal:");
		int zoneId = scanner.nextInt();
		int indexTraversed = 0;
		Zone zone = zoneMap.get(zoneId);
		if (zone != null) {

			List<Cage> cagesList = zone.getCageList();
			try {
				for (Cage cage : cagesList) {
					indexTraversed++;
					if (cage.getTypeOfAnimalInCage().equalsIgnoreCase(
							animal.name)
							&& cage.isSpaceAvailable()) {
						cage.animalList.add(animal);
						animalMap.put(animal.uniqueIdForAnimal, animal);
						System.out
								.println("Animal added successfully in cage with cage Id"
										+ cage.getCageId()
										+ ".\nPlease note the Id of this animal which is "
										+ animal.uniqueIdForAnimal);
						break;
					} else {
						if (indexTraversed == cagesList.size()) {
							if (zone.isSpaceAvailable()) {
								System.out
										.println("System is adding a new cage for this animal as there is no capacity in existing cages !");
								Cage cage1 = new Cage(animal.animalType, 5,
										uidCage);
								uidCage++;
								zone.getCageList().add(cage1); // a new cage is
																// created and
																// added in the
																// cage list of
																// the zone
								cageMap.put(uidCage, cage1); // cageMap is
																// updated with
																// newly created
																// cage
								cage1.animalList.add(animal);
								animalMap.put(animal.uniqueIdForAnimal, animal);
								System.out
										.println("Animal added successFully. \nPlease note animal Id: "
												+ animal.uniqueIdForAnimal
												+ " and cage Id: "
												+ cage1.getCageId());

							} else {
								System.out
										.println("No more animals can be added !");
								return 0;
							}
						}
					}
				}
			} catch (ConcurrentModificationException e) {

			}
		} else {
			System.out.println("error in adding this animal");
			return 0;
		}

		return 1;
	}

	/*
	 * method to remove animal from zoo
	 */
	public int removeAnimal() {
		System.out.println("Enter animal id: ");
		String animalId = scanner.next();
		Animal animalObj = animalMap.get(animalId);
		if (animalObj != null) {
			System.out.println("Enter cage id in which animal is there: ");
			int cageId = scanner.nextInt();
			Cage cage = cageMap.get(cageId);
			if (cage != null) {
				List<Animal> listOfanimals = cage.animalList;
				for (Animal animal : listOfanimals) {
					if (animal.uniqueIdForAnimal.equals(animalId)) {
						cage.animalList.remove(animal);
						animalMap.remove(animal.uniqueIdForAnimal);

					}
				}
			} else {
				System.out.println("Incorrect cageId");
				return 0;
			}
		}

		else {
			System.out.println("Incorrect animal Id");
			return 0;
		}
		return 1;
	}

	/*
	 * method is used to add new zone to the zoo
	 * 
	 * @return 1 if zone created successfully as 0
	 */
	public int addZone() {
		zoneFlag = true;
		System.out.println("Please Select Zone Type");
		System.out.println("1.Mammals \n2.Reptiles\n3.Birds");
		CategoryEnum zoneType;
		boolean hasPark = false, hasCanteen = false;

		switch (scanner.nextInt()) {
		case 1:
			zoneType = CategoryEnum.Mammals;
			break;
		case 2:
			zoneType = CategoryEnum.Reptiles;
			break;
		case 3:
			zoneType = CategoryEnum.Birds;
			break;

		default:
			System.out.println("invaild Zone Type ");
			return 0;
		}
		Zone zone = null;
		System.out
				.println("Enter No. Of cages to be stored in this zone (Maximum capacity of cage of the zone): ");
		int maxCageStoringCapacityOfZone = scanner.nextInt();
		System.out
				.println("Does this zone have a Park ?\n(enter 'y' for Yes and 'n' for No)");
		char choice = scanner.next().charAt(0);
		if (choice == 'y' || choice == 'Y') {
			hasPark = true;
		}

		System.out
				.println("Does this zone have a Canteen ?\n(enter 'y' for Yes and 'n' for No)");
		choice = scanner.next().charAt(0);
		if (choice == 'y' || choice == 'Y') {
			hasCanteen = true;
		}

		zone = new Zone(zoneType, maxCageStoringCapacityOfZone, hasPark,
				hasCanteen, uidZone); // zone object created and alloted as
										// newly created zone
		zoneMap.put(uidZone, zone);
		System.out.println("Zone Added Successfully with id: " + uidZone
				+ "\nPlease note the zone Id for further operations !");
		uidZone++;
		return 1;
	}

	// method is used to add a new cage in the zone
	public void addCage() {
		if (zoneFlag == true) {
			cageFlag = true;
			System.out
					.println("Please Enter Zone Id:\n(Id generated at the time of zone creation !)");
			Zone zone = zoneMap.get(scanner.nextInt()); // obtaining zone
														// information in which
														// cage is to be created

			if (zone == null) {
				System.out
						.println("Zone Not Found !(May be Id of zone entered is incorrect. If you don't know correct Id you may press 0 to return to menu.)");
				if (scanner.nextInt() == 0) {
					ZooManagementMain.MainPage();
				} else {
					addCage();
				}
			} else {
				if (zone.getCountOfCagesPresent() == zone.MaxCageContaininingCapacity) {
					System.out.println("No space For adding More Cages.");
				} else {

					System.out
							.println("Please Enter Animal Type For Cage (eg. lion, crocodile, pigeon)");
					String animalTypeForCage = scanner.next();

					System.out.println("Please Enter capacity of this cage:");
					int cageCapacity = scanner.nextInt();

					Cage cage = new Cage(animalTypeForCage, cageCapacity,
							uidCage);
					zone.getCageList().add(cage); // a new cage is created and
													// added in the cage list of
													// the zone
					cageMap.put(uidCage, cage); // cageMap is updated with newly
												// created cage

					System.out
							.println("Cage Successfully Added Unique id Of Cage is "
									+ uidCage
									+ "\nPlease note the cage Id for finding cage easily !)");
					uidCage++;
				}
			}
		} else {
			System.out.println("No zone is there. please create a zone first!");
		}

	}

	// method generates unique id to be assigned to animals
	private String uniqueIdGenerator() {
		String uniqueId = "animal";
		for (int i = 1; i <= 3; i++) {
			uniqueId = uniqueId + String.valueOf((int) (Math.random() * 10));
		}
		return uniqueId;
	}

}
