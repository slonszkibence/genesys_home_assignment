import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NumberToLetterCombinator combinator = new NumberToLetterCombinator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a number combination (2-9), max 4 characters!");
        System.out.println("For exit write: 'exit'");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                System.out.println("Bye!");
                break;
            }

            try {
                List<String> result = combinator.letterCombinations(input);
                System.out.println("Combination: " + result);
                System.out.println("Size: " + result.size());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
