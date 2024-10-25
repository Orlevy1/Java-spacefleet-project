package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbsBattleship {
	

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int engineCost = (int)(this.maximalSpeed * 1000);
		return weaponsCost + engineCost + 2500;
	}
	
	public String toString() {
		String str = super.toString() + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost() + System.lineSeparator() + "\t" +
				"WeaponArray=" + this.weapons;
		return str;
	}

}
