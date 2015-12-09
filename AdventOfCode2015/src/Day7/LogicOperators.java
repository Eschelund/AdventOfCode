package Day7;

public enum LogicOperators {
	AND("AND"), OR("OR"), NOT("NOT"), LSHIFT("LSHIFT"), RSHIFT("RSHIFT");
	
	private String name;
	
	private LogicOperators(String s) {
		name = s;
	}
	
	public String get() {
		return name;
	}
	
	public boolean equals(String other) {
		return get().equals(other);
	}
}
