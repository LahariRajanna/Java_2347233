@FunctionalInterface
interface TravelTimeCalculator {
    double calculateTravelTime(double distance, double speed);
}

class Train {
    private String name;

    public Train(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Method that takes a TravelTimeCalculator lambda expression as a parameter
    public double calculateJourneyTime(double distance, TravelTimeCalculator calculator) {
        return calculator.calculateTravelTime(distance, getSpeed());
    }

    // A method to get the speed of the train
    private double getSpeed() {
        return 100.0; // Speed in kilometers per hour
    }
}

public class RailwayLambda {
    public static void main(String[] args) {
        Train expressTrain = new Train("Express123");

        // Lambda expression to calculate travel time based on distance and speed
        TravelTimeCalculator travelTimeLambda = (distance, speed) -> distance / speed;

        // Calculate and display travel time for a specific distance
        double distance = 300.0; // Distance in kilometers
        double travelTime = expressTrain.calculateJourneyTime(distance, travelTimeLambda);

        System.out.println("Train: " + expressTrain.getName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Travel Time: " + travelTime + " hours");
    }
}
