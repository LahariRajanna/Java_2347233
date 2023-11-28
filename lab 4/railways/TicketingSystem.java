package railways;

public interface TicketingSystem {
    void bookTicket(String passengerName, int seatNumber);

    void cancelTicket(int seatNumber);

    void displayTicketDetails(int seatNumber);
}
