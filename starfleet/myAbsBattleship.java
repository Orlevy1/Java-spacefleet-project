package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myAbsBattleship extends myAbsSpaceship {
	
	protected List<Weapon> weapons;
	protected int weaponsCost;
	
	public myAbsBattleship( String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapon) {
		
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.weapons = weapon;
		setWeaponsCost();	
	

	}
	
	public List<Weapon> getWeapon(){
		
		return this.weapons;
		
	}
	
	private void setWeaponsCost() {
		for (Weapon weapon : weapons) {
			weaponsCost += weapon.getAnnualMaintenanceCost();
		}
	}
	
	public int getFirePower() {
		
		int sum = 0;
		for( Weapon weapon :weapons) {
			
			sum += weapon.getFirePower();
			
		}
		return sum + super.getFirePower();
	}
	
	public String toString() {
		String str = this.getClass().getSimpleName() + System.lineSeparator() + "\t" +
				"Name=" + this.name + System.lineSeparator() + "\t" +
				"CommissionYear=" + this.commissionYear + System.lineSeparator() + "\t" +
				"MaximalSpeed=" + this.maximalSpeed + System.lineSeparator() + "\t" +
				"FirePower=" + getFirePower() + System.lineSeparator() + "\t" +
				"CrewMembers=" + this.crewMembers.size() + System.lineSeparator() + "\t";
		return str;
	}
	
	

}
