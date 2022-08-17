package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setup() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void test_AddElement_EndOfList() {
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");

        Assert.assertEquals(2, customLinkedList.getCount());
    }

    @Test
    public void test_RemoveElementFromNode() {
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.remove("Pesho");
    }

    @Test
    public void test_RemoveMissingElementFromNode() {
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        int actualIndex = customLinkedList.remove("Ivan");

        Assert.assertEquals(-1, actualIndex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetMissingElementFromNode() {
        customLinkedList.get(8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetNegativeElementFromNode() {
        customLinkedList.get(-8);
    }

    @Test
    public void test_GetElementFromNode() {
        customLinkedList.add("Gosho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Pesho");
        String actualName = customLinkedList.get(1);
        Assert.assertEquals(actualName, "Tosho");
    }

    @Test
    public void test_RemoveElementAtGivenIndex() {
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        String foundElement = customLinkedList.get(1);
        customLinkedList.removeAt(1);

        Assert.assertEquals("Pesho", foundElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveAtGivenInvalidIndex() {
        customLinkedList.add("Gosho");
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.removeAt(8);
    }

    @Test
    public void test_SetElementToGivenIndex() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Ivan");
        customLinkedList.set(2, "Gosho");

        Assert.assertEquals(customLinkedList.get(2), "Gosho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetElementToInvalidIndex() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Ivan");
        customLinkedList.set(8, "Gosho");
    }

    @Test
    public void test_SearchElementInTheList() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Ivan");
        int actual = customLinkedList.indexOf("Tosho");

        Assert.assertEquals(1, actual);
    }

    @Test
    public void test_SearchElementInTheListNotFound() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Ivan");
        int actual = customLinkedList.indexOf("Gosho");

        Assert.assertEquals(-1, actual);
    }

    @Test
    public void test_CheckElementExistInTheList() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Gosho");

        Assert.assertTrue(customLinkedList.contains("Gosho"));
    }

    @Test
    public void test_RemoveListNode() {
        customLinkedList.add("Pesho");
        customLinkedList.add("Tosho");
        customLinkedList.add("Gosho");
        customLinkedList.removeAt(0);
        customLinkedList.removeAt(1);
        customLinkedList.removeAt(0);
    }
}