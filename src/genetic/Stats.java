package genetic;

public class Stats {

	private static Stats instance = null;
	
	public int draws = 0;
	public int disqualifications = 0;
	

	public static Stats getInstance() {
		if (instance == null) {
			instance = new Stats();
		}
		return instance;
	}	
}
