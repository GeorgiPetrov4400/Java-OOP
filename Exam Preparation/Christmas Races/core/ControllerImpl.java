package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {

//        Driver driverFound = driverRepository.getAll()
//                .stream().filter(d -> d.getClass().getSimpleName().equals(driver))
//                .findFirst()
//                .orElse(null);

        Driver driverFound = driverRepository.getByName(driver);

        if (driverFound != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        Driver nonExistingDriver = new DriverImpl(driver);
        driverRepository.add(nonExistingDriver);

        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        String carType = null;

//        Car existCar = carRepository.getAll()
//                .stream()
//                .filter(c -> c.getClass().getSimpleName().equals(model))
//                .findFirst()
//                .orElse(null);

        Car existCar = carRepository.getByName(model);

        if (existCar != null) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                carType = "MuscleCar";
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                carType = "SportsCar";
                break;
        }

        carRepository.add(car);

        return String.format(CAR_CREATED, carType, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {

//        Driver existDriver = driverRepository.getAll()
//                .stream()
//                .filter(d -> d.getClass().getSimpleName().equals(driverName))
//                .findFirst()
//                .orElse(null);

        Driver existDriver = driverRepository.getByName(driverName);

        if (existDriver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }
//
//        Car existCar = carRepository.getAll()
//                .stream()
//                .filter(c -> c.getClass().getSimpleName().equals(carModel))
//                .findFirst()
//                .orElse(null);

        Car existCar = carRepository.getByName(carModel);

        if (existCar == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        existDriver.addCar(existCar);

        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {

//        Race existRace = raceRepository.getAll().stream()
//                .filter(race -> race.getClass().getSimpleName().equals(raceName))
//                .findFirst()
//                .orElse(null);

        Race existRace = raceRepository.getByName(raceName);

        if (existRace == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

//        Driver existDriver = driverRepository.getAll().stream()
//                .filter(d -> d.getClass().getSimpleName().equals(driverName))
//                .findFirst()
//                .orElse(null);

        Driver existDriver = driverRepository.getByName(driverName);

        if (existDriver == null) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        existRace.addDriver(existDriver);

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {

//        Race existingRace = raceRepository.getAll()
//                .stream()
//                .filter(r -> r.getName().equals(raceName))
//                .findFirst()
//                .orElse(null);

        Race existingRace = raceRepository.getByName(raceName);

        if (existingRace == null) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        if (existingRace.getDrivers().stream().filter(Driver::getCanParticipate).count() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        List<Driver> driverSortedList = existingRace.getDrivers()
                .stream()
                .sorted((d1, d2) -> Double.compare(d2.getCar().calculateRacePoints(existingRace.getLaps()),
                        d1.getCar().calculateRacePoints(existingRace.getLaps())))
                .collect(Collectors.toList());

        return String.format(DRIVER_FIRST_POSITION, driverSortedList.get(0).getName(), raceName) + System.lineSeparator() +
                String.format(DRIVER_SECOND_POSITION, driverSortedList.get(1).getName(), raceName) + System.lineSeparator() +
                String.format(DRIVER_THIRD_POSITION, driverSortedList.get(2).getName(), raceName);
    }

    @Override
    public String createRace(String name, int laps) {

        Race existRace = raceRepository.getByName(name);

        if (existRace != null) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        Race race = new RaceImpl(name, laps);

//        for (Race existingRace : raceRepository.getAll()) {
//            if (existingRace.equals(race)) {
//                throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
//            }
//        }

        raceRepository.add(race);

        return String.format(RACE_CREATED, name);
    }
}
