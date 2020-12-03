package Day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02 {
    /*
    --- Day 2: Password Philosophy ---
    Your flight departs in a few days from the coastal airport; the easiest way down to the coast from here is via toboggan.

    The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day. "Something's wrong with our computers; we can't log in!" You ask if you can take a look.

    Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the Official Toboggan Corporate Policy that was in effect when they were chosen.

    To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the corrupted database) and the corporate policy when that password was set.

    For example, suppose you have the following list:

    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc
    Each line gives the password policy and then the password. The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.

    In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b, but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits of their respective policies.

    How many passwords are valid according to their policies?

    --- Part Two ---
    While it appears you validated the passwords correctly, they don't seem to be what the Official Toboggan Corporate Authentication System is expecting.

    The shopkeeper suddenly realizes that he just accidentally explained the password policy rules from his old job at the sled rental place down the street! The Official Toboggan Corporate Policy actually works a little differently.

    Each policy actually describes two positions in the password, where 1 means the first character, 2 means the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!) Exactly one of these positions must contain the given letter. Other occurrences of the letter are irrelevant for the purposes of policy enforcement.

    Given the same example list from above:

    1-3 a: abcde is valid: position 1 contains a and position 3 does not.
    1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
    2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
    How many passwords are valid according to the new interpretation of the policies?
     */

    public static void main(String[] args) {
        try {
            Path path = Paths.get("C:\\Users\\Ricco\\IdeaProjects\\AdventOfCode\\AdventOfCode2020\\src\\Day02\\input_day2.txt");
            List<String> instructions = Files.readAllLines(path);

            solution1(instructions);
            solution2(instructions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solution1(List<String> instructions) throws IOException {
        int count = 0;
        for (String s : instructions) {
            String[] array = s.split(":");
            if (isValid(array[0], array[1].trim())) count++;
        }
        System.out.println("Amount of valid passwords are: " + count);
    }

    private static void solution2(List<String> instructions) {
        int count = 0;
        for (String s : instructions) {
            String[] array = s.split(":");
            if (isValid2(array[0], array[1].trim())) count++;
        }
        System.out.println("Amount of valid passwords are: " + count);
    }

    private static boolean isValid(String rule, String password) {
        Pattern p = Pattern.compile(rule.split(" ")[1]);
        Matcher m = p.matcher(password);

        String values = rule.split(" ")[0];
        int min = Integer.parseInt(values.split("-")[0]);
        int max = Integer.parseInt(values.split("-")[1]);

        int count = 0;
        while (m.find()) count++;

        return count >= min && count <= max;
    }

    private static boolean isValid2(String rule, String password) {
        String p = rule.split(" ")[1];
        String values = rule.split(" ")[0];
        int pos1 = Integer.parseInt(values.split("-")[0]);
        int pos2 = Integer.parseInt(values.split("-")[1]);

        return password.substring(pos1-1, pos1).equals(p) ^ password.substring(pos2-1, pos2).equals(p);
    }
}
