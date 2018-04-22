package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{

	private int myInt;
	private int myOtherInt;
	private long myLong;
	private long myOtherLong;
	private String myString;
	private boolean myBool;
	
	public MyAllTypesFirst() {
		myInt = 0;
		myOtherInt = 0;
		myLong = 0L;
		myOtherLong = 0L;
		myString = "";
		myBool = false;
	}
	
	
	public MyAllTypesFirst(int myInt, int myOtherInt, long myLong, long myOtherLong, String myString, boolean myBool) {
		this.myInt = myInt;
		this.myOtherInt = myOtherInt;
		this.myLong = myLong;
		this.myOtherLong = myOtherLong;
		this.myString = myString;
		this.myBool = myBool;
	}

	public MyAllTypesFirst(String myString, boolean myBool) {
		this.myString = myString;
		this.myBool = myBool;
	}


	public int getmyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public long getmyLong() {
		return myLong;
	}
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}
	public String getmyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
	public int getmyOtherInt() {
		return myOtherInt;
	}
	public void setMyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}
	public long getmyOtherLong() {
		return myOtherLong;
	}
	public void setMyOtherLong(long myOtherLong) {
		this.myOtherLong = myOtherLong;
	}
	public boolean getmyBool() {
		return myBool;
	}
	public void setMyBool(boolean myBool) {
		this.myBool = myBool;
	}
	@Override
	public String toString() {
		return "MyAllTypesFirst [myInt=" + myInt + ", myOtherInt=" + myOtherInt + ", myLong=" + myLong
				+ ", myOtherLong=" + myOtherLong + ", myString=" + myString + ", myBool=" + myBool + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myBool != other.myBool)
			return false;
		if (myInt != other.myInt || myInt < 10)
			return false;
		if (myLong != other.myLong || myLong < 10)
			return false;
		if (myOtherInt != other.myOtherInt || myOtherInt < 10)
			return false;
		if (myOtherLong != other.myOtherLong || myOtherLong < 10)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		return true;
	}
	
	
}
