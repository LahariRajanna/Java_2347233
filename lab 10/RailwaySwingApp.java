import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RailwaySwingApp extends JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/train_lahari";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private JTextField trainNumberField;
    private JTextArea resultArea;

    public RailwaySwingApp() {
        setTitle("Railway Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel trainNumberLabel = new JLabel("Train Number:");
        trainNumberField = new JTextField();
        JButton searchButton = new JButton("Search");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        panel.add(trainNumberLabel);
        panel.add(trainNumberField);
        panel.add(searchButton);
        panel.add(resultArea);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTrain();
            }
        });

        add(panel);
    }

    private void searchTrain() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection
                        .prepareStatement("SELECT * FROM trains WHERE train_number = ?")) {
            int trainNumber = Integer.parseInt(trainNumberField.getText());
            preparedStatement.setInt(1, trainNumber);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String destination = resultSet.getString("destination");
                int availableSeats = resultSet.getInt("available_seats");

                resultArea.setText("Train Number: " + trainNumber + "\nDestination: " + destination
                        + "\nAvailable Seats: " + availableSeats);
            } else {
                resultArea.setText("Train not found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RailwaySwingApp app = new RailwaySwingApp();
                app.setVisible(true);
            }
        });
    }
}
