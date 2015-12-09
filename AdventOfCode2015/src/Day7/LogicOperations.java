package Day7;

public class LogicOperations {
	
	public static short AND(short a, short b) {
		return (short) (a & b);
	}
	
	public static short OR(short a, short b) {
		return (short) (a | b);
	}
	
	public static short NOT(short a) {
		return (short) ~a;
	}
	
	public static short LSHIFT(short a, int shift) {
		return (short) (a << shift);
	}
	
	public static short RSHIFT(short a, int shift) {
		return (short) (a >>> shift);
	}
}
