package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class myComparator implements Comparator<Spaceship> {
	
	@Override
	public int compare(Spaceship s1, Spaceship s2) {
		if (s1.getFirePower() == s2.getFirePower()) { 
			if (s1.getCommissionYear() == s2.getCommissionYear()) 
				return s1.getName().compareTo(s2.getName()); 
			return Integer.compare(s2.getCommissionYear(), s1.getCommissionYear()); 
		} 
		return Integer.compare(s2.getFirePower(), s1.getFirePower());
	}

}
