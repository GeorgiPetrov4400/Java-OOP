package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] NUMBERS = {8, 18, 21, 29, 30};

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void test_CreateDatabase() throws OperationNotSupportedException {
        Integer[] databaseElement = database.getElements();
        Assert.assertEquals(NUMBERS.length, databaseElement.length);

        //   Assert.assertArrayEquals(numbers, databaseElement);

        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals(NUMBERS[i], databaseElement[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_CreateDatabaseFailed_AndThrowException() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_CreateArrayWithMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] integerArray = new Integer[17];
        database = new Database(integerArray);
    }

    @Test
    public void test_AddElementToNextFreeCell() throws OperationNotSupportedException {
        int initialSize = database.getElements().length;
        database.add(10);
        Integer[] elementsFromDatabase = database.getElements();
        int lastElementFromDatabase = elementsFromDatabase[elementsFromDatabase.length - 1];

        Assert.assertEquals(10, lastElementFromDatabase);
        Assert.assertEquals(initialSize + 1, elementsFromDatabase.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddNullElement_ShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_RemoveElementAtTheLastIndex() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(NUMBERS.length - 1, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_RemoveNonExistingIndex() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}