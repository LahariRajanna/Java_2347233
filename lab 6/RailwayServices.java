// New interface representing additional details for railway services
interface RailwayServiceDetails {
    String getServiceDetails();
}

interface Orderable {
    String getName();

    double getPrice();
}

// Generic class representing a RailwayServiceItem
class RailwayServiceItem<T extends RailwayServiceDetails & Orderable> {
    private T service;

    public RailwayServiceItem(T service) {
        this.service = service;
    }

    public T getService() {
        return service;
    }

    public void displayServiceDetails() {
        System.out.println("Service: " + service.getName());
        System.out.println("Price: Rs" + service.getPrice());
        System.out.println("Additional Details: " + service.getServiceDetails());
    }
}

// Concrete class representing a railway ticket
class RailwayTicket implements Orderable, RailwayServiceDetails {
    private String passengerName;
    private double ticketPrice;
    private String destination;

    public RailwayTicket(String passengerName, double ticketPrice, String destination) {
        this.passengerName = passengerName;
        this.ticketPrice = ticketPrice;
        this.destination = destination;
    }

    @Override
    public String getName() {
        return "Railway Ticket";
    }

    @Override
    public double getPrice() {
        return ticketPrice;
    }

    @Override
    public String getServiceDetails() {
        return "Passenger: " + passengerName + ", Destination: " + destination;
    }
}

// Concrete class representing a refreshment service
class RefreshmentService implements Orderable, RailwayServiceDetails {
    private String serviceName;
    private double servicePrice;
    private String menu;

    public RefreshmentService(String serviceName, double servicePrice, String menu) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.menu = menu;
    }

    @Override
    public String getName() {
        return serviceName;
    }

    @Override
    public double getPrice() {
        return servicePrice;
    }

    @Override
    public String getServiceDetails() {
        return "Menu: " + menu;
    }
}

public class RailwayServices {
    public static void main(String[] args) {
        // Creating a railway ticket
        RailwayTicket trainTicket = new RailwayTicket("Lahari", 1200, "Bengaluru to Mangaluru");

        // Creating a refreshment service
        RefreshmentService snackService = new RefreshmentService("Snack Service", 80, "Sandwich and Juice");

        // Creating railway service items using generics
        RailwayServiceItem<RailwayTicket> ticketServiceItem = new RailwayServiceItem<>(trainTicket);
        RailwayServiceItem<RefreshmentService> refreshmentServiceItem = new RailwayServiceItem<>(snackService);

        // Displaying railway service item details
        System.out.println("Railway Ticket Service Item:");
        ticketServiceItem.displayServiceDetails();

        System.out.println("\nRefreshment Service Item:");
        refreshmentServiceItem.displayServiceDetails();
    }
}
