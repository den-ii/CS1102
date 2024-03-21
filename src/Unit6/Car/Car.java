package Unit6.Car;

import Unit6.Vehicle;

/**
 * Represents a car with basic properties such as make, model, number of doors, fuel type, and manufacture year.
 * Implements the {@link CarVehicle} interface.
 */
public class Car implements CarVehicle {

    /** The number of doors of the car. */
    private int numberOfDoors;

    /** The type of fuel used by the car. */
    private String fuelType;

    /** The make of the car. */
    private String make;

    /** The model of the car. */
    private String model;

    /** The year when the car was manufactured. */
    private int manufactureYear;

    /**
     * Constructs a new car with the specified make and model.
     * @param make The make of the car.
     * @param model The model of the car.
     */
    public Car(String make, String model){
        this.make = make;
        this.model = model;
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void setNumberOfDoors(int value) {
        numberOfDoors = value;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    @Override
    public boolean setFuelType(String fuel) {
        return switch (fuel) {
            case "petrol", "diesel", "electric" -> {
                fuelType = fuel;
                yield true;
            }
            default ->  false;
        };
    }

    @Override
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the car.
     * @param make The make of the car.
     */
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    /**
     * Sets the model of the car.
     * @param model The model of the car.
     */
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public int getManufactureYear() {
        return manufactureYear;
    }

    /**
     * Sets the manufacture year of the car.
     * @param manufactureYear The manufacture year of the car.
     */
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
}
