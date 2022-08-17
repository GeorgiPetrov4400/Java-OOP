package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    @Before
    public void setup() throws OperationNotSupportedException {
        Person person1 = new Person(1, "Pesho");
        Person person2 = new Person(2, "Gosho");
        database = new Database(person1, person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindByUsername_ShouldThrowException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void test_FindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("Gosho");
        assertEquals("Gosho", person.getUsername());
        assertEquals(2, person.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindUsernameIfDoesntExist() throws OperationNotSupportedException {
        Person person = database.findByUsername("Ivan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_FindUserById_ShouldThrowException() throws OperationNotSupportedException {
        database.findById(100);
    }

    @Test
    public void test_FindUserById() throws OperationNotSupportedException {
        Person person = database.findById(2);
        assertEquals("Gosho", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddNullPerson_ShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void test_AddPerson() throws OperationNotSupportedException {
        Person person = new Person(3, "Tosho");
        database.add(person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_AddPersonOutOfBound_ShouldThrowException() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        database = new Database(people);
    }

    @Test
    public void test_RemoveExistingPerson() throws OperationNotSupportedException {
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_RemoveNonExistingPerson_ShouldThrowException() throws OperationNotSupportedException {
        int databaseLength = database.getElements().length;
        for (int i = 0; i < databaseLength; i++) {
            database.remove();
        }
        database.remove();
    }
}