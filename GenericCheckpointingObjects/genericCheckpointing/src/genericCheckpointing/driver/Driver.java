
package genericCheckpointing.driver;

import java.util.ArrayList;
import java.util.List;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.RandomValueGenerator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.XMLDeserialization;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

// import the other types used in this file

public class Driver {
    
    public static void main(String[] args) {
	
    if(args.length != 3) {
    	System.out.println("Incorrect number of arguments..!!!");
    	System.exit(0);
    }
    
    //"serdeser" or "deser"
    String mode = args[0];
    int noOfObjects = Integer.parseInt(args[1]);
    String FILENAME = args[2];
    
    //String mode = "serdeser";
	//int noOfObjects = 2;
	//String FILENAME = "D:\\Work\\1_DesignPatterns\\Projects\\files\\MyAllTypes2.txt";
	//String FILENAME = "D:\\Work\\1_DesignPatterns\\Projects\\files\\output.txt";
	
	ProxyCreator pc = new ProxyCreator();
	
	StoreRestoreHandler handler = new StoreRestoreHandler();
	
	// create a proxy
	StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, 
								 handler
								 );
		

	FileProcessor fileProcessor = new FileProcessor();
	
	if(mode.equals("deser")) {
		List<SerializableObject> deserializableObjects = new ArrayList<SerializableObject>();
		
		fileProcessor.openFile(FILENAME);
		XMLDeserialization deserialization = new XMLDeserialization(fileProcessor);
		
		for(int i=0; i<noOfObjects;i++)
			deserializableObjects.add(deserialization.processFile());
		
		fileProcessor.closeFile();
		
		for(SerializableObject obj : deserializableObjects)
			System.out.println(obj);

	}else if(mode.equals("serdeser")) {
		fileProcessor.openFileForWrite(FILENAME);
		handler.setFileprocessor(fileProcessor);
		
		List<SerializableObject> serializableObjects = new ArrayList<SerializableObject>();
		
		RandomValueGenerator generator = new RandomValueGenerator();
		MyAllTypesFirst myFirst = null;
		MyAllTypesSecond  mySecond = null;

		for (int i=0; i<noOfObjects; i++) {
			
			int value = generator.getInt();
			int myInt = value;
			int myOtherInt = value;
			long myLong = (long) value;
			long myOtherLong = (long) value;
			String myString = "Design patterns " + i;
			boolean myBool = generator.getBool();
		    
			if(value < 10)
				myFirst = new MyAllTypesFirst(myString, myBool);
			else
				myFirst = new MyAllTypesFirst(myInt,myOtherInt,myLong,myOtherLong,myString,myBool);
			

			double val = generator.getDouble();
			double myDouble = val;
			double myOtherDouble = val;
			float myFloat = generator.getFloat();
			short myShort = (short) generator.getInt();
			char myChar = generator.getChar();
			
			if(val < 10)
				mySecond = new MyAllTypesSecond(myFloat, myShort, myChar);
			else
				mySecond = new MyAllTypesSecond(myDouble,myOtherDouble,myFloat,myShort,myChar);

		    serializableObjects.add(myFirst);
		    serializableObjects.add(mySecond);

		    ((StoreI) cpointRef).writeObj(myFirst, "XML");
		    ((StoreI) cpointRef).writeObj(mySecond, "XML");
		    
		}
		fileProcessor.closeFile();
		/*System.out.println("After Serialization");
		for(SerializableObject obj : serializableObjects)
			System.out.println(obj);
		System.out.println();*/
		
		List<SerializableObject> serializableReadObjects = new ArrayList<SerializableObject>();
		SerializableObject myRecordRet;
		
		fileProcessor.openFile(FILENAME);
		handler.setFileprocessor(fileProcessor);
		
		for (int j=0; j<2*noOfObjects; j++) {

		    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
		    serializableReadObjects.add(myRecordRet);
		    
		}
		fileProcessor.closeFile();
		
		/*System.out.println("After Deserialization");
		for(SerializableObject obj : serializableReadObjects)
			System.out.println(obj);*/
		
		int mismatchCnt = 0;
		for(int k=0;k<serializableObjects.size();k++) {
			if(serializableObjects.get(k).equals(serializableReadObjects.get(k)) == false)
				mismatchCnt = mismatchCnt + 1;
		}
		
		System.out.println(mismatchCnt + " mismatched objects");

	}else {
		System.out.println("Invalid Mode..!!");
		System.exit(0);
	}

    }
}