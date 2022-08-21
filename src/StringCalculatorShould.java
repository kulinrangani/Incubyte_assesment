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

}
