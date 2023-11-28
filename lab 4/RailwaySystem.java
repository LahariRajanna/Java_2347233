
// RailwaySystem.java
import railways.Train;

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
