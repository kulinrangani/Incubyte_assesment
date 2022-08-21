import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorShould {
    StringCalculator sc;

    @Before
    public void initializeResouces() {
        sc = new StringCalculator();
    }

    @Test
    public void returnZeroIfStringIsEmpty() {
        assertEquals(0, sc.add(""));
    }

    @Test
    public void returnSumIfStringIsNotEmpty() {
        assertEquals(12, sc.add("5,7"));
    }

    @Test
    public void returnZeroIfStringHasOnlySpaces() {
        assertEquals(0, sc.add("   "));
    }

    @Test
    public void handelAnUnkownAmountOfNumbers() {
        assertEquals(670, sc.add("100, 30, 90, 50, 400"));
    }
}
