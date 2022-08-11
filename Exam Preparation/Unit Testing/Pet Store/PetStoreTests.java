package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    private PetStore petStore;

    @Before
    public void setup() {
        petStore = new PetStore();
    }

    @Test
    public void test_FindAllAnimalsWithMaxKilograms() {
        Animal animal = new Animal("Dog", 50, 200.0);
        petStore.addAnimal(animal);
        Animal animal2 = new Animal("Cat", 10, 100.0);
        petStore.addAnimal(animal2);
        Animal animal3 = new Animal("Elephant", 1000, 10000);
        petStore.addAnimal(animal3);
        List<Animal> animalsList = petStore.findAllAnimalsWithMaxKilograms(50);

        Assert.assertEquals("Elephant", animalsList.get(0).getSpecie());
    }

    @Test
    public void test_AddAnimalSuccess() {
        Assert.assertEquals(0, petStore.getCount());
        Animal animal = new Animal("Dog", 50, 200.0);
        petStore.addAnimal(animal);

        Assert.assertEquals(1, petStore.getCount());
        Assert.assertEquals("Dog", animal.getSpecie());
        Assert.assertEquals(50, animal.getMaxKilograms());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddNullAnimalFailed() {
        Animal nullAnimal = null;
        petStore.addAnimal(nullAnimal);

        Assert.assertEquals(0, petStore.getCount());
    }

    @Test
    public void test_GetTheMostExpensiveAnimal() {
        Animal animal = new Animal("Dog", 50, 200.0);
        petStore.addAnimal(animal);
        Animal animal2 = new Animal("Cat", 10, 100.0);
        petStore.addAnimal(animal2);

        Animal mostExpensiveAnimal = petStore.getTheMostExpensiveAnimal();

        Assert.assertEquals("Dog", mostExpensiveAnimal.getSpecie());
        Assert.assertEquals(animal.getPrice(), mostExpensiveAnimal.getPrice(), 0.0);
    }

    @Test
    public void test_FindAllAnimalBySpecie() {
        Animal animal = new Animal("Dog", 50, 200.0);
        petStore.addAnimal(animal);
        Animal animal2 = new Animal("Cat", 10, 100.0);
        petStore.addAnimal(animal2);

        List<Animal> foundedAnimalsBySpecie = petStore.findAllAnimalBySpecie("Cat");

        Assert.assertEquals("Cat", foundedAnimalsBySpecie.get(0).getSpecie());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetAnimals_ReturnUnmodifiableList() {
        List<Animal> animalList = petStore.getAnimals();
        animalList.remove(1);
    }

    @Test
    public void test_GetCount() {
        Assert.assertEquals(0, petStore.getCount());
        Animal animal = new Animal("Dog", 50, 200.0);
        petStore.addAnimal(animal);
        Assert.assertEquals(1, petStore.getCount());
    }
}

