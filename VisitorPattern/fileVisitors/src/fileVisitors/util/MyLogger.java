package fileVisitors.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a palindrome is found with character count greater than 3]
      DEBUG_VALUE=2 [Print to stdout everytime a word with prime length is found]
      DEBUG_VALUE=1 [Print to stdout everytime result is written to output file]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is OK to write to the output file though" ]
    */

	public static enum DebugLevel {RELEASE, FROM_RESULTS, PRIME, PALINDROME, CONSTRUCTOR};

    private static DebugLevel debugLevel;
    
    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
    		case 4: debugLevel = DebugLevel.CONSTRUCTOR; 
    				break;
    		case 3: debugLevel = DebugLevel.PALINDROME;
    				break;
    		case 2: debugLevel = DebugLevel.PRIME;
    				break;
    		case 1: debugLevel = DebugLevel.FROM_RESULTS;
    				break;
    		case 0: debugLevel = DebugLevel.RELEASE; 
    				break;
    	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message, DebugLevel levelIn ) {
    	if (levelIn == debugLevel)
    		System.out.println(message);
    }
    
    /** 
     * @return String
     */
    
    public String toString() {
    	return "Debug Level is " + debugLevel;
    }
}