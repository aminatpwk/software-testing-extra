package book_exercises_tests;

import book_exercises.StringLeftPad;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static java.lang.ProcessHandle.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringLeftPadTests {
    private StringLeftPad string = new StringLeftPad();

    /**
     * Specification-testing/ black-box testing: ne baze te parametrave te metodes, do krijohen partitions.
     * Nga partitions do nxirren boundaries.
     * Testet e nxjerra: str null, str empty, size negativ, padStr null, padStr empty, padStr vetem 1 karakter,
     * size = str.length, size = 0, size < str.length, padStr me e madhe se hapesirat e stringes, padStr me e vogel se
     * hapesirat e stringes, padStr e barabarte me hapesirat e stringes
     * (3 testet e fundit jane shtese per t plotesuar coverage)
     */

    @Test
    void testStringLeftPad_strNull(){
        String result = string.leftPad(null, 10, "-");
        assertEquals(null, result);
    }

    @Test
    void testStringLeftPad_strEmpty(){
        String result = string.leftPad("", 5, "-");
        assertEquals("-----", result);
    }

    @Test
    void testStringLeftPad_negativeSize(){
        String result = string.leftPad("abc", -5, "-");
        assertEquals("abc",result);
    }

    @Test
    void testStringLeftPad_padStrNull(){
        String result = string.leftPad("abc", 3, null);
        assertEquals("abc",result);
    }

    @Test
    void testStringLeftPad_padStrEmpty(){
        String result = string.leftPad("abc", 3, "");
        assertEquals("abc",result);
    }

    @Test
    void testStringLeftPad_padStrOneCharacterOnly(){
        String result = string.leftPad("abc", 5, "a");
        assertEquals("aaabc",result);
    }

    @Test
    void testStringLeftPad_sizeEqualsToStringLength(){
        String result = string.leftPad("abc", 3, "a");
        assertEquals("abc",result);
    }

    @Test
    void testStringLeftPad_sizeEqualsToZero(){
        String result = string.leftPad("abc", 0, "a");
        assertEquals("abc",result);
    }

    @Test
    void testStringLeftPad_sizeLessThanStringLength(){
        String result = string.leftPad("abc", 2, "a");
        assertEquals("abc",result);
    }

    @Test
    void testStringLeftPad_padStrEqualsToStringLength(){
        String result = string.leftPad("abc", 5, "--");
        assertEquals("--abc",result);
    }

    @Test
    void testStringLeftPad_padStrSmallerThanStringLength(){
        String result = string.leftPad("abc", 5, "-");
        assertEquals("--abc",result);
    }

    @Test
    void testStringLeftPad_padStrGreaterThanStringLength(){
        String result = string.leftPad("abc", 5, "---");
        assertEquals("--abc",result);
    }
}
