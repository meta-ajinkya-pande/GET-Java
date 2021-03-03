package zoo;

/*
 * class containing attributes of pigeon
 * 
 */
public class Pigeon extends Birds {
	public Pigeon(String name, String animalType, int age, double weight,
			String typeOfSound, String habitation, String uniqueIdForPegion) {
		this.name = name;
		this.animalType = animalType;
		this.age = age;
		this.weight = weight;
		this.sound = typeOfSound;
		this.habitation = habitation;
		this.typeOfBird = "herbivour";
		this.uniqueIdForAnimal = uniqueIdForPegion;
	}

	@Override
	public String getAnimalSound() {
		return sound;
	}
}
