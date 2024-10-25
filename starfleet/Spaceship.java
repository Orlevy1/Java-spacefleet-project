package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public interface Spaceship {
	
	abstract String getName();
	abstract int getCommissionYear();
	abstract float getMaximalSpeed();
	abstract int getFirePower();
	abstract Set<? extends CrewMember> getCrewMembers();
	abstract int getAnnualMaintenanceCost();

	

}
