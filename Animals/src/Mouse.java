
public class Mouse extends Animal{
	private int direction;
	
	public Mouse() {
		super();
		direction = WEST;
	}
	
	public int takeOneStep() {
		if (direction == WEST) {
			direction = NORTH;
		} else if (direction == NORTH) {
			direction = WEST;
		}
		return direction;
	}
	
	public String toString() {
		return "M";
	}
	
	
	public static void main(String [] args) {
		// First two parameters are the size of the field (generally you want
		// the Y dimension to be less than half of the X)
		// The final variable is a delay between each call to move. The lower
		// the number, the faster the simulator will run.
		AnimalDisplay display = new AnimalDisplay(50, 25, 100);
		display.addAnimal(new Mouse());		
		display.run();
	}

	
}
