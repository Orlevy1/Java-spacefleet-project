package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class myAbsCrewMember implements CrewMember{
	
	protected String name;
	protected int age;
	protected int yearsInService;
	
	
	public myAbsCrewMember(int age, int yearsInService,String name ){
		
		this.age = age;
		this.yearsInService = yearsInService;
		this.name = name;

	}
	
	
	@Override
	public String getName() {
		
		return name;
		
	}
	
	@Override
	public int getAge() {
		
		return age;
		
	}
	
	@Override
	public int getYearsInService() {
		
		return yearsInService;
		
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
		myAbsCrewMember other = (myAbsCrewMember) o; 
		if(!name.equals(other.name))
			return false;
		return true;	
	}
}
	
	


