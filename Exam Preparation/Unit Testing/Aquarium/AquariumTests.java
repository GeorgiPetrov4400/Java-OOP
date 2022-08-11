package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private Aquarium aquarium;

    @Before
    public void setup() {
        aquarium = new Aquarium("Aqua", 8);
    }

    @Test
    public void test_CreateAquariumSuccess() {

        Assert.assertEquals("Aqua", aquarium.getName());
        Assert.assertEquals(8, aquarium.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateAquariumWithNullFailed() {
        Aquarium aquarium = new Aquarium(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_CreateAquariumWithWhitespace() {
        Aquarium aquarium = new Aquarium(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateAquariumWithNegativeCapacityFailed() {
        Aquarium aquarium = new Aquarium("Pazardzhik", -5);
    }

    @Test
    public void test_CreateAquariumAndAddFishSuccess() {
        Fish fish = new Fish("Siyana");

        aquarium.add(fish);

        Assert.assertEquals(1, aquarium.getCount());
        Assert.assertEquals(8, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateAquariumAndAddFish_FailedFullCapacity() {
        Aquarium aquarium = new Aquarium("Aquatonic", 1);
        Fish fish = new Fish("Siyana");
        aquarium.add(fish);
        Fish fish2 = new Fish("Joro");
        aquarium.add(fish2);
    }

    @Test
    public void test_RemoveFishFromAquariumSuccess() {
        Fish fish = new Fish("Joro");
        aquarium.add(fish);
        Fish fish2 = new Fish("Simona");
        aquarium.add(fish2);
        Fish fish3 = new Fish("Marti");
        aquarium.add(fish3);

        Assert.assertEquals(3, aquarium.getCount());

        aquarium.remove("Marti");

        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveFishFromAquariumFailed() {
        Fish fish = new Fish("Joro");
        aquarium.add(fish);
        Fish fish2 = new Fish("Simona");
        aquarium.add(fish2);
        Fish fish3 = new Fish("Marti");
        aquarium.add(fish3);

        Assert.assertEquals(3, aquarium.getCount());

        aquarium.remove("Siyana");

        Assert.assertEquals(3, aquarium.getCount());
    }

    @Test
    public void test_SellExistingFish() {
        Fish fish = new Fish("Joro");
        aquarium.add(fish);
        Fish fish2 = new Fish("Simona");
        aquarium.add(fish2);

        Fish fishToSell = aquarium.sellFish("Simona");
        boolean available = fishToSell.isAvailable();

        Assert.assertFalse(available);
        Assert.assertEquals("Simona", fishToSell.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SellNonExistingFish() {
        Fish fish = new Fish("Joro");
        aquarium.add(fish);
        Fish fish2 = new Fish("Simona");
        aquarium.add(fish2);

        Fish fishToSell = aquarium.sellFish("Marti");
    }

    @Test
    public void test_AquariumReport() {
        Fish fish = new Fish("Joro");
        aquarium.add(fish);
        Fish fish2 = new Fish("Simona");
        aquarium.add(fish2);

        String report = aquarium.report();

        Assert.assertEquals("Fish available at Aqua: Joro, Simona", report);
    }
}

