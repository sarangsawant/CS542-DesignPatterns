package airportSecurityState.airportStates;

import airportSecurityState.util.AirportMetricUtility;
import airportSecurityState.util.MyLogger;

public class ModerateRisk implements AirportStateI{

	AirportSecurityContext securityContext;
	
	public ModerateRisk(AirportSecurityContext newAirportContext) {
		MyLogger.writeMessage("Inside ModerateRisk State Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		securityContext = newAirportContext;
	}

	@Override
	public String tightenOrLoosenSecurity(String input, AirportMetricUtility airportMetricUtility) {
		String operation = null;
		airportMetricUtility.parseInput(input);

		int avgTrafficPerDay = airportMetricUtility.calculateAvgTrafficPerDay();
		int avgProhibitedItemPerDay = airportMetricUtility.calculateAvgProhibitedItemsPerDay();
		
		MyLogger.writeMessage("Average Traffic/Day-" + avgTrafficPerDay + ", Average ProhibitedItem/Day-" + avgProhibitedItemPerDay, MyLogger.DebugLevel.AVERAGE_METRICS);

		if(avgTrafficPerDay >= 8 || avgProhibitedItemPerDay >= 2) {
			MyLogger.writeMessage("State changed from ModerateRisk State to HighRisk State", MyLogger.DebugLevel.STATE_CHANGE);
			operation = "2 4 6 8 10";
			securityContext.setCurrentState(securityContext.getHighRiskState());
		}else if(avgTrafficPerDay >= 4 || avgProhibitedItemPerDay >= 1) {
			operation = "2 3 5 8 9";
		}else {
			MyLogger.writeMessage("State changed from ModerateRisk to LowRisk State", MyLogger.DebugLevel.STATE_CHANGE);
			operation = "1 3 5 7 9";
			securityContext.setCurrentState(securityContext.getLowRiskState());
		}
		return operation;
		
	}

}
