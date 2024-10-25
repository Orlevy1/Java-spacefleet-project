package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbsSpaceship{
	
	private int cargoCapacity;
	private int passengerCapacity;
	

	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
		
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return (this.cargoCapacity * 5) + (this.passengerCapacity * 3) + 3000;
	}
	
	public String toString() {
		String str = this.getClass().getSimpleName() + System.lineSeparator() + "\t" +
				"Name=" + this.name + System.lineSeparator() + "\t" +
				"CommissionYear=" + this.commissionYear + System.lineSeparator() + "\t" +
				"MaximalSpeed=" + this.maximalSpeed + System.lineSeparator() + "\t" +
				"FirePower=" + getFirePower() + System.lineSeparator() + "\t" +
				"CrewMembers=" + this.crewMembers.size() + System.lineSeparator() + "\t" + 
				"AnnualMaintenanceCost=" + getAnnualMaintenanceCost() + System.lineSeparator() + "\t" +
				"CargoCapacity=" + this.cargoCapacity + System.lineSeparator() + "\t" +
				"PassengerCapacity=" + this.passengerCapacity;		
		return str;
	}

}
