package zoo;

import java.util.LinkedList;
import java.util.List;

/*
 * class for zone allocation
 * 
 */
public class Zone {

	final private CategoryEnum zoneType;
	final int uniqueZoneId;
	private boolean hasPark, hasCanteen;
	private List<Cage> cages = new LinkedList<Cage>(); // list containing cages
														// in a particular zone
	int MaxCageContaininingCapacity;

	public Zone(CategoryEnum zoneType, int MaxCageContaininingCapacity,
			boolean park, boolean canteen, int uniqueZoneId) {
		this.zoneType = zoneType;
		this.MaxCageContaininingCapacity = MaxCageContaininingCapacity;
		this.uniqueZoneId = uniqueZoneId;
		this.hasPark = park;
		this.hasCanteen = canteen;
	}

	// method used to return the zone type
	public CategoryEnum getZoneTypeName() {
		return zoneType;
	}

	// method returns already present cages count in a particular zone
	public int getCountOfCagesPresent() {
		return this.cages.size();
	}

	// method return list of cages
	public List<Cage> getCageList() {
		return cages;
	}

	// method to check if space is available in zone to add more cages
	public boolean isSpaceAvailable() {
		boolean flag = true;
		if (cages.size() == MaxCageContaininingCapacity) {
			flag = false;
		}
		return flag;
	}
}
