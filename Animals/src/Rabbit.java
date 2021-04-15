
public class Rabbit extends Animal {
	private int direction;
	private int steps;
	private int count = 1;

	public Rabbit() {
		super();
		direction = NORTH;
		steps = 2;
	}

	public int takeOneStep() {
		if (count < steps) {
			count++;
		} else {
			count = 1;
			if (direction == NORTH) {
				direction = EAST;
			} else if (direction == EAST) {
				direction = SOUTH;
			} else if (direction == SOUTH) {
				direction = NORTH;
			}
		}
		return direction;
	}

	public String toString() {
		return "V";
	}

	public static void main(String[] args) {
		// First two parameters are the size of the field (generally you want
		// the Y dimension to be less than half of the X)
		// The final variable is a delay between each call to move. The lower
		// the number, the faster the simulator will run.
		AnimalDisplay display = new AnimalDisplay(50, 10, 100);
		display.addAnimal(new Rabbit());
		display.run();
	}

}
