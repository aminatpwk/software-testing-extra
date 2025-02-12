package book_exercises_tests;

import book_exercises.Clumps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClumpsTests {
    private Clumps clumps = new Clumps();

    /**
     * Three + one (3 minimumi, 1 per boundary testing) tests are enough to achieve 100% branch coverage.
     * Test caset: empty array, null array, array me clump ne mes, array vetem me nje element
     */
    @Test
    void testCountClumps_emptyArray(){
        int count = clumps.countClumps(new int[]{});
        assertEquals(0, count);
    }

    @Test
    void testCountClumps_nullArray(){
        int count = clumps.countClumps(null);
        assertEquals(0, count);
    }

    @Test
    void testCountClumps_arrayWithClumps(){
        int count = clumps.countClumps(new int[]{0,1,1,1,0});
        assertEquals(1, count); //1 sepse nje clump duhet te kete gjatesine me te madhe se 2 per t'u quajtur i tille
    }

    @Test
    void testCountClumps_oneElementArray(){
        int count = clumps.countClumps(new int[]{0});
        assertEquals(0, count);
    }
}
