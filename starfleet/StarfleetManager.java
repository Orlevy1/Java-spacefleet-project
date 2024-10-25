package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List <Spaceship> list = (List<Spaceship>)fleet;
		Collections.sort(list,new myComparator());
		List <String> res = new ArrayList <>();
		for(Spaceship ship : list) {
			res.add(ship.toString());
		}
		return res;	
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String,Integer> res = new HashMap<>();
		for (Spaceship ship : fleet) {
			String name = ship.getClass().getSimpleName();
			if (res.containsKey(name)) {
				res.put(name, res.get(name)+1);
			}
			else {
				res.put(name, 1);
			}
		}
		return res;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum = 0;
		for(Spaceship ship: fleet) {
			sum += ship.getAnnualMaintenanceCost();
		}
		return sum;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String>names = new HashSet<>();
		for(Spaceship ship: fleet) {
			if(ship instanceof myAbsBattleship) {
				myAbsBattleship battleship = (myAbsBattleship)ship;
				for(Weapon weapon : battleship.getWeapon()) {
					names.add(weapon.getName());
				}
				
			}
		}

		return names;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		
		int sum = 0;
		for(Spaceship ship: fleet) {
			sum += ship.getCrewMembers().size();
		}
		return sum;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int totalOfficers = 0;
		int age = 0;
		for(Spaceship ship: fleet) {
			for(CrewMember member : ship.getCrewMembers() ) {
				if (member instanceof Officer) {
				age += member.getAge();
				totalOfficers++;
				}
			}	
		}
		return age/totalOfficers;	
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> res = new HashMap<>();
		for(Spaceship ship: fleet) {
			OfficerRank highestRank = null;
			Officer highestOfficer = null;
			for(CrewMember member : ship.getCrewMembers() ) {
				if (member instanceof Officer) {
					OfficerRank rank = ((Officer) member).getRank();
					if (highestRank == null || highestRank.compareTo(rank) < 0) {
						highestRank = rank;
						highestOfficer = (Officer)member;
					}	
				}
			}
			if (highestOfficer != null) {
				res.put(highestOfficer, ship);
			}	
		}
		
		return res;
	}
	
	

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> map = new HashMap<>();
		for(Spaceship ship: fleet) {
			for(CrewMember member : ship.getCrewMembers() ) {
				if (member instanceof Officer) {
					OfficerRank rank = ((Officer) member).getRank();
					if (map.containsKey(rank)) {
						map.put(rank, map.get(rank)+1);
					}
					else {
						map.put(rank, 1);
					}
				}	
			}
		}
		List<Map.Entry<OfficerRank, Integer>> res = new ArrayList<>(map.entrySet());
		Collections.sort(res, new rankComparator());
		return res;
				
	}
	public static class rankComparator implements Comparator <Map.Entry<OfficerRank, Integer>> {
		public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {
			if (o1.getValue() == o2.getValue()) {
				return o1.getKey().compareTo(o2.getKey());
			}
			else {
				return o1.getValue().compareTo(o2.getValue());	
			}
		
		}
	}

}
