package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportSecurityContext;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class Driver {

	public static void main(String[] args) {
		
		if(args.length == 3) {
			int debugValue = 0; 
			 try {
				 debugValue = Integer.parseInt(args[2]);
			  } catch (NumberFormatException e) {
			     System.out.println("Error while parsing debug level value");
			     e.printStackTrace();
			     System.exit(0);
			  }
			 
			if(debugValue >=0 && debugValue <5) {
				MyLogger.setDebugValue(debugValue);
				
				String INPUT_FILENAME = args[0];
				String OUTPUT_FILENAME = args[1];
				
				FileProcessor fileProcessor = new FileProcessor();
				fileProcessor.openFile(INPUT_FILENAME);

				AirportSecurityContext airportSecurityContext = new AirportSecurityContext();
				airportSecurityContext.initializeAirportSecurityStates();

				String line = "";
				while (line != null) {
					line = fileProcessor.readLine();
						
					if(line != null) {
						airportSecurityContext.updateAirportSecurity(line);
					}
				}

				Results results = airportSecurityContext.getResults();
				results.writeToFile(OUTPUT_FILENAME);
				
			}else {
				System.out.println("Incorrect Debug Level value.!! Debug value should be between 0 and 4 (both inclusive)");
				System.exit(0);
			}
			
		}else {
			System.out.println("Incorrect number of arguments");
			System.exit(0);
		}
	}
}
