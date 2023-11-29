import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define an interface for managing trains
interface TrainManagement {
    void addTrain(Train train);

    void viewTrains();
}

// Train class
class Train {
    private String name;
    private String number;

    public Train(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Train: " + name + ", Number: " + number;
    }
}

// TrainManager class implementing TrainManagement interface
class TrainManager implements TrainManagement {
    private List<Train> trains;

    public TrainManager(List<Train> trains) {
        this.trains = trains;
    }

    @Override
    public void addTrain(Train train) {
        trains.add(train);
    }

    @Override
    public void viewTrains() {
        if (trains.isEmpty()) {
            System.out.println("No trains available.");
        } else {
            System.out.println("List of Trains:");
            for (Train train : trains) {
                System.out.println(train);
            }
        }
    }
}

// Main class
public class RailwayManagementSystem {
    public static void main(String[] args) {
        // Use TrainManagement interface
        TrainManagement trainManager = new TrainManager(new ArrayList<>());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Railway Management System");
            System.out.println("1. Add Train");
            System.out.println("2. View Trains");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Train Name: ");
                    String trainName = scanner.nextLine();
                    System.out.print("Enter Train Number: ");
                    String trainNumber = scanner.nextLine();
                    trainManager.addTrain(new Train(trainName, trainNumber));
                    System.out.println("Train added successfully!");
                    break;
                case 2:
                    trainManager.viewTrains();
                    break;
                case 3:
                    System.out.println("Exiting Railway Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
