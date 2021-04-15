
public class Snake extends Animal {
	private int direction;
	private boolean checkSouth = true;

	public Snake() {
		super();
		direction = SOUTH;
	}

	public int takeOneStep() {
		if (direction == SOUTH && checkSouth) {
			direction = EAST;
		} else if (direction == EAST) {
			direction = SOUTH;
			checkSouth = false;
		} else if (direction == SOUTH) {
			direction = WEST;
		} else if (direction == WEST) {
			direction = SOUTH;
			checkSouth = true;
		}
		return direction;
	}

	public String toString() {
		return "S";
	}

	public static void main(String[] args) {
		// First two parameters are the size of the field (generally you want
		// the Y dimension to be less than half of the X)
		// The final variable is a delay between each call to move. The lower
		// the number, the faster the simulator will run.
		AnimalDisplay display = new AnimalDisplay(50, 25, 500);
		display.addAnimal(new Snake());
		display.run();
	}

}
