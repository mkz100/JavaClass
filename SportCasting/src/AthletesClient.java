import java.util.ArrayList;

public class AthletesClient {

	public static void main(String[] args) {
		ArrayList<Athletes> athletes = new ArrayList<Athletes>();
		athletes.add(new SoftballPlayer("Annie", 9, 50000.00, 0.3, 16, 5));
		athletes.add(new TennisPlayer("Bobbie", 26, 50000.00, 9.2, "Forehand", 35));
		
		for (int i = 0; i < athletes.size(); i++) {
			System.out.println(athletes.get(i).getName());
		}
		
		System.out.println();
		
		System.out.println("SoftballPlayer: Batting Average " + ((SoftballPlayer) athletes.get(0)).getBattingAvg());
		System.out.println("SoftballPlayer: RBI " + ((SoftballPlayer) athletes.get(0)).getRBI());
		System.out.println("SoftballPlayer: HR " + ((SoftballPlayer) athletes.get(0)).getHR());
		
		System.out.println();
		
		System.out.println("TennisPlayer: UTR " +( (TennisPlayer) athletes.get(1)).getUTR());
		System.out.println("TennisPlayer: Favorite Stroke " + ((TennisPlayer) athletes.get(1)).getFavoriteStroke());
		System.out.println("TennisPlayer: NumOfWins " + ((TennisPlayer) athletes.get(1)).getNumOfWins());
	}

}
