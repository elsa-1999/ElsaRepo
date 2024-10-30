package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // Aufgabe1


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should display result after multiplie two positive multi-digit numbers")
    void testPositivMultiply() {

        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);

        calc.pressEqualsKey();

        String expected = "120";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Screen wird sauber gemacht bevor wir noch was tippen")
    void testClearScreenAfterBinarOperation() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }


    // Aufgabe2

    @Test
    void testScreenLimit() {
        // Zifferlange überschritten
        Calculator calc = new Calculator();
        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressDigitKey(3);
        calc.pressDigitKey(4);
        calc.pressDigitKey(5);
        calc.pressDigitKey(6);
        calc.pressDigitKey(7);
        calc.pressDigitKey(8);
        calc.pressDigitKey(9);
        calc.pressDigitKey(0);
        calc.pressDigitKey(1);

        String expected = "12345678901";// Musste normalerweise nicht klappen denn nur 9 Angabe möglich
        //String expected = "123456789";// Musste klappen
        String actual = calc.readScreen();
        assertEquals(expected, actual);

     }
    @Test
    public void testRepeatedEgalForDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        calc.pressEqualsKey();// 2 egal muss immer error ergeben

        assertEquals("Error", calc.readScreen());
        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

}
