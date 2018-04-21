package airportSecurityState.util;

public class AirportMetricUtility {

	private static int travellersCnt = 0;
	private static int totalDays = 0;
	private static int prohibitedItemCnt = 0;
	
	private void incrementTravellersCnt() {
		travellersCnt = travellersCnt + 1;
	}
	
	private void incrementProhibitedItemCnt() {
		prohibitedItemCnt = prohibitedItemCnt + 1;
	}
	
	private void setTotalDays(int day) {
		if(day > totalDays )
			totalDays = day;
	}
	
	public void parseInput(String input) {
		String passengerDetails[] = input.split(";");
		
		String day[] = passengerDetails[0].split(":");
		String item[] = passengerDetails[3].split(":");
		
		int travelDay = Integer.parseInt(day[1]);
		String prohibitedItem = item[1];
		
		incrementTravellersCnt();
		setTotalDays(travelDay);
		
		if(prohibitedItem.toLowerCase().equals(AirportEnum.BLADE.getValue()) ||
		   prohibitedItem.toLowerCase().equals(AirportEnum.NAIL_CUTTER.getValue())||
		   prohibitedItem.toLowerCase().equals(AirportEnum.GUN.getValue()) ||
		   prohibitedItem.toLowerCase().equals(AirportEnum.KNIFE.getValue())) {
			MyLogger.writeMessage("Prohibited Item Found -> " + prohibitedItem, MyLogger.DebugLevel.PROHIBITED_ITEM);
			incrementProhibitedItemCnt();
		}
	}
	
	public int calculateAvgTrafficPerDay() {
		int avgTraffic = 0;
		avgTraffic = travellersCnt/totalDays;
		return avgTraffic;
	}

	public int calculateAvgProhibitedItemsPerDay() {
		int avgProhibitedItems = 0;
		
		avgProhibitedItems = prohibitedItemCnt/totalDays;
		
		return avgProhibitedItems;
	}
	
}
