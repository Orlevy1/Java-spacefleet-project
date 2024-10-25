package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class myAbsSpaceship implements Spaceship {
	
	protected String name;
	protected int commissionYear;
	protected float maximalSpeed;
	protected int firePower;
	protected Set<? extends CrewMember> crewMembers;
	protected int annualMaintenanceCost;
	

	public myAbsSpaceship(String name, int commissionYear,float maximalSpeed,  Set<? extends CrewMember> crewMembers){
		
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
		
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int getCommissionYear() {
		
		return this.commissionYear;
	}
	
    public float getMaximalSpeed() {
		
		return this.maximalSpeed;
	}
	
    public int getFirePower() {
		
		return 10;
	}
	
	public Set<? extends CrewMember> getCrewMembers(){
		
		return this.crewMembers;
		
	}
	

	public int hashCode() {
		final int prime = 31;
		int res = 1;
		res = prime * res + this.name.hashCode();
		return res;
	}

	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		myAbsSpaceship other = (myAbsSpaceship) o; 
		if(!name.equals(other.name))
			return false;
		return true;	
	}	
	

}
