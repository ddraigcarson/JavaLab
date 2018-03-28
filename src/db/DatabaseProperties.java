package db;
public enum DatabaseProperties {

    CONNECTION("jdbc:oracle:thin:@localhost:1522:XE"), USER("DDRAIG"), PW("Nanaki13");

    private final String value;

	private DatabaseProperties(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	
	
	
    
}
