package org.fundacionjala.coding.Ruber.BankOcr;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ruber Cuellar on 6/21/2017.
 */
public class AccountNumbersTest {

    /**
     * Test valid number.
     */
    @Test
    public void testAccountNumbersValidNumberNine() {
        // given
        final String[] numbersRead = {" _ "
            + " _|"
            + " _|", "   "
            + "|_|"
            + "  |", " _ "
            + "|_ "
            + " _|", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_|"
            + "|_|", " _ "
            + " _| "
            + "|_ ", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_ "
            + "|_|", " _ "
            + "|_ "
            + " _|"
        };

        // when
        final String actualResult = AccountNumbers.validate(AccountNumbers.convert(numbersRead));

        // then
        final String expectedResult = "345882865";
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test valid number.
     */
    @Test
    public void testAccountNumbersEigthDigits() {
        // given
        final String[] numbersRead = {" _ "
            + " _|"
            + " _|", "   "
            + "|_|"
            + "  |", " _ "
            + "|_ "
            + " _|", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_|"
            + "|_|", " _ "
            + " _| "
            + "|_ ", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_ "
            + "|_|"
        };

        // when
        final String actualResult = AccountNumbers.validate(AccountNumbers.convert(numbersRead));

        // then
        final String expectedResult = "";
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test valid number.
     */
    @Test
    public void testAccountNumbersInvalidNumbers() {
        // given
        final String[] numbersRead = {" _ "
            + " _|"
            + " _|", "   "
            + "|_"
            + "  |", " _ "
            + "|_ "
            + " _|", " _ "
            + "|_ "
            + "|_|", " _ "
            + "|_|"
            + "|_|", " _ "
            + " _| "
            + "|_ ", " _ "
            + "|_|"
            + "|_", " _ "
            + "|_ "
            + "|_|", " _ "
            + "|_ "
            + " _|"
        };

        // when
        final String actualResult = AccountNumbers.validate(AccountNumbers.convert(numbersRead));

        // then
        final String expectedResult = "3?5682?65 ILL";
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test valid number.
     */
    @Test
    public void testAccountNumbersWithInvalidCheckSum() {
        // given
        final String[] numbersRead = {" _ "
            + " _|"
            + " _|", "   "
            + "|_|"
            + "  |", " _ "
            + "|_ "
            + " _|", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_|"
            + "|_|", " _ "
            + " _| "
            + "|_ ", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_ "
            + "|_|", " _ "
            + "|_ "
            + "|_|"
        };

        // when
        final String actualResult = AccountNumbers.validate(AccountNumbers.convert(numbersRead));

        // then
        final String expectedResult = "345882866 ERR";
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Test.
     */
    @Test
    public void exists() {
        // Given
        String value = "123?123";

        // When
        String actualResult = AccountNumbers.exists(value);
        String expectedResult = "?";

        // Then
        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * Test.
     */
    @Test
    public void noExists() {
        // Given
        String value = "123123";

        // When
        String actualResult = AccountNumbers.exists(value);
        System.out.println(actualResult);
        String expectedResult = "?";

        // Then
        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * Test.
     */
    @Test
    public void convert() {
        // Given
        final String[] numbersRead = {" _ "
            + " _|"
            + " _|", "   "
            + "|_|"
            + "  |", " _ "
            + "|_ "
            + " _|", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_|"
            + "|_|", " _ "
            + " _| "
            + "|_ ", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_ "
            + "|_|", " _ "
            + "|_ "
            + "|_|"
        };

        // When
        StringBuilder actualResult = AccountNumbers.convert(numbersRead);
        String expectedResult = "345882866";

        // Then
        Assert.assertEquals(actualResult.toString(), expectedResult);
    }

    /**
     * Test.
     */
    @Test
    public void validAccount() {
        // Given
        final String[] numbersRead = {" _ "
            + " _|"
            + " _|", "   "
            + "|_|"
            + "  |", " _ "
            + "|_ "
            + " _|", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_|"
            + "|_|", " _ "
            + " _| "
            + "|_ ", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_ "
            + "|_|", " _ "
            + "|_ "
            + " _|"
        };

        // When
        StringBuilder result = AccountNumbers.convert(numbersRead);
        boolean actualResult = AccountNumbers.validAccount(result);

        // Then
        Assert.assertTrue(actualResult);
    }

    /**
     * Test.
     */
    @Test
    public void validate() {
        // Given
        final String[] numbersRead = {" _ "
            + " _|"
            + " _|", "   "
            + "|_|"
            + "  |", " _ "
            + "|_ "
            + " _|", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_|"
            + "|_|", " _ "
            + " _| "
            + "|_ ", " _ "
            + "|_|"
            + "|_|", " _ "
            + "|_ "
            + "|_|", " _ "
            + "|_ "
            + "|_|"
        };

        // When
        StringBuilder result = AccountNumbers.convert(numbersRead);
        String actualResult = AccountNumbers.validate(result);
        String expectedResult = "345882866 ERR";

        // Then
        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * Constructor test.
     * @throws Exception Exception
     */
    @Test
    public void testConstructor() throws Exception {
        Constructor accountNumbersConstructor = AccountNumbers.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isPrivate(accountNumbersConstructor.getModifiers()));
        accountNumbersConstructor.setAccessible(true);
        accountNumbersConstructor.newInstance();
    }
}
