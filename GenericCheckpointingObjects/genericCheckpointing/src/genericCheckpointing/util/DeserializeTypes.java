package genericCheckpointing.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains methods to deserialize each of the types.
 * @author Sarang Sawant
 *
 */
public class DeserializeTypes {

	public int parseIntType(String str) {
		String value = parseLine(str);
		int result = Integer.parseInt(value);
		return result;
	}
	
	public long parseMyLong(String str) {
		String value = parseLine(str);
		long result = Long.parseLong(value);
		
		return result;
	}
	
	public boolean parseBoolType(String str) {
		String value = parseLine(str);
		boolean bool = Boolean.parseBoolean(value);
		
		return bool;
	}
	
	public double parseDoubleType(String str) {
		String value = parseLine(str);
		double result = Double.parseDouble(value);
		return result;
	}
	
	public float parseFloatType(String str) {
		String value = parseLine(str);
		float result = Float.parseFloat(value);
		return result;
	}
	
	public short parseShortType(String str) {
		String value = parseLine(str);
		short result = Short.parseShort(value);
		return result;
	}
	
	
	/**
	 * https://stackoverflow.com/questions/6560672/java-regex-to-extract-text-between-tags
	 * @param parseLine
	 * @return
	 */
	public String parseLine(String parseLine) {
		Pattern pattern = Pattern.compile(">.*<");
		Matcher matcher = pattern.matcher(parseLine);
		matcher.find();
		
		String line = parseLine.substring(matcher.start() + 1, matcher.end() - 1);
		//System.out.println("Value between tag is " + line);
		return line;
	}
	
	public String parseComplexTag(String line) {
		
		Pattern pattern = Pattern.compile("genericCheckpointing.*(First|Second)");
		Matcher matcher = pattern.matcher(line);
		matcher.find();
		String classType = line.substring(matcher.start(), matcher.end());
		return classType;
	}
	
}
