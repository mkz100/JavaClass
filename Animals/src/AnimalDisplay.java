
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class AnimalDisplay extends JFrame {
	private List<Animal> animals;
	private int maxX;
	private int maxY;
	private JTextArea field;
	private volatile boolean keepRunning = true;
	private int delayBetweenSteps;

	/**
	 * Primary method called in a constant loop. Draws all the animals in their new
	 * locations and checks for collisions
	 */
	public void step() {
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			int oldX = animal.getX();
			int oldY = animal.getY();
			animal.move();
			int newX = animal.getX();
			int newY = animal.getY();
			checkForIllegalMove(oldX, oldY, newX, newY, animal);
			draw(oldX, oldY, " ");
			if (checkForCollision(i, animal) == true) {				
				draw(newX, newY, animal.toString());
			}
		}
		field.select(0,0);
		field.revalidate();		
	}
	
	private void checkForIllegalMove(int oldX, int oldY, int newX, int newY, Animal animal) {
		if (oldX == newX && oldY == newY) {
			keepRunning = false;
			throw new IllegalArgumentException("Animals type " + animal + " did not move when move was called. Animals must move every time move is called.");
		}
		if (oldX != newX && oldY != newY) {
			keepRunning = false;
			throw new IllegalArgumentException("Animals type " + animal + " changed both X and Y in a single call to move. Animals cannot move diagonallyl.");
		}
		if (Math.abs(newX - oldX) > 1 || Math.abs(newY - oldY) > 1) {
			keepRunning = false;
			throw new IllegalArgumentException("Animals type " + animal + " changed X or Y by a value greater than 1. For each call to move, Animals can only move a single step in any direction.");
		}
	}
	/**
	 * Check to see if, after a move we have collided with any other animals.
	 * Only check for the animals at a lower index than this one, because those
	 * are the only animals that have moved.
	 * @param index - index of this animal.
	 * @param animal - animal
	 * @return true if the animal still exists after this call. 
	 */
	private boolean checkForCollision(int index, Animal animal) {
		

		int x = animal.getX() % maxX;
		int y = animal.getY() % maxY;
		y = adjustedVal(y, maxY);
		x = adjustedVal(x, maxX);
		for (int i = index - 1; i >= 0; i--) {
			Animal other = animals.get(i);
			int otherX = adjustedVal(other.getX(),  maxX);
			int otherY = adjustedVal(other.getY(), maxY);
			// As soon as there is a collision, we can stop looing because
			// we know that no two animals can occupy the same space
			if (otherX == x && otherY == y ) {
				int result = animal.collisionResult(other); 
				// Delete our animal.
				if (result == Animal.DELETE_THIS) {
					animals.remove(index);
					return false;
				}
				else if (result == Animal.DELETE_OTHER){
					// Replace the animal at i with our animal
					animals.set(i, animals.remove(index));
					return true;
				}// The both live case just flows through.				
			}			
		}
		return true;
	}
	private int adjustedVal(int val, int max ) {
		val %= max;
		if (val < 0) {
			val = max + val;
		}
		return val;
	}
	
	private void draw(int x, int y, String letter) {
		if (letter.length() > 1) {
			letter = letter.substring(0, 1);
		}
		y = adjustedVal(y, maxY);
		x = adjustedVal(x, maxX);
		int letterPos = (maxX + 1) * y + x;
		field.select(letterPos, letterPos + 1);
		field.replaceSelection(letter);

	}
	
	
	public AnimalDisplay(int maxX, int maxY, int delayBetweenSteps) {
		super();
		this.maxX = maxX;
		this.maxY = maxY;
		this.delayBetweenSteps = delayBetweenSteps;
		if (delayBetweenSteps < 1) {
			delayBetweenSteps = 1;
		}
		animals = new ArrayList<Animal>();
		setTitle("Simple Animal Simulator");
		initializeField();
		pack();
		addWindowListener(new WindowAdapter() {
				  public void windowClosing(WindowEvent we) {
					  keepRunning = false;
				    dispose();
				    System.gc();
				  }
				});
					
	}
	private void initializeField() {
		field = new JTextArea();
		Font font = new Font("monospaced", Font.PLAIN, field.getFont().getSize());
		field.setFont(font);
		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				field.append(" ");
			}
			field.append("\n");
		}
		field.setEditable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());		
		panel.add(field, BorderLayout.CENTER);
		add(panel);

	}

	

	
	private void doSteps() {

		while(keepRunning) {
			try {
				SwingUtilities.invokeAndWait(new Runnable() {
					public void run() {
						step();
					}
				});
			} catch (InvocationTargetException | InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(delayBetweenSteps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void run() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
	
					@Override
					protected Void doInBackground() {
						doSteps();
						return null;
					}
				};
				worker.execute();
			}
		});		
	}


	
	public void addAnimal(Animal animal) {		
		animals.add(animal);
	}
	

}
