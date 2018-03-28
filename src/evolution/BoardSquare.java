package evolution;

public enum BoardSquare {

	TL(0),
	TC(1),
	TR(2),
	ML(3),
	MC(4),
	MR(5),
	BL(6),
	BC(7),
	BR(8);
	
	private final int value;

	private BoardSquare(int state) {
		this.value = state;
	}

	public int getValue() {
		return value;
	}	
	
	
}
