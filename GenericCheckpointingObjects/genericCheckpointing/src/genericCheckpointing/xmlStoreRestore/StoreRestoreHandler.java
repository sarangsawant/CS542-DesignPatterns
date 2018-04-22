package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import genericCheckpointing.server.SerStrategy;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.XMLDeserialization;
import genericCheckpointing.util.XMLSerialization;

public class StoreRestoreHandler implements InvocationHandler{

	FileProcessor fileProcessor = null;

	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		
		if(m.getName().equals("writeObj")) {
			serializeData((SerializableObject) args[0], new XMLSerialization(fileProcessor));
		}
	   
		SerializableObject obj = null;
		if(m.getName().equals("readObj")) {
			obj = deSerializeData(new XMLDeserialization(fileProcessor));
		}

		return obj;
	}

	private SerializableObject deSerializeData(SerStrategy sStrategy) {
		return sStrategy.processFile();
	}
	
	private void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
        sStrategy.processInput(sObject);
	}
	
	public void setFileprocessor(FileProcessor processor) {
		fileProcessor = processor;
	}
}
