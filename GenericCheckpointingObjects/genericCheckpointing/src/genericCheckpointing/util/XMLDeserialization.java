package genericCheckpointing.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import genericCheckpointing.server.SerStrategy;

public class XMLDeserialization implements SerStrategy{
	//List<SerializableObject> serializableObjects = new ArrayList<SerializableObject>();
	
	FileProcessor fileProcessor = null;
	DeserializeTypes deserializeTypes = null;

	public XMLDeserialization(FileProcessor fileProcessorIn) {
		fileProcessor = fileProcessorIn;
		deserializeTypes = new DeserializeTypes();
	}
	
	public SerializableObject processFile() {
		SerializableObject object = null;

		
		String line = "";
		while (line != null) {
			line = fileProcessor.readLine();

			//EOF condition
			if(line != null) {
				//Each object
				if(line.trim().equals("<DPSerialization>")) {
					Class classname = null;
					
					line = fileProcessor.readLine();
					
					do {
							try {
								
								if(line.contains("complexType") && !line.trim().equals("</complexType>")) {
									String complexStr = deserializeTypes.parseComplexTag(line);
									//System.out.println(complexStr);
									classname = Class.forName(complexStr);
									object = (SerializableObject) classname.newInstance();
								}
								
								//MyAllTypesFirst
								if(line.contains("myInt")) {
									int intValue = deserializeTypes.parseIntType(line);
									
									Class[] paramInt = new Class[1];
									paramInt[0] = Integer.TYPE;
									Method intMethod = classname.getDeclaredMethod("setMyInt", paramInt);
									intMethod.invoke(object, intValue);
									
								}
								
								if(line.contains("myOtherInt")) {
									int intValue = deserializeTypes.parseIntType(line);
									
									Class[] paramInt = new Class[1];
									paramInt[0] = Integer.TYPE;
									Method intMethod = classname.getDeclaredMethod("setMyOtherInt", paramInt);
									intMethod.invoke(object, intValue);
									
								}
								
								if(line.contains("myBool")) {
									boolean value = deserializeTypes.parseBoolType(line);
									//System.out.println(intValue);
									
									Class[] paramBool = new Class[1];
									paramBool[0] = Boolean.TYPE;
									Method intMethod = classname.getDeclaredMethod("setMyBool", paramBool);
									intMethod.invoke(object, value);
									
								}
								
								if(line.contains("myLong")) {
									long value = deserializeTypes.parseMyLong(line);
									
									Class[] paramLong = new Class[1];
									paramLong[0] = Long.TYPE;
									Method intMethod = classname.getDeclaredMethod("setMyLong", paramLong);
									intMethod.invoke(object, value);
									
								}
								
								if(line.contains("myOtherLong")) {
									long value = deserializeTypes.parseMyLong(line);
									
									Class[] paramLong = new Class[1];
									paramLong[0] = Long.TYPE;
									Method intMethod = classname.getDeclaredMethod("setMyOtherLong", paramLong);
									intMethod.invoke(object, value);
									
								}
								
								if(line.contains("myString")) {
									String value = deserializeTypes.parseLine(line);
									//System.out.println(intValue);
									
									Class[] paramString = new Class[1];	
									paramString[0] = String.class;
									
									Method intMethod = classname.getDeclaredMethod("setMyString", paramString);
									intMethod.invoke(object, value);
									
								}
								
								//MyAllTypesSecond
								if(line.contains("myDouble")) {
									double value = deserializeTypes.parseDoubleType(line);
									
									Class[] paramDouble = new Class[1];
									paramDouble[0] = Double.TYPE;
									
									Method intMethod = classname.getDeclaredMethod("setMyDouble", paramDouble);
									intMethod.invoke(object, value);
								}
								
								if(line.contains("myOtherDouble")) {
									double value = deserializeTypes.parseDoubleType(line);
									
									Class[] paramDouble = new Class[1];
									paramDouble[0] = Double.TYPE;
									
									Method intMethod = classname.getDeclaredMethod("setMyOtherDouble", paramDouble);
									intMethod.invoke(object, value);
									
								}
								
								if(line.contains("myFloat")) {
									float value = deserializeTypes.parseFloatType(line);
									
									Class[] paramFloat = new Class[1];
									paramFloat[0] = Float.TYPE;
									
									Method intMethod = classname.getDeclaredMethod("setMyFloat", paramFloat);
									intMethod.invoke(object, value);
									
								}
								
								if(line.contains("myShort")) {
									short value = deserializeTypes.parseShortType(line);
									
									Class[] paramShort = new Class[1];
									paramShort[0] = Short.TYPE;
									
									Method intMethod = classname.getDeclaredMethod("setMyShort", paramShort);
									intMethod.invoke(object, value);
									
								}
								
								if(line.contains("myChar")) {
									String value = deserializeTypes.parseLine(line);
									
									Class[] paramChar = new Class[1];
									paramChar[0] = char.class;
									
									Method intMethod = classname.getDeclaredMethod("setMyChar", paramChar);
									intMethod.invoke(object, value.charAt(0));
									
								}
								
							} catch (NoSuchMethodException | SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							line = fileProcessor.readLine();
					}while(!line.trim().equals("</DPSerialization>"));
				}
				
			}
			break;
		}

		return object;
	}

	@Override
	public void processInput(SerializableObject sObject) {
		// TODO Auto-generated method stub
		
	}

}
