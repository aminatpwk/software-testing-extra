package tdd_tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tdd.RomanNumeralConverter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RomanNumberConverterTest {
    RomanNumeralConverter roman = new RomanNumeralConverter();
    int number;

    @ParameterizedTest
    @CsvSource({"I,1", "V,5", "X,10", "L,50", "C,100", "D,500", "M,1000"})
    void testConvert_oneCharNumbers(String romanNumeral, int numberExpected) {
        number = roman.convert(romanNumeral);
        assertThat(number).isEqualTo(numberExpected);
    }

    @ParameterizedTest
    @CsvSource({"II,2", "III,3","VI,6","XVIII,18", "XXIII,23", "DCCLXVI, 766"})
    void testConvert_multipleCharNumbers(String romanNumeral, int numberExpected) {
        number = roman.convert(romanNumeral);
        assertThat(number).isEqualTo(numberExpected);
    }

    @ParameterizedTest
    @CsvSource({"IV,4", "XIV, 14", "XL, 40", "XLI, 41", "XXCXIV, 294"})
    void testConvert_subtractiveNotation(String romanNumeral, int numberExpected) {
        number = roman.convert(romanNumeral);
        assertThat(number).isEqualTo(numberExpected);
    }
}
