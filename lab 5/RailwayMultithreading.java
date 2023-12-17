import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RailwayReservationSystem {
    private int availableSeats;

    public RailwayReservationSystem(int totalSeats) {
        this.availableSeats = totalSeats;
    }

    public synchronized void bookTicket(String passengerName, int numSeats) {
        if (numSeats <= availableSeats) {
            System.out.println(passengerName + " booked " + numSeats + " seat(s).");

            // Write booked seats to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(passengerName + "_Booking.txt"))) {
                for (int i = 1; i <= numSeats; i++) {
                    writer.write("Seat " + i + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            availableSeats -= numSeats;
        } else {
            System.out.println(passengerName + " couldn't book " + numSeats + " seat(s). Not enough seats available.");
        }
    }
}

class Passenger implements Runnable {
    private String name;
    private int numSeats;
    private RailwayReservationSystem reservationSystem;

    public Passenger(String name, int numSeats, RailwayReservationSystem reservationSystem) {
        this.name = name;
        this.numSeats = numSeats;
        this.reservationSystem = reservationSystem;
    }

    @Override
    public void run() {
        reservationSystem.bookTicket(name, numSeats);
    }
}

public class RailwayMultithreading {
    public static void main(String[] args) {
        int totalSeats = 25; // Total seats available on the train
        RailwayReservationSystem reservationSystem = new RailwayReservationSystem(totalSeats);

        ExecutorService executor = Executors.newFixedThreadPool(5); // 5 threads representing 5 passengers

        // Creating and executing passenger threads
        for (int i = 1; i <= 5; i++) {
            Passenger passenger = new Passenger("Passenger-" + i, 5, reservationSystem); // Each passenger wants to book 5 seats
            executor.execute(passenger);
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
