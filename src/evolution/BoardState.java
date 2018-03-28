package evolution;

public enum BoardState {

	TIC((byte)1, "O"),
	TAC((byte)2, "X"),
	NUL((byte)0, "-"),
	DRAW((byte)-1, "DRAW");
	
	private final byte value;
	private final String display;

	private BoardState(byte value, String display) {
		this.value = value;
		this.display = display;
	}

	public byte getValue() {
		return value;
	}

	public String getDisplay() {
		return display;
	}
}
