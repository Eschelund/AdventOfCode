package Day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day01_2 {

    /*
    --- Part Two ---
    The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

    Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

    In your expense report, what is the product of the three entries that sum to 2020?
     */

    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\Ricco\\IdeaProjects\\AdventOfCode\\AdventOfCode2020\\src\\Day01\\input_day1.txt");

        try {
            List<String> instructions = Files.readAllLines(path);

            System.out.println("Test");

            for (int i = 0; i < instructions.size(); i++) {
                Integer num1 = Integer.parseInt(instructions.get(i));
                for (int j = i; j < instructions.size(); j++) {
                    Integer num2 = Integer.parseInt(instructions.get(j));
                    for (int k = j; k < instructions.size(); k++) {
                        Integer num3 = Integer.parseInt(instructions.get(k));
                        if (num1 + num2 + num3 == 2020) {
                            System.out.println("The product is :" + num1 * num2 * num3);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
