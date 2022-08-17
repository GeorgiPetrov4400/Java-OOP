package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private String[] NAMES = {"Joro", "Simona", "Siyana", "Martin"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_CreateListIterator_ShouldThrowException() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void test_HasNextIndex() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void test_MoveFromCurrentIndexToNextIndex() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void test_PrintEmptyList_ShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void test_PrintSuccess() {
        int index = 0;
        while (listIterator.hasNext()) {
            assertEquals(NAMES[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}