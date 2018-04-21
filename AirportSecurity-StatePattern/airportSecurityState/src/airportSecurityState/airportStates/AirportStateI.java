package airportSecurityState.airportStates;

import airportSecurityState.util.AirportMetricUtility;

public interface AirportStateI {

	public String tightenOrLoosenSecurity(String input, AirportMetricUtility airportMetricUtility);
}
