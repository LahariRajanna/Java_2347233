class Train {
    private String trainNumber;
    private String trainName;
    private int totalSeats;

    // Default constructor
    public Train() {
        this.trainNumber = "Unknown";
        this.trainName = "Unknown";
        this.totalSeats = 0;
    }

    // Parameterized constructor 
    public Train(String trainNumber, String trainName, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
    }

    // Method 
    public void bookTicket(int numPassengers) {
        if (numPassengers <= totalSeats) {
            totalSeats -= numPassengers;
            System.out.println(numPassengers + " tickets booked successfully!");
        } else {
            System.out.println("Insufficient seats. Booking failed.");
        }
    }

    // Method overloading 
    public void bookTicket() {
        bookTicket(1); 
    }

    // Method overloading
    public void bookTicket(String passengerName) {
        System.out.println("Ticket booked for passenger: " + passengerName);
    }

    // Method overloading
    public void bookTicket(String passengerName, int numPassengers) {
        System.out.println("Booking " + numPassengers + " tickets for passenger " + passengerName);
        bookTicket(numPassengers);
    }

    // Display train details
    public void displayTrainDetails() {
        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Available Seats: " + totalSeats);
    }

    public static void main(String[] args) {
        Train expressTrain = new Train("12345", "Rajdhani Express", 200);

        expressTrain.bookTicket(); 
        expressTrain.bookTicket("ABC"); 
        expressTrain.bookTicket("PQR", 3); 

        expressTrain.displayTrainDetails();
    }
}
