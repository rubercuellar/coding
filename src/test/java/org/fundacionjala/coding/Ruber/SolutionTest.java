package org.fundacionjala.coding.Ruber;

import org.fundacionjala.coding.Ruber.Exam.Kata;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

/**
 * Unit test.
 */
public class SolutionTest {
    static final double[] EXPECTED_RESULT_1 = new double[] {2, 2, 2, 2};
    static final double[] EXPECTED_RESULT_2 = new double[] {0, 0, 0, 0};
    static final double[] EXPECTED_RESULT_3 = new double[] {2, 4, 3, -4.5};
    static final int[] ACTUAL_RESULT_1 = new int[] {2, 2, 2, 2, 2};
    static final int[] ACTUAL_RESULT_2 = new int[] {2, -2, 2, -2, 2};
    static final int[] ACTUAL_RESULT_3 = new int[] {1, 3, 5, 1, -10};


    /**
     * Basic test.
     */
    @Test
    public void basicTests() {

        assertEquals(Arrays.toString(EXPECTED_RESULT_1), Arrays.toString(Kata.averages(ACTUAL_RESULT_1)));
        assertEquals(Arrays.toString(EXPECTED_RESULT_2), Arrays.toString(Kata.averages(ACTUAL_RESULT_2)));
        assertEquals(Arrays.toString(EXPECTED_RESULT_3), Arrays.toString(Kata.averages(ACTUAL_RESULT_3)));
    }

    /**
     * Null Empty Tests.
     */
    @Test
    public void nullEmptyTests() {

        assertEquals("Array with only one value as input should return an empty array", 0,
                Kata.averages(new int[] {2}).length);
        assertEquals("input 'null' should return an empty array", 0, Kata.averages(null).length);
        assertEquals("Empty array as input should return an empty array", 0, Kata.averages(new int[0]).length);



    }

}
