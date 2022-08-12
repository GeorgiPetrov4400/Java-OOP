package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;

    @Before
    public void setup() {
        house = new House("PetrovCasa", 8);
    }

    @Test
    public void test_SetNameSuccess() {
        house = new House("Hacienda", 13);

        Assert.assertEquals(13, house.getCapacity());
        Assert.assertEquals("Hacienda", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void test_SetNameWithWhiteSpace_Failed() {
        house = new House(" ", 13);
    }

    @Test(expected = NullPointerException.class)
    public void test_SetNameWithNull_Failed() {
        house = new House(null, 13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetNegativeCapacity_Failed() {
        house = new House("Hacienda", -13);
    }

    @Test
    public void test_AddCatAndCountSuccess() {
        Cat cat = new Cat("Simona");

        house.addCat(cat);

        Assert.assertTrue(cat.isHungry());
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCatFullCapacity_Failed() {
        House house = new House("Hacienda", 1);
        Cat cat = new Cat("Simona");
        Cat cat2 = new Cat("Siyana");

        house.addCat(cat);
        house.addCat(cat2);
    }

    @Test
    public void test_RemoveExistingCat_Success() {
        Cat cat = new Cat("Simona");
        Cat cat2 = new Cat("Marti");
        house.addCat(cat);
        house.addCat(cat2);

        house.removeCat("Marti");

        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveNonExistingCat_Failed() {
        Cat cat = new Cat("Simona");
        Cat cat2 = new Cat("Marti");
        house.addCat(cat);
        house.addCat(cat2);

        house.removeCat("Siyana");

        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveNullCat_Failed() {
        house.removeCat(null);
    }

    @Test
    public void test_ReturnCatForSell_Success() {
        Cat cat = new Cat("Simona");
        Cat cat2 = new Cat("Marti");

        house.addCat(cat);
        house.addCat(cat2);

        Cat catForSale = house.catForSale("Simona");
       // catForSale.setHungry(false);

        Assert.assertFalse(catForSale.isHungry());
        Assert.assertEquals("Simona", catForSale.getName());
        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ReturnCatForSell_FailedWithNonExistingName() {
        Cat cat = new Cat("Simona");
        Cat cat2 = new Cat("Marti");

        Cat catForSale = house.catForSale("Siyana");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ReturnCatForSell_FailedWithNull() {

        Cat catForSale = house.catForSale(null);
    }

    @Test
    public void test_GetStatistics() {
        Cat cat = new Cat("Simona");
        Cat cat2 = new Cat("Siyana");

        house.addCat(cat);
        house.addCat(cat2);

        String getStatistics = house.statistics();

        Assert.assertEquals("The cat Simona, Siyana is in the house PetrovCasa!", getStatistics);
    }
}
