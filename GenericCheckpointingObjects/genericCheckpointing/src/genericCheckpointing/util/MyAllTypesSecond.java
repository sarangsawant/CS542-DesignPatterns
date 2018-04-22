package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{

	private double myDouble;
	private double myOtherDouble;
	private float myFloat;
	private short myShort;
	private char myChar;
	
	public MyAllTypesSecond() {
		myDouble = 0.0;
		myOtherDouble = 0.0;
		myFloat = 0;
		myShort = 0;
		myChar = ' ';
	}
	
	public MyAllTypesSecond(float myFloat, short myShort, char myChar) {
		this.myFloat = myFloat;
		this.myShort = myShort;
		this.myChar = myChar;
	}

	public MyAllTypesSecond(double myDouble, double myOtherDouble, float myFloat, short myShort, char myChar) {
		this.myDouble = myDouble;
		this.myOtherDouble = myOtherDouble;
		this.myFloat = myFloat;
		this.myShort = myShort;
		this.myChar = myChar;
	}

	public double getmyDouble() {
		return myDouble;
	}
	public double getmyOtherDouble() {
		return myOtherDouble;
	}
	public void setMyOtherDouble(double myOtherDouble) {
		this.myOtherDouble = myOtherDouble;
	}
	
	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}
	public float getmyFloat() {
		return myFloat;
	}
	public void setMyFloat(float myFloat) {
		this.myFloat = myFloat;
	}
	public short getmyShort() {
		return myShort;
	}
	public void setMyShort(short myShort) {
		this.myShort = myShort;
	}
	public char getmyChar() {
		return myChar;
	}
	public void setMyChar(char myChar) {
		this.myChar = myChar;
	}

	@Override
	public String toString() {
		return "MyAllTypesSecond [myDouble=" + myDouble + ", myOtherDouble=" + myOtherDouble + ", myFloat=" + myFloat
				+ ", myShort=" + myShort + ", myChar=" + myChar + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myChar != other.myChar)
			return false;
		if (Double.doubleToLongBits(myDouble) != Double.doubleToLongBits(other.myDouble) || myDouble<10)
			return false;
		if (Float.floatToIntBits(myFloat) != Float.floatToIntBits(other.myFloat))
			return false;
		if (Double.doubleToLongBits(myOtherDouble) != Double.doubleToLongBits(other.myOtherDouble) || myDouble < 10)
			return false;
		if (myShort != other.myShort)
			return false;
		return true;
	}
	
}
