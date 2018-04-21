package airportSecurityState.airportStates;

import airportSecurityState.util.AirportMetricUtility;
import airportSecurityState.util.MyLogger;

public class HighRisk implements AirportStateI{

	AirportSecurityContext securityContext;
	
	public HighRisk(AirportSecurityContext newAirportContext) {
		MyLogger.writeMessage("Inside HighRisk State Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
		securityContext = newAirportContext;
	}

	@Override
	public String tightenOrLoosenSecurity(String input, AirportMetricUtility airportMetricUtility) {
		String operation = null;
		airportMetricUtility.parseInput(input);

		int avgTrafficPerDay = airportMetricUtility.calculateAvgTrafficPerDay();
		int avgProhibitedItemPerDay = airportMetricUtility.calculateAvgProhibitedItemsPerDay();
		
		MyLogger.writeMessage("Average Traffic/Day-> " + avgTrafficPerDay + ", Average ProhibitedItem/Day-> " + avgProhibitedItemPerDay, MyLogger.DebugLevel.AVERAGE_METRICS);

		if(avgTrafficPerDay >= 8 || avgProhibitedItemPerDay >= 2) {
			operation = "2 4 6 8 10";
		}else if(avgTrafficPerDay >= 4 || avgProhibitedItemPerDay >= 1) {
			MyLogger.writeMessage("State changed from HighRisk State to ModerateRisk State", MyLogger.DebugLevel.STATE_CHANGE);
			operation = "2 3 5 8 9";
			securityContext.setCurrentState(securityContext.getModerateRiskState());
		}else {
			MyLogger.writeMessage("State changed from HighRisk State to LowRisk State", MyLogger.DebugLevel.STATE_CHANGE);
			operation = "1 3 5 7 9";
			securityContext.setCurrentState(securityContext.getLowRiskState());
		}
		
		return operation;
		
	}
}
