package zoo;

import java.util.LinkedList;
import java.util.List;

/*
 * class representing cage for animals
 */
public class Cage {

	List<Animal> animalList = new LinkedList<Animal>(); // List containing
														// animals object i.e.
														// animals

	final private int maxCapacity; // Maximum capacity of cage to contain
									// animals

	private String typeOfAnimalInCage; // Type of animal that can be put inside
										// the cage

	final private int uniqueIdOfCage;

	public Cage(String animalTypeInCage, int maxCapacity, int uniqueIdOfCage) {
		this.typeOfAnimalInCage = animalTypeInCage;
		this.maxCapacity = maxCapacity;
		this.uniqueIdOfCage = uniqueIdOfCage;
	}

	// method to return the no. of animals in a cage
	public int getAnimalCountInCage() {
		return animalList.size();
	}

	// method returns the maximum capacity of the cage
	public int getMaxCapacity() {
		return maxCapacity;
	}

	/*
	 * method checks for remaining space available in cage
	 * 
	 * @return true if space is available else return false
	 */
	public boolean isSpaceAvailable() {
		return (maxCapacity > animalList.size());
	}

	// return unique id of the cage
	public int getCageId() {
		return uniqueIdOfCage;
	}

	public String getTypeOfAnimalInCage() {
		return typeOfAnimalInCage;
	}

}