package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;

import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {
	
	public static int numOfStealthCruisers;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		numOfStealthCruisers++;
		
		
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		
		this(name, commissionYear, maximalSpeed, crewMembers,Arrays.asList(new Weapon("Laser Cannons",10,100)));
		
		
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + (numOfStealthCruisers*50);
	}
	
	public String toString() {
		String str = this.getClass().getSimpleName() + System.lineSeparator() + "\t" +
				"Name=" + this.name + System.lineSeparator() + "\t" +
				"CommissionYear=" + this.commissionYear + System.lineSeparator() + "\t" +
				"MaximalSpeed=" + this.maximalSpeed + System.lineSeparator() + "\t" +
				"FirePower=" + getFirePower() + System.lineSeparator() + "\t" +
				"CrewMembers=" + this.crewMembers.size() + System.lineSeparator() + "\t" +
				"AnnualMaintenanceCost=" + getAnnualMaintenanceCost() + System.lineSeparator() + "\t" +
				"WeaponArray=" + this.weapons;
		return str;
	}

	
}
