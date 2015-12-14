package Day7;

import java.util.Map;

public class LogicWireNote {
	private String name;
	private String inWireA;
	private String inWireB;
	private int shift;
	private short result = -1;
	private LogicOperators type = LogicOperators.NAN;
	
	public LogicWireNote(String name, LogicOperators type, String inWireA) {
		this.name = name;
		this.type = type;
		this.inWireA = inWireA;
	}
	
	public LogicWireNote(String name, LogicOperators type, String inWireA, String inWireB) {
		this.name = name;
		this.type = type;
		this.inWireA = inWireA;
		this.inWireB = inWireB;
	}
	
	public LogicWireNote(String name, LogicOperators type, String inWireA, int shift) {
		this.name = name;
		this.type = type;
		this.inWireA = inWireA;
		this.shift = shift;
	}
	
	public LogicWireNote(String name, short result) {
		this.name = name;
		this.result = result;
	}
	
	public LogicWireNote(String name, String inWireA) {
		this.name = name;
		this.inWireA = inWireA;
	}
	
	public short getResult(Map<String,LogicWireNote> map) {
		try {
			if (result == -1) {
				LogicWireNote inputWireA = map.get(inWireA);
				LogicWireNote inputWireB = map.get(inWireB);
				switch (type) {
				case AND:
					result = inWireA.matches("d") ? 
					LogicOperations.AND(Short.parseShort(inWireA), inputWireB.getResult(map)) :
					LogicOperations.AND(inputWireA.getResult(map), inputWireB.getResult(map));
					break;
				case OR:
					result = inWireA.matches("d") ? 
					LogicOperations.OR(Short.parseShort(inWireA), inputWireB.getResult(map)) :
					LogicOperations.OR(inputWireA.getResult(map), inputWireB.getResult(map));
					break;
				case NOT:
					result = LogicOperations.NOT(inputWireA.getResult(map));
					break;
				case LSHIFT:
					result = LogicOperations.LSHIFT(inputWireA.getResult(map), shift);
					break;
				case RSHIFT: 
					result = LogicOperations.RSHIFT(inputWireA.getResult(map), shift);
					break;
				default:
					result = inWireA.matches("d") ? Short.parseShort(inWireA) : inputWireA.getResult(map);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(String.format("There was a problem: Name:%s; Type:%s; WireA:%s; WireB:%S; Exception:%s", name, type, inWireA, inWireB, e.getMessage()));
		}
		System.out.println(String.format("Wire %s of type %s has value: %s", name, type, result));
		return result;
	}
}
