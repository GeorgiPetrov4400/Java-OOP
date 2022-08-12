package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GarageTests {

    private Garage garage;

    @Before
    public void setup() {
        garage = new Garage();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetUnmodifiableList() {
        List<Car> carList = garage.getCars();
        carList.remove(1);
    }

    @Test
    public void test_GetCount() {
        Car car = new Car("Mazda", 260, 10000);

        garage.addCar(car);

        Assert.assertEquals(1, garage.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddCarWithNullFailed() {
        Car car = null;

        garage.addCar(car);
    }

    @Test
    public void test_FindAllCarsWithMaxSpeedAbove() {
        Car car = new Car("Mazda", 260, 10000);
        Car car2 = new Car("Honda", 240, 11000);
        Car car3 = new Car("Mercedes", 180, 3000);
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);

        List<Car> allCarsWithMaxSpeedAbove = garage.findAllCarsWithMaxSpeedAbove(200);

        Assert.assertEquals(2, allCarsWithMaxSpeedAbove.size());
        Assert.assertEquals("Mazda", allCarsWithMaxSpeedAbove.get(0).getBrand());
        Assert.assertEquals("Honda", allCarsWithMaxSpeedAbove.get(1).getBrand());
    }

    @Test
    public void test_GetTheMostExpensiveCar() {
        Car car = new Car("Mazda", 260, 10000);
        Car car2 = new Car("Honda", 240, 11000);
        Car car3 = new Car("Mercedes", 180, 3000);
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);

        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();

        Assert.assertEquals("Honda", theMostExpensiveCar.getBrand());
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void test_GetTheMostExpensiveCar_FailedWithNull() {
//        Car car = new Car("Mazda", 260, 10000);
//        Car car2 = new Car("Honda", 240, 10000);
//        Car car3 = new Car("Mercedes", 180, 10000);
//        garage.addCar(car);
//        garage.addCar(car2);
//        garage.addCar(car3);
//
//        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();
//
//       // Assert.assertEquals(null, theMostExpensiveCar.getBrand());
//    }

    @Test
    public void test_FindAllCarsByBrand() {
        Car car = new Car("Mazda", 260, 10000);
        Car car2 = new Car("Honda", 240, 11000);
        Car car3 = new Car("Mercedes", 180, 3000);
        garage.addCar(car);
        garage.addCar(car2);
        garage.addCar(car3);

        List<Car> allCarsByBrand = garage.findAllCarsByBrand("Mercedes");

        Assert.assertEquals("Mercedes", allCarsByBrand.get(0).getBrand());
    }
}