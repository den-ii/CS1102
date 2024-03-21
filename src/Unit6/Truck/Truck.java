package Unit6.Truck;

/**
 * Represents a truck with its properties and functionalities.
 * Implements the TruckVehicle interface.
 */
public class Truck implements TruckVehicle {

    private double cargoCapacity;
    private String transmissionType;
    private String make;
    private String model;
    private int manufactureYear;

    /**
     * Constructs a Truck object with the specified make and model.
     *
     * @param make  the make of the truck
     * @param model the model of the truck
     */
    public Truck(String make, String model) {
        this.make = make;
        this.model = model;
    }

    /**
     * Retrieves the cargo capacity of the truck.
     *
     * @return the cargo capacity of the truck
     */
    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * Sets the cargo capacity of the truck.
     *
     * @param cargoCapacity the cargo capacity to set
     */
    @Override
    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Retrieves the transmission type of the truck.
     *
     * @return the transmission type of the truck
     */
    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    /**
     * Sets the transmission type of the truck.
     *
     * @param transmissionType the transmission type to set
     * @return true if the transmission type was successfully set, false otherwise
     */
    @Override
    public boolean setTransmissionType(String transmissionType) {
        return switch (transmissionType) {
            case "manual", "automatic" -> {
                this.transmissionType = transmissionType;
                yield true;
            }
            default -> false;
        };
    }

    /**
     * Retrieves the make of the truck.
     *
     * @return the make of the truck
     */
    @Override
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the truck.
     *
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Retrieves the model of the truck.
     *
     * @return the model of the truck
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the truck.
     *
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Retrieves the manufacture year of the truck.
     *
     * @return the manufacture year of the truck
     */
    @Override
    public int getManufactureYear() {
        return manufactureYear;
    }

    /**
     * Sets the manufacture year of the truck.
     *
     * @param manufactureYear the manufacture year to set
     */
    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }
}
