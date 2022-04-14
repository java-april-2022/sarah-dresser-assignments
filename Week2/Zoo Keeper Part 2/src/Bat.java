

public class Bat extends Mammal {
	private int energyLevel = 300;

	public Bat() {
		// TODO Auto-generated constructor stub
	}
	
	// METHODS: fly(), eatHumans(), attackTown()
	public int fly() {
		if(energyLevel < 50) {
			System.out.println("\nToo tired! Must...eat...humans");
			return energyLevel;
		}
		else {
			energyLevel -= 50;
			System.out.printf("\n'Squeak squeak', bat is flying! Bat's energy level is now %d", energyLevel);
			return energyLevel;
		}
	}
	
	public int eatHumans() {
		System.out.println("\nBat's energy level is now " + energyLevel);
		return energyLevel += 25;
	}
	
	public int attackTown() {
		if(energyLevel < 100) {
			System.out.println("\\nToo tired! Must...eat...humans");
			return energyLevel;
		}
		else {
			energyLevel -= 100;
			System.out.printf("\n'Help us!' The town is on fire. Bat's energy level is now %d", energyLevel);
			return energyLevel;
		}
	}

}
