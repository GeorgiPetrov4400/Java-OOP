package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {

    @Test
    public void test_CreateNewFarm() {
        Farm farm = new Farm("Fermata", 8);
        Assert.assertEquals("Fermata", farm.getName());
        Assert.assertEquals(8, farm.getCapacity());
        Assert.assertEquals(0, farm.getCount());
    }

    @Test
    public void test_CreateNewFarmAndAnimal() {
        Farm farm = new Farm("Fermata", 8);
        Animal animal = new Animal("Goat", 5);

        farm.add(animal);

        Assert.assertEquals(1, farm.getCount());
        Assert.assertEquals("Fermata", farm.getName());
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateNewFarm_WithNullNameFailed() {
        Farm farm = new Farm(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateNewFarm_WithEmptyNameFailed() {
        Farm farm = new Farm("", 8);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateNewFarm_WithWhitespaceNameFailed() {
        Farm farm = new Farm("  ", 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateNewFarmWithNegativeCapacity() {
        Farm farm = new Farm("Fermata", -9);
    }

    @Test
    public void test_FarmAddAnimalSuccess() {
        Farm farm = new Farm("Fermata", 1);
        Animal animal = new Animal("Goat", 5);

        farm.add(animal);

        Assert.assertEquals(1, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FarmWithFullCapacity() {
        Farm farm = new Farm("Fermata", 1);
        Animal animal = new Animal("Goat", 5);
        farm.add(animal);
        Animal animal2 = new Animal("Donkey", 50);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FarmAddExistingAnimal() {
        Farm farm = new Farm("Fermata", 5);
        Animal animal = new Animal("Goat", 5);
        farm.add(animal);
        Animal animal2 = new Animal("Donkey", 50);
        farm.add(animal2);
        Animal animal3 = new Animal("Goat", 5);
        farm.add(animal3);
    }

    @Test
    public void test_FarmRemoveExistingAnimal() {
        Farm farm = new Farm("Fermata", 5);
        Animal animal = new Animal("Goat", 5);
        farm.add(animal);
        Animal animal2 = new Animal("Donkey", 50);
        farm.add(animal2);

        Assert.assertTrue(farm.remove(animal.getType()));
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void test_FarmRemoveNonExistingAnimal() {
        Farm farm = new Farm("Fermata", 5);
        Animal animal = new Animal("Goat", 5);
        farm.add(animal);
        Animal animal2 = new Animal("Donkey", 50);
//        farm.add(animal2);
//        farm.remove("Sheep");

        Assert.assertFalse(farm.remove(animal2.getType()));
        Assert.assertEquals(1, farm.getCount());
    }
}
