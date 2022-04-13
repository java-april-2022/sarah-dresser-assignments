
public class Gorilla extends Mammal {
	// CONSTRUCTOR
	public Gorilla() {
		// TODO Auto-generated constructor stub
	}
	
	// Gorilla METHODS throwSomething(), eatBananas(), and climb()
	public int throwSomething() {
		energyLevel -= 5;
		System.out.printf("\nGorilla threw something! Energy level is now %d", energyLevel);
		return energyLevel;
	}
	
	public int eatBananas() {
		energyLevel += 10;
		System.out.printf("\nGorilla says, 'Yum Yum'! Energy level is now %d", energyLevel);
		return energyLevel;
	}
	
	public int climb() {
		energyLevel -= 10;
		System.out.printf("\nGorilla is climbing! Energy level is now %d", energyLevel);
		return energyLevel;
	}
}
