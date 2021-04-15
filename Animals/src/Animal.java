
public class Animal {
	// These hold the current location (x,y coordinates) on the screen of the animal
	private int x;
	private int y;
	
	public Animal() {
		// Choose a random starting location on the screen for the animal
		x = (int)(Math.random() * 1000);
		y = (int)(Math.random() * 1000);
	}

	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST = 2;
	public static final int WEST = 3;
	public static final int INVALID_DIRECTION = 4;
	/**
	 * Here is the method to override. This will be called by the simulator in
	 * a loop. It will call it once for every animal so that every animal moves
	 * one step. It will then draw all the animals, and then loop back up so
	 * every animal can take another step 
	 */
	public int takeOneStep() {
		return INVALID_DIRECTION;
	}
	
	/**
	 * This is the other method to override
	 */
	public String toString() {
		return " ";
	}
	

	public void move() {
		int direction = takeOneStep();
		if (direction == NORTH) {
			//take one step north
			y -= 1;
		}
		else if (direction == SOUTH) {
			//take one step south
			y += 1;
		}
		else if (direction == EAST) {
			//take one step east
			x += 1;
		}
		else if (direction == WEST) {
			//take one step west
			x -= 1;
		}
		else {
			System.err.println("Animal type " + toString() + " called change direction with a value other than NORTH, SOUTH, EAST, or WEST");
			System.exit(0);
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	/**
	 * When two animals collide one is deleted. Current algorithms is to
	 * just randomly delete one of them.
	 */
	public static final int DELETE_THIS = 0;
	public static final int DELETE_OTHER = 1;	
	public static final int BOTH_LIVE   = 2;
	public int collisionResult(Animal other) {
		if (Math.random() < 0.5) {
			return DELETE_OTHER;
		}
		return DELETE_THIS;
	}
	

}
