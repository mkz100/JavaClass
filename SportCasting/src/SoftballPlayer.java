
public class SoftballPlayer extends Athletes{
	private double battingAvg; //batting average
	private int RBI; //run batter in
	private int HR; //homeruns

	public SoftballPlayer(String name, int number, double salary, double battingAvg, int RBI, int HR) {
		super(name, number, salary);
		this.battingAvg = battingAvg;
		this.RBI = RBI;
		this.HR = HR;
	}
	
	public double getBattingAvg() {
		return battingAvg;
	}
	
	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}
	
	public int getRBI() {
		return RBI;
	}
	
	public void setRBI(int RBI) {
		this.RBI = RBI;
	}
	
	public int getHR() {
		return HR;
	}
	
	public void setHR(int HR) {
		this.HR = HR;
	}


}
