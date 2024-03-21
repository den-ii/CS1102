package Unit6.Motorcycle;

import Unit6.Vehicle;

/**
 * Represents a motorcycle with its properties and functionalities.
 * Implements both the Vehicle and MotorVehicle interfaces.
 */
public class Motorcycle implements Vehicle, MotorVehicle {

    private int numberOfWheels;
    private String type;
    private String make;
    private String model;
    private int manufactureYear;

    /**
     * Constructs a new Motorcycle object with the given make and model.
     *
     * @param make  the make of the motorcycle
     * @param model the model of the motorcycle
     */
    public Motorcycle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    /**
     * Retrieves the number of wheels of the motorcycle.
     *
     * @return the number of wheels of the motorcycle
     */
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    /**
     * Sets the number of wheels of the motorcycle.
     *
     * @param numberOfWheels the number of wheels to set
     */
    @Override
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    /**
     * Retrieves the type of the motorcycle.
     *
     * @return the type of the motorcycle
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the motorcycle.
     *
     * @param type the type to set
     * @return true if the type was successfully set, false otherwise
     */
    @Override
    public boolean setType(String type) {
        return switch (type) {
            case "sport", "cruiser", "off-road" -> {
                this.type = type;
                yield true;
            }
            default -> false;
        };
    }

    /**
     * Retrieves the make of the motorcycle.
     *
     * @return the make of the motorcycle
     */
    @Override
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the motorcycle.
     *
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Retrieves the model of the motorcycle.
     *
     * @return the model of the motorcycle
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the motorcycle.
     *
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Retrieves the manufacture year of the motorcycle.
     *
     * @return the manufacture year of the motorcycle
     */
    @Override
    public int getManufactureYear() {
        return manufactureYear;
    }

    /**
     * Sets the manufacture year of the motorcycle.
     *
     * @param manufactureYear the manufacture year to set
     */
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
}
