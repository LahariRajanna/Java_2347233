import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Train {
    private String trainNumber;
    private String trainName;

    public Train(String trainNumber, String trainName) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }
}

class Station {
    private String stationCode;
    private String stationName;

    public Station(String stationCode, String stationName) {
        this.stationCode = stationCode;
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public String getStationName() {
        return stationName;
    }
}

class Ticket {
    private String ticketNumber;
    private Train train;
    private Station sourceStation;
    private Station destinationStation;

    public Ticket(String ticketNumber, Train train, Station sourceStation, Station destinationStation) {
        this.ticketNumber = ticketNumber;
        this.train = train;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Train getTrain() {
        return train;
    }

    public Station getSourceStation() {
        return sourceStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }
}

public class RailwaysSwingApp {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            RailwaysSwingApp window = new RailwaysSwingApp();
            window.frame.setVisible(true);
        });
    }

    public RailwaysSwingApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Railways Management System");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        frame.setContentPane(contentPane);

        JTextArea outputTextArea = new JTextArea();
        contentPane.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        // Create a list of trains
        List<Train> trains = new ArrayList<>();
        trains.add(new Train("101", "Express Train 1"));
        trains.add(new Train("102", "Local Train A"));
        trains.add(new Train("103", "Superfast Train X"));

        // Create a HashMap of stations
        Map<String, Station> stations = new HashMap<>();
        stations.put("S001", new Station("S001", "Bangalore"));
        stations.put("S002", new Station("S002", "Mysore"));
        stations.put("S003", new Station("S003", "Mangalore"));

        // Create a list of tickets
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket("T001", trains.get(0), stations.get("S001"), stations.get("S003")));
        tickets.add(new Ticket("T002", trains.get(1), stations.get("S002"), stations.get("S001")));
        tickets.add(new Ticket("T003", trains.get(2), stations.get("S003"), stations.get("S002")));

        // Display information in the JTextArea
        outputTextArea.append("Trains:\n");
        for (Train train : trains) {
            outputTextArea.append(train.getTrainNumber() + " - " + train.getTrainName() + "\n");
        }

        outputTextArea.append("\nStations:\n");
        for (Station station : stations.values()) {
            outputTextArea.append(station.getStationCode() + " - " + station.getStationName() + "\n");
        }

        outputTextArea.append("\nTickets:\n");
        for (Ticket ticket : tickets) {
            outputTextArea.append(ticket.getTicketNumber() + " - " +
                    "Train: " + ticket.getTrain().getTrainNumber() +
                    ", Source: " + ticket.getSourceStation().getStationName() +
                    ", Destination: " + ticket.getDestinationStation().getStationName() + "\n");
        }
    }
}
