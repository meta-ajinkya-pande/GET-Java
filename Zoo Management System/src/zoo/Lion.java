package zoo;

/*
 * class containing attributes of lion
 * 
 */
public class Lion extends Mammals {

	public Lion(String name, String animalType, int age, double weight,
			String typeOfSound, String habitation, String uniqueIdForLion) {
		this.name = name;
		this.animalType = animalType;
		this.age = age;
		this.weight = weight;
		this.sound = typeOfSound;
		this.habitation = habitation;
		this.furColor = "safron";
		this.typeOfMammal = "carnivour";
		this.uniqueIdForAnimal = uniqueIdForLion;
	}

	@Override
	public String getAnimalSound() {
		return sound;
	}

}