import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NumberToLetterCombinatorTest {
    private NumberToLetterCombinator combinator;

    @Before
    public void setUp() {
        combinator = new NumberToLetterCombinator();
    }

    @Test
    public void testEmptyInput() {
        List<String> result = combinator.letterCombinations("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullInput() {
        List<String> result = combinator.letterCombinations(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testOneLetterCombination() {
        List<String> result = combinator.letterCombinations("2");
        assertEquals(List.of("a", "b", "c"), result);
        assertEquals(3, result.size());
    }

    @Test
    public void testTwoLetterCombination() {
        List<String> result = combinator.letterCombinations("23");
        assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result);
        assertEquals(9, result.size());
    }
    @Test
    public void testThreeLetterCombination() {
        List<String> result = combinator.letterCombinations("234");
        assertEquals(List.of("adg", "adh", "adi", "aeg", "aeh", "aei",
                "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg",
                "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"), result);
        assertEquals(27, result.size());
    }

    @Test
    public void testSeven() {
        List<String> result = combinator.letterCombinations("7");
        assertEquals(List.of("p", "q", "r", "s"), result);
        assertEquals(4, result.size());
    }

    @Test
    public void testNine() {
        List<String> result = combinator.letterCombinations("9");
        assertEquals(List.of("w", "x", "y", "z"), result);
        assertEquals(4, result.size());
    }

    @Test
    public void testNotDigitsInput() {
        assertThrows(IllegalArgumentException.class, () -> combinator.letterCombinations("abc"));
    }

    @Test
    public void testFiveDigitsInput() {
        assertThrows(IllegalArgumentException.class, () -> combinator.letterCombinations("23456"));
    }

    @Test
    public void testMixedInput() {
        assertThrows(IllegalArgumentException.class, () -> combinator.letterCombinations("23c"));
    }

    @Test
    public void testMultipleCallsDoNotInterfere() {
        List<String> first = combinator.letterCombinations("2");
        List<String> second = combinator.letterCombinations("3");
        assertEquals(3, first.size());
        assertEquals(3, second.size());
    }
}
