package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myAbsBattleship  {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		
		int crewCost = this.crewMembers.size() * 500;
		int engineCost = (int)(this.maximalSpeed * 1200);
		return this.weaponsCost + crewCost + engineCost + 3500;
	}
	
	public String toString() {
		String s = super.toString() + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost() + System.lineSeparator() + "\t" +
				"WeaponArray=" + this.weapons;
		return s;
	}

	

}
