package Unit6.Truck;

import Unit6.Vehicle;

/**
 * Represents a truck vehicle with its properties and functionalities.
 * Extends the Vehicle interface.
 */
public interface TruckVehicle extends Vehicle {

    /**
     * Retrieves the cargo capacity of the truck.
     *
     * @return the cargo capacity of the truck
     */
    double getCargoCapacity();

    /**
     * Sets the cargo capacity of the truck.
     *
     * @param capacity the cargo capacity to set
     */
    void setCargoCapacity(double capacity);

    /**
     * Retrieves the transmission type of the truck.
     *
     * @return the transmission type of the truck
     */
    String getTransmissionType();

    /**
     * Sets the transmission type of the truck.
     *
     * @param transmissionType the transmission type to set
     * @return true if the transmission type was successfully set, false otherwise
     */
    boolean setTransmissionType(String transmissionType);
}
