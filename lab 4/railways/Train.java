// RailwaySystem.java
package railways;

public interface Transportation {
    void start();

    void stop();

    void announceArrival();
}

// TicketingSystem.java
package railways;

public interface TicketingSystem {
    void bookTicket(String passengerName, int seatNumber);

    void cancelTicket(int seatNumber);

    void displayTicketDetails(int seatNumber);
}

// Train.java
package railways;

public class Train implements Transportation, TicketingSystem {
    private String trainName;
    private int totalSeats;
    private boolean[] seatAvailability;

    // Constructor
    public Train(String trainName, int totalSeats) {
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.seatAvailability = new boolean[totalSeats];
        // Initially, all seats are available
        for (int i = 0; i < totalSeats; i++) {
            seatAvailability[i] = true;
        }
    }

    // Implementation of methods from the Transportation interface
    @Override
    public void start() {
        System.out.println(trainName + " is starting its journey.");
    }

    @Override
    public void stop() {
        System.out.println(trainName + " has reached its destination and is stopping.");
    }

    @Override
    public void announceArrival() {
        System.out.println(trainName + " has arrived at the station.");
    }

    // Implementation of methods from the TicketingSystem interface
    @Override
    public void bookTicket(String passengerName, int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= totalSeats && seatAvailability[seatNumber - 1]) {
            seatAvailability[seatNumber - 1] = false;
            System.out.println("Ticket booked for " + passengerName + " - Seat Number: " + seatNumber);
        } else {
            System.out.println("Seat " + seatNumber + " is not available.");
        }
    }

    @Override
    public void cancelTicket(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= totalSeats && !seatAvailability[seatNumber - 1]) {
            seatAvailability[seatNumber - 1] = true;
            System.out.println("Ticket canceled - Seat Number: " + seatNumber);
        } else {
            System.out.println("Invalid seat number or seat is already available.");
        }
    }

    @Override
    public void displayTicketDetails(int seatNumber) {
        if (seatNumber >= 1 && seatNumber <= totalSeats) {
            System.out.println("Ticket Details - Train: " + trainName + ", Seat Number: " + seatNumber +
                    ", Status: " + (seatAvailability[seatNumber - 1] ? "Available" : "Booked"));
        } else {
            System.out.println("Invalid seat number.");
        }
    }
}

// Main class
public class RailwaySystem {
    public static void main(String[] args) {
        // Creating a train
        Train expressTrain = new Train("Express 123", 50);

        // Train operations
        expressTrain.start();
        expressTrain.bookTicket("John Doe", 5);
        expressTrain.bookTicket("Jane Smith", 10);
        expressTrain.displayTicketDetails(5);
        expressTrain.displayTicketDetails(15);
        expressTrain.cancelTicket(10);
        expressTrain.displayTicketDetails(10);
        expressTrain.announceArrival();
        expressTrain.stop();
    }
}
