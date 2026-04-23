import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberToLetterCombinator {
    private static final Map<Character, String> dictionary = new HashMap<>();

    public NumberToLetterCombinator() {
        dictionary.put('2', "abc");
        dictionary.put('3', "def");
        dictionary.put('4', "ghi");
        dictionary.put('5', "jkl");
        dictionary.put('6', "mno");
        dictionary.put('7', "pqrs");
        dictionary.put('8', "tuv");
        dictionary.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> letters = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return letters;
        }

        if (!isValid(digits)) {
            throw new IllegalArgumentException("Invalid input! Numbers must be between 2 and 9 and max 4 characters!");
        }

        recursion(digits, 0, "", letters);
        return MergeSorter.sort(letters);
    }

    private void recursion(String digits, int idx, String current, List<String> letters) {
        if (idx == digits.length()) {
            letters.add(current);
            return;
        }
        String possibleLetters = dictionary.get(digits.charAt(idx));

        for (char letter : possibleLetters.toCharArray()) {
            recursion(digits, idx + 1, current + letter, letters);
        }
    }

    private static boolean isValid(String input) {
        if (input.length() > 4) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (c < '2' || c > '9') {
                return false;
            }
        }

        return true;
    }
}
