package Unit6;

import Unit6.Car.Car;
import Unit6.Motorcycle.Motorcycle;
import Unit6.Truck.Truck;

import java.util.Scanner;

/**
 * This class manages the information of vehicles in the system.
 */
public class VehicleSystemInformation {
    /**
     * Main method to run the vehicle system information program.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String logo = """     
                                             VEHICLE SYSTEM INFORMATION
                                                          .------.
                                                         :|||""\"`.`.
                                                         :|||     7.`.
                                      .===+===+===+===+===||`----L7'-`7`---.._
                                      []                  || ==       |       ""\"-.
                                      []...._____.........||........../ _____ ____|
                                     c\\____/,---.\\_       ||_________/ /,---.\\_  _/
                                       /_,-/ ,-. \\ `._____|__________||/ ,-. \\ \\_[
                                          /\\ `-' /                    /\\ `-' /
                                            `---'                       `---'
                """;
        System.out.println(logo);
        // Create a scanner object to get user input
        Scanner scanner = new Scanner(System.in);
        // Flag to control looping
        boolean shouldLoop = true;
        do{
            // Prompt user to input the vehicle type
            System.out.println("Type the vehicle type do you want to add to the system (Car, Motorcycle, Truck): ");
            shouldLoop = handleVehicles(scanner.nextLine().toLowerCase());
            System.out.println("Add another vehicle (Y or N)");
             if(!scanner.nextLine().equalsIgnoreCase("y")){
                 shouldLoop = false;
                 System.out.println("exiting...");
             };

        } while (shouldLoop);
    }

    /**
     * Handles the selection of vehicle type.
     * @param vehicle The type of vehicle selected.
     * @return True if the program should continue, false otherwise.
     */
    private static boolean handleVehicles(String vehicle){
        Scanner scanner = new Scanner(System.in);
        switch (vehicle){
            case "car":
                return handleCar(scanner);
            case "motorcycle":
                return handleMotorcycle(scanner);
            case "truck":
                return handleTruck(scanner);
            default:
                System.out.println("❌ Enter a valid vehicle");
                return true;

        }
    }

    /**
     * Handles the addition of car information.
     * @param scanner Scanner object to get user input.
     * @return True if the program should continue, false otherwise.
     */
    private static boolean handleCar(Scanner scanner){
        String carMake = handleInvalidString("Enter Car Make: ", scanner);

        String carModel = handleInvalidString("Enter Car Model: ", scanner);

        Car car = new Car(carMake, carModel);

        int numberOfDoors = handleInvalidInt("Enter the number of doors: ", scanner);
        int carManufactureYear = handleInvalidYear("Enter Car Manufacture Year: ", scanner);
        boolean fuelTypeSet = false;
        while (!fuelTypeSet){
            System.out.println("Enter the car's type of fuel (petrol, diesel, electric): ");
            String fuelType = scanner.nextLine();

            fuelTypeSet = car.setFuelType(fuelType);

            if (!fuelTypeSet) {
                System.out.println("Invalid fuel type.");
            }
        }
        car.setNumberOfDoors(numberOfDoors);
        car.setManufactureYear(carManufactureYear);

        System.out.println("\nCar Details");
        System.out.println("Car Make: "+ car.getMake());
        System.out.println("Car Model: "+ car.getModel());
        System.out.println("Number of doors: "+ car.getNumberOfDoors());
        System.out.println("Manufacture Year: "+ car.getManufactureYear());
        System.out.println("Car Fuel Type: "+ car.getFuelType());
        System.out.println("-".repeat(30));

        return true;
    }

    /**
     * Handles the addition of motorcycle information.
     * @param scanner Scanner object to get user input.
     * @return True if the program should continue, false otherwise.
     */
    private static boolean handleMotorcycle(Scanner scanner){
        String motorcycleMake = handleInvalidString("Enter Motorcycle Make: ", scanner);

        String motorcycleModel = handleInvalidString("Enter Motorcycle Model: ", scanner);

        Motorcycle motorcycle = new Motorcycle(motorcycleMake, motorcycleModel);

        int numberOfWheels = handleInvalidInt("Enter the number of wheels: ", scanner);
        int manufactureYear = handleInvalidYear("Enter Manufacture Year: ", scanner);
        boolean typeSet = false;
        while (!typeSet){
            System.out.println("Enter the type (sport, cruiser, off-road): ");
            String fuelType = scanner.nextLine();
            typeSet = motorcycle.setType(fuelType);

            if (!typeSet) {
                System.out.println("Invalid motorcycle type.");
            }
        }
        motorcycle.setNumberOfWheels(numberOfWheels);
        motorcycle.setManufactureYear(manufactureYear);

        System.out.println("\nMotorcycle Details");
        System.out.println("Motorcycle Make: "+ motorcycle.getMake());
        System.out.println("Motorcycle Model: "+ motorcycle.getModel());
        System.out.println("Number of Wheels: "+ motorcycle.getNumberOfWheels());
        System.out.println("Manufacture Year: "+ motorcycle.getManufactureYear());
        System.out.println("Motorcycle Type: "+ motorcycle.getType());
        System.out.println("-".repeat(30));

        return true;
    }

