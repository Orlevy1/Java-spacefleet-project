package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbsBattleship{
	
	private int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	
	}
	

	public int getnumberOfTechnicians() {
		return numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		double discount = 1 - (this.numberOfTechnicians/10.0);
		int weaponCost = (int)(this.weaponsCost * discount);
		return weaponCost + 5000;
	}
	
	public String toString() {
		String str = super.toString() + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost() + System.lineSeparator() + "\t" +
				"WeaponArray=" + this.weapons + System.lineSeparator() + "\t" +
				"NumberOfTechnicians=" + this.numberOfTechnicians;
		return str;
	}
	

}
