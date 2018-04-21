package airportSecurityState.airportStates;

import airportSecurityState.util.AirportMetricUtility;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class AirportSecurityContext {

	AirportStateI lowRiskState, moderateRiskState, highRiskState, currentState;
	AirportMetricUtility airportMetricUtility;
	Results results;
	
	public AirportSecurityContext() {
		MyLogger.writeMessage("Inside AirportSecurityContext Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		airportMetricUtility = new AirportMetricUtility();
		results = new Results();
	}
	
	public void initializeAirportSecurityStates() {
		lowRiskState = new LowRisk(this);
		moderateRiskState = new ModerateRisk(this);
		highRiskState = new HighRisk(this);
		
		currentState = lowRiskState;
	}

	public void updateAirportSecurity(String input) {
		String operation = currentState.tightenOrLoosenSecurity(input, airportMetricUtility);
		results.addOperationToResult(operation);
	}
	
	public AirportStateI getCurrentState() {
		return currentState;
	}

	public void setCurrentState(AirportStateI currentState) {
		this.currentState = currentState;
	}

	public AirportStateI getLowRiskState() {
		return lowRiskState;
	}

	public void setLowRiskState(AirportStateI lowRiskState) {
		this.lowRiskState = lowRiskState;
	}

	public AirportStateI getModerateRiskState() {
		return moderateRiskState;
	}

	public void setModerateRiskState(AirportStateI moderateRiskState) {
		this.moderateRiskState = moderateRiskState;
	}

	public AirportStateI getHighRiskState() {
		return highRiskState;
	}

	public void setHighRiskState(AirportStateI highRiskState) {
		this.highRiskState = highRiskState;
	}

	public Results getResults() {
		return results;
	}

	public void setResults(Results results) {
		this.results = results;
	}
	
	
}