    /**
     * Handles the addition of truck information.
     * @param scanner Scanner object to get user input.
     * @return True if the program should continue, false otherwise.
     */
    private static boolean handleTruck(Scanner scanner){
        String truckMake = handleInvalidString("Enter Truck Make: ", scanner);

        String truckModel = handleInvalidString("Enter Truck Model: ", scanner);

        Truck truck = new Truck(truckMake, truckModel);

        double cargoCapacity = handleInvalidDouble("Enter the Cargo Capacity (Tonnes): ", scanner);
        int manufactureYear = handleInvalidYear("Enter Manufacture Year: ", scanner);
        boolean transmissionTypeSet = false;
        while (!transmissionTypeSet){
            System.out.println("Enter the transmission type (manual, automatic): ");
            String transmissionType = scanner.nextLine();
            transmissionTypeSet = truck.setTransmissionType(transmissionType);

            if (!transmissionTypeSet) {
                System.out.println("Invalid transmission type.");
            }
        }
        truck.setCargoCapacity(cargoCapacity);
        truck.setManufactureYear(manufactureYear);

        System.out.println("\nTruck Details");
        System.out.println("Truck Make: "+ truck.getMake());
        System.out.println("Truck Model: "+ truck.getModel());
        System.out.println("Cargo Capacity: "+ truck.getCargoCapacity());
        System.out.println("Manufacture Year: "+ truck.getManufactureYear());
        System.out.println("Truck Transmission Type: "+ truck.getTransmissionType());
        System.out.println("-".repeat(30));

        return true;
    }

    /**
     * Helper method - Handles invalid string input.
     * @param label The label to display for user input.
     * @param scanner Scanner object to get user input.
     * @return The valid input string.
     */
    private static String handleInvalidString(String label, Scanner scanner){
          String input;
          boolean shouldLoop = false;
          do{
              System.out.println(label);
              input = scanner.nextLine();
              if (input.isBlank()){
                  shouldLoop = true;
                  System.out.println("Enter a valid input");
              } else {
                  shouldLoop = false;
              }
          } while (shouldLoop);
        return input;
    }

    /**
     * Helper method - Handles invalid integer input.
     * @param label The label to display for user input.
     * @param scanner Scanner object to get user input.
     * @return The valid input integer.
     */
    private static int handleInvalidInt(String label, Scanner scanner){
        int input = 0;
        boolean shouldLoop = false;
        do{
            System.out.println(label);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input == 0){
                    shouldLoop = true;
                    System.out.println("Enter a valid input");
                } else {
                    shouldLoop = false;
                }
            } catch (Exception e){
                shouldLoop = true;
                System.out.println("Enter a valid input");
            }
        } while (shouldLoop);

        return input;
    }

    /**
     * Handles invalid double input.
     * @param label The label to display for user input.
     * @param scanner Scanner object to get user input.
     * @return The valid input double.
     */
    private static double handleInvalidDouble(String label, Scanner scanner){
        double input = 0;
        boolean shouldLoop = false;
        do{
            System.out.println(label);
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input == 0){
                    shouldLoop = true;
                    System.out.println("Enter a valid input");
                } else {
                    shouldLoop = false;
                }
            } catch (Exception e){
                shouldLoop = true;
                System.out.println("Enter a valid input");
            }
        } while (shouldLoop);

        return input;
    }

    /**
     * Handles invalid year input.
     * @param label The label to display for user input.
     * @param scanner Scanner object to get user input.
     * @return The valid input year.
     */
    private static int handleInvalidYear(String label, Scanner scanner){
        int input = 0;
        boolean shouldLoop = false;
        do{
            System.out.println(label);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 1880 || input > 2025){
                    shouldLoop = true;
                    System.out.println("Enter a valid year (1880 - 2025)");
                } else {
                    shouldLoop = false;
                }
            } catch (Exception e){
                shouldLoop = true;
                System.out.println("Enter a valid year (1880 - 2025)");
            }
        } while (shouldLoop);

        return input;
    }
}
