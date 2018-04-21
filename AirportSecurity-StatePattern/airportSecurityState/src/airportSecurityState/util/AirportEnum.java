package airportSecurityState.util;

public enum AirportEnum {
	GUN("gun"), NAIL_CUTTER("nailcutter"), BLADE("blade"), KNIFE("knife");

	private String value;
	
	AirportEnum(String name){
		this.value = name;
	}
	
	public String getValue() {
		return value;
	}
}