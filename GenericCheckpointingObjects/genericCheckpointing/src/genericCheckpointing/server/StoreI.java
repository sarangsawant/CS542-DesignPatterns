package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI extends StoreRestoreI{
	public void writeObj(MyAllTypesFirst aRecord, String wireFormat);
    public void writeObj(MyAllTypesSecond bRecord,String wireFormat);
}
