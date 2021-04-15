
public class Square extends Rectangle{

	public Square(double side) {
		super(side, side);
	}
	
	public double getSide() {
		return super.getHeight();
	}

	public void setSide(double side) {
		super.setHeight(side);
		super.setWidth(side);
	}
	
	public void setHeight(double height) {
		super.setHeight(height);
		super.setWidth(height);
	}

	public void setWidth(double width) {
		super.setHeight(width);
		super.setWidth(width);
	}
	
	public String toString() {
		return "This is a square with length of " + this.getSide();
	}
	
}
