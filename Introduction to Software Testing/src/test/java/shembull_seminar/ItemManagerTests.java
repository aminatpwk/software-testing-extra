package shembull_seminar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemManagerTests {
    public ItemManager itemManager;

    @BeforeEach
    public void setUp() {
        itemManager = new ItemManager();
    }

    @Test
    public void testAddItem_emptyItem() {
        itemManager.addItem("");
        assertEquals(0, itemManager.getItems().size(), "The list should contain no items.");
    }

    @Test
    void testAddItem_nullItem() {
        itemManager.addItem(null);
        assertEquals(0, itemManager.getItems().size(), "The list should contain no items.");
    }

    @Test
    void testAddItem_validItem(){
        itemManager.addItem("test");
        assertEquals(1, itemManager.getItems().size(), "The list should contain one item.");
    }
}
