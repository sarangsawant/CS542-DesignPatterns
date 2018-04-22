package genericCheckpointing.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.server.SerStrategy;

public class XMLSerialization implements SerStrategy{
	FileProcessor fileProcessor;
	SerializeTypes serializeTypes;

	public XMLSerialization(FileProcessor fileProcessorIn) {
		fileProcessor = fileProcessorIn;
		serializeTypes = new SerializeTypes();
	}
	
	@Override
	public void processInput(SerializableObject sObject) {
		StringBuilder builder = new StringBuilder();
		
		Class<?> cls = sObject.getClass();
		builder.append("<DPSerialization>\n");
		
		builder.append(serializeTypes.getComplexTag(cls.getName()));
		for (Field field : cls.getDeclaredFields()) {

			try {
				//MyAllTypesFirst
        		 if(field.getType() == int.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 
        			 int value = Integer.parseInt(invokeRet.toString());
        			 if(value>=10)
        				 builder.append(serializeTypes.getDataTypeTag(field.getName(), "int", invokeRet.toString()));
        		 }
        		 
        		 if(field.getType() == long.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 
        			 long value = Long.parseLong(invokeRet.toString());
        			 if(value>=10)
        				 builder.append(serializeTypes.getDataTypeTag(field.getName(), "long", invokeRet.toString()));
        		 }
        		 
        		 if(field.getType() == String.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 builder.append(serializeTypes.getDataTypeTag(field.getName(), "string", invokeRet.toString()));
        		 }
        		 
        		 if(field.getType() == boolean.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 builder.append(serializeTypes.getDataTypeTag(field.getName(), "boolean", invokeRet.toString()));
        		 }
        		 
        		 //MyAllTypesSecond
        		 if(field.getType() == double.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 
        			 double value = Double.parseDouble(invokeRet.toString());
        			 if(value>=10)
        				 builder.append(serializeTypes.getDataTypeTag(field.getName(), "double", invokeRet.toString()));
        		 }
        		 
        		 if(field.getType() == float.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 builder.append(serializeTypes.getDataTypeTag(field.getName(), "float", invokeRet.toString()));
        		 }
        		 
        		 if(field.getType() == short.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 builder.append(serializeTypes.getDataTypeTag(field.getName(), "short", invokeRet.toString()));
        		 }
        		 
        		 if(field.getType() == char.class) {
        			 String name = "get" + field.getName();
        			 Method getterMethod = cls.getMethod(name);
        			 Object invokeRet = getterMethod.invoke(sObject);
        			 builder.append(serializeTypes.getDataTypeTag(field.getName(), "char", invokeRet.toString()));
        		 }
        		 
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }//End Fields For
		builder.append("</complexType>\n");

		builder.append("</DPSerialization>\n");
		fileProcessor.writeFile(builder.toString());
	}

	@Override
	public SerializableObject processFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
