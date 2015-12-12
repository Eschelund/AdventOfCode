package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7_1 {

	
	/*
	 --- Day 7: Some Assembly Required ---

		This year, Santa brought little Bobby Tables a set of wires and bitwise logic gates! Unfortunately, little Bobby is a little under the recommended age range, and he needs help assembling the circuit.
		
		Each wire has an identifier (some lowercase letters) and can carry a 16-bit signal (a number from 0 to 65535). A signal is provided to each wire by a gate, another wire, or some specific value. Each wire can only get a signal from one source, but can provide its signal to multiple destinations. A gate provides no signal until all of its inputs have a signal.
		
		The included instructions booklet describes how to connect the parts together: x AND y -> z means to connect wires x and y to an AND gate, and then connect its output to wire z.
		
		For example:
		
		123 -> x means that the signal 123 is provided to wire x.
		x AND y -> z means that the bitwise AND of wire x and wire y is provided to wire z.
		p LSHIFT 2 -> q means that the value from wire p is left-shifted by 2 and then provided to wire q.
		NOT e -> f means that the bitwise complement of the value from wire e is provided to wire f.
		Other possible gates include OR (bitwise OR) and RSHIFT (right-shift). If, for some reason, you'd like to emulate the circuit instead, almost all programming languages (for example, C, JavaScript, or Python) provide operators for these gates.
		
		For example, here is a simple circuit:
		
		123 -> x
		456 -> y
		x AND y -> d
		x OR y -> e
		x LSHIFT 2 -> f
		y RSHIFT 2 -> g
		NOT x -> h
		NOT y -> i
		After it is run, these are the signals on the wires:
		
		d: 72
		e: 507
		f: 492
		g: 114
		h: 65412
		i: 65079
		x: 123
		y: 456
		In little Bobby's kit's instructions booklet (provided as your puzzle input), what signal is ultimately provided to wire a?
	 */
	public static void main(String[] args) {
		Map<String, LogicWireNote> wires = new HashMap<String, LogicWireNote>();
		Path path = Paths.get("D:\\Workspaces\\EclipseWorkspace\\AdventOfCode2015\\src\\Day7\\input_day7.txt");
		
		List<String> instructions;

		try {
			instructions = Files.readAllLines(path);
			
			for (String s : instructions) {
				String[] parts = s.split(" ");
				if (parts.length == 3) {
					wires.put(parts[2], new LogicWireNote(Short.parseShort(parts[0])));
				} else if (parts.length == 4) {
					wires.put(parts[3], new LogicWireNote(LogicOperators.NOT, wires.get(parts[1])));
				} else if (parts.length == 5) {
					if (parts[1].equals(LogicOperators.AND)) {
						wires.put(parts[4], new LogicWireNote(LogicOperators.AND, wires.get(parts[0]), wires.get(parts[2])));
					} else if (parts[1].equals(LogicOperators.OR)) {
						wires.put(parts[4], new LogicWireNote(LogicOperators.OR, wires.get(parts[0]), wires.get(parts[2])));
					} else if (parts[1].equals(LogicOperators.RSHIFT)) {
						wires.put(parts[4], new LogicWireNote(LogicOperators.RSHIFT, wires.get(parts[0]), Integer.parseInt(parts[2])));
					} else if (parts[1].equals(LogicOperators.LSHIFT)) {
						wires.put(parts[4], new LogicWireNote(LogicOperators.LSHIFT, wires.get(parts[0]), Integer.parseInt(parts[2])));
					}
				}
			}
			
			System.out.println("Wire a holds the value: " + wires.get("a").getResult());
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
}
