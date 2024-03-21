package Unit6.Motorcycle;

import Unit6.Vehicle;

/**
 * The MotorVehicle interface extends the Vehicle interface, adding methods specific to motorcycles.
 * It requires implementations to provide functionality for getting and setting the number of wheels and the type of motorcycle.
 */
public interface MotorVehicle extends Vehicle {


    /**
     *
     * @return number of wheels a mortocyle have
     */
    int getNumberOfWheels();

    /**
     *  set the number of wheels of a Motorcycle instance
     * @param numberOfWheels
     */
    void setNumberOfWheels(int numberOfWheels);

    /**
     * Get a type of Mortocycle
     */
    String getType();

    /**
     * Set a mortocycle type
     * @param type
     * @return true if successfully setType, otherwise done
     */
    boolean setType(String type);
}
