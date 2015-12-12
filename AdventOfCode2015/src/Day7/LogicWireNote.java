package Day7;

public class LogicWireNote {
	private LogicWireNote inputWireA;
	private LogicWireNote inputWireB;
	private int shift;
	private short result;
	private LogicOperators type;
	
	public LogicWireNote(LogicOperators type, LogicWireNote inWireA) {
		this.type = type;
		this.inputWireA = inWireA;
	}
	
	public LogicWireNote(LogicOperators type, LogicWireNote inWireA, LogicWireNote inWireB) {
		this.type = type;
		this.inputWireA = inWireA;
		this.inputWireB = inWireB;
	}
	
	public LogicWireNote(LogicOperators type, LogicWireNote inWireA, int shift) {
		this.type = type;
		this.inputWireA = inWireA;
		this.shift = shift;
	}
	
	public LogicWireNote(short result) {
		this.result = result;
	}
	
	public short getResult() {
		if (result == 0) {
			switch (type) {
			case AND:
				result = LogicOperations.AND(inputWireA.getResult(), inputWireB.getResult());
				break;
			case OR:
				result = LogicOperations.OR(inputWireA.getResult(), inputWireB.getResult());
				break;
			case NOT:
				result = LogicOperations.NOT(inputWireA.getResult());
				break;
			case LSHIFT:
				result = LogicOperations.LSHIFT(inputWireA.getResult(), shift);
				break;
			case RSHIFT: 
				result = LogicOperations.RSHIFT(inputWireA.getResult(), shift);
				break;
			default:
				break;
			}
		}
		return result;
	}
}
