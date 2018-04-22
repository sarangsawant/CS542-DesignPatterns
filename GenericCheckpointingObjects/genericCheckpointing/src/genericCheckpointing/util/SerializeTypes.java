package genericCheckpointing.util;

public class SerializeTypes {

	public String getDataTypeTag(String name, String dataType, String value) {
		String tag = "<" + name + " xsi:type=\"xsd:" + dataType + "\">" + value + "</" + name + ">\n";
		return tag;
	}

	public String getComplexTag(String input) {
		String tag = "<complexType xsi:type=\"" + input + "\">\n";
		return tag;
	}
	
}
