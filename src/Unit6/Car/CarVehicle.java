package Unit6.Car;

import Unit6.Vehicle;

/**
 * The {@code CarVehicle} interface represents a vehicle that is a car.
 * It extends the {@link Vehicle} interface and provides methods specific to cars.
 */
public interface CarVehicle extends Vehicle {

    /**
     * Gets the number of doors of the car.
     *
     * @return the number of doors of the car
     */
    int getNumberOfDoors();

    /**
     * Sets the number of doors of the car.
     *
     * @param value the number of doors to set
     */
    void setNumberOfDoors(int value);

    /**
     * Gets the type of fuel used by the car.
     *
     * @return the type of fuel used by the car
     */
    String getFuelType();

    /**
     * Sets the type of fuel used by the car.
     *
     * @param fuel the type of fuel to set
     * @return {@code true} if the fuel type was set successfully, {@code false} otherwise
     */
    boolean setFuelType(String fuel);

}
