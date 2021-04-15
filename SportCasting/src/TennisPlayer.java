
public class TennisPlayer extends Athletes{
	private double utr; //universal tennis rating
	private String favoriteStroke;
	private int numOfWins;

	public TennisPlayer(String name, int number, double salary, double utr, String favoriteStroke, int numOfWins) {
		super(name, number, salary);
		this.utr = utr;
		this.favoriteStroke = favoriteStroke;
		this.numOfWins = numOfWins;
	}
	
	public double getUTR() {
		return utr;
	}
	
	public void setUTR(double utr) {
		this.utr = utr;
	}
	
	public String getFavoriteStroke() {
		return favoriteStroke;
	}
	
	public void setFavoriteStroke(String favoriteStroke) {
		this.favoriteStroke = favoriteStroke;
	}
	
	public int getNumOfWins() {
		return numOfWins;
	}
	
	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}


}
