package book_exercises_tests;

import book_exercises.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTests {
    private LinkedList<String> list;

    /**
     * Line coverage me minimumin e case-ve. Test caset:
     * T1: objekti qe do behet remove eshte null; => kthe true
     * T2: objekti nuk eshte null, dhe ndodhet ne liste => kthe true
     * T3: objekti nuk eshte null, por nuk ndodhet ne liste => kthe false
     * T4: objekti nuk eshte null, por lista eshte empty => kthe false
     */

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testRemove_nullElement(){
        list.add(null);
        assertTrue(list.remove(null));
    }

    @Test
    void testRemove_elementInList(){
        list.add("a");
        list.add("m");
        list.add("i");
        assertTrue(list.remove("i"));
    }

    @Test
    void testRemove_elementNotInList(){
        list.add("a");
        list.add("m");
        list.add("i");
        assertFalse(list.remove("n"));
    }

    @Test
    void testRemove_emptyList(){
        assertFalse(list.remove("a"));
    }
}
