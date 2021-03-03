package zoo;

/*
 * Factory class for creating different objects for adding animals to zoo
 * 
 */

public class AnimalObjectFactory {

	public static Animal getAnimalObject(String name, String animalType,
			int age, double weight, String typeOfSound, String habitation,
			String uniqueId) {
		Animal animal = null;
		AnimalsName animalName = null;
		for (AnimalsName value : AnimalsName.values()) {
			if (name.equalsIgnoreCase(value.name())) {
				animalName = value;
				break;
			}
		}
		switch (animalName) {
		case LION:
			animal = new Lion(name, animalType, age, weight, typeOfSound,
					habitation, uniqueId);
			break;
		case CROCODILE:
			animal = new Crocodile(name, animalType, age, weight, typeOfSound,
					habitation, uniqueId);
			break;
		case PIGEON:
			animal = new Pigeon(name, animalType, age, weight, typeOfSound,
					habitation, uniqueId);
			break;

		default:
			System.out.println("error ocurred in adding animal !");
			break;
		}
		return animal;
	}
}
