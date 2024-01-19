import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class SocialMediaForm extends JFrame {

    private static final String[] RELIGION_OPTIONS = { "Hindu", "Muslim", "Christian", "Sikh", "Prefer not to say" };
    private static final String[] INTEREST_OPTIONS = { "Art", "Technology", "Music", "Dance", "Sports" };

    public SocialMediaForm() {
        setTitle("Social Media Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        JPanel personalInfoPanel = createPersonalInfoPanel();
        JPanel interestsPanel = createInterestsPanel();

        setLayout(new GridLayout(1, 2));
        add(personalInfoPanel);
        add(interestsPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createPersonalInfoPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));
        panel.setBorder(BorderFactory.createTitledBorder("Personal Information"));

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(15);
        addTooltip(firstNameField, "First Name is mandatory");

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(15);
        addTooltip(lastNameField, "Last Name is mandatory");

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField(15);
        phoneField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        addTooltip(phoneField, "Phone Number is mandatory");

        JLabel emailLabel = new JLabel("Email ID:");
        JTextField emailField = new JTextField(15);
        addTooltip(emailField, "Email ID is mandatory. Must be in proper format");

        JLabel religionLabel = new JLabel("Religion:");
        JComboBox<String> religionComboBox = new JComboBox<>(RELIGION_OPTIONS);
        addTooltip(religionComboBox, "Religion is mandatory");

        JLabel dobLabel = new JLabel("Date of Birth (DD/MM/YYYY):");
        JTextField dobField = new JTextField(15);
        addTooltip(dobField, "Date of Birth is mandatory");

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validatePersonalInfo(firstNameField, lastNameField, phoneField,
                        emailField, religionComboBox, dobField);
            }
        });

        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(religionLabel);
        panel.add(religionComboBox);
        panel.add(dobLabel);
        panel.add(dobField);
        panel.add(submitButton);

        return panel;
    }

    private JPanel createInterestsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2 + INTEREST_OPTIONS.length)); // Increased columns for additional checkboxes
        panel.setBorder(BorderFactory.createTitledBorder("Interests"));

        ButtonGroup interestGroup = new ButtonGroup();
        JRadioButton artRadioButton = new JRadioButton("Art");
        JRadioButton technologyRadioButton = new JRadioButton("Technology");

        interestGroup.add(artRadioButton);
        interestGroup.add(technologyRadioButton);

        JLabel otherInterestsLabel = new JLabel("What other interests would you like to take up?");
        JCheckBox musicCheckbox = new JCheckBox("Music");
        JCheckBox danceCheckbox = new JCheckBox("Dance");
        JCheckBox sportsCheckbox = new JCheckBox("Sports");
        JCheckBox readingCheckbox = new JCheckBox("Reading");
        JCheckBox cookingCheckbox = new JCheckBox("Cooking");

        JLabel freeTimeLabel = new JLabel("What do you do in free time?");
        JTextArea freeTimeArea = new JTextArea(4, 15);
        JScrollPane scrollPane = new JScrollPane(freeTimeArea);

        JLabel hobbiesLabel = new JLabel("Hobbies:");
        JTextField hobbiesField = new JTextField(15);

        JButton submitInterestsButton = new JButton("Submit Interests");
        submitInterestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedInterest = getSelectedInterest(interestGroup);
                List<String> additionalInterests = getAdditionalInterests(musicCheckbox, danceCheckbox, sportsCheckbox,
                        readingCheckbox, cookingCheckbox);
                submitInterests(selectedInterest, additionalInterests, hobbiesField.getText(), freeTimeArea.getText());
            }
        });

        panel.add(artRadioButton);
        panel.add(technologyRadioButton);
        panel.add(otherInterestsLabel);
        panel.add(musicCheckbox);
        panel.add(danceCheckbox);
        panel.add(sportsCheckbox);
        panel.add(readingCheckbox);
        panel.add(cookingCheckbox);
        panel.add(freeTimeLabel);
        panel.add(scrollPane);
        panel.add(hobbiesLabel);
        panel.add(hobbiesField);
        panel.add(submitInterestsButton);

        return panel;
    }

    private void validatePersonalInfo(JTextField firstName, JTextField lastName, JTextField phone,
            JTextField email, JComboBox<String> religion, JTextField dob) {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() ||
                phone.getText().isEmpty() || email.getText().isEmpty() ||
                religion.getSelectedItem().toString().isEmpty() || dob.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All personal information fields are mandatory.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidEmail(email.getText())) {
            JOptionPane.showMessageDialog(this, "Email ID is not in proper format.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validateAge(dob.getText())) {
            JOptionPane.showMessageDialog(this, "Minimum age required is 20 years.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Personal information submitted successfully!",
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void submitInterests(String selectedInterest, List<String> additionalInterests,
            String hobbies, String freeTimeActivities) {
        System.out.println("Interests submitted:");
        System.out.println("Selected Interest: " + selectedInterest);
        System.out.println("Additional Interests: " + additionalInterests);
        System.out.println("Free Time Activities: " + freeTimeActivities);
        System.out.println("Hobbies: " + hobbies);

    }

    private List<String> getAdditionalInterests(JCheckBox... checkboxes) {
        List<String> selectedInterests = new ArrayList<>();
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                selectedInterests.add(checkbox.getText());
            }
        }
        return selectedInterests;
    }

    private String getSelectedInterest(ButtonGroup group) {
        // Get the selected radio button from the ButtonGroup
        Enumeration<AbstractButton> buttons = group.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    private boolean validateAge(String dob) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = sdf.parse(dob);
            Calendar dobCalendar = Calendar.getInstance();
            dobCalendar.setTime(birthDate);

            Calendar currentDate = Calendar.getInstance();

            int age = currentDate.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);
            if (currentDate.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
                age--;
            }

            return age >= 20;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private void addTooltip(JComponent component, String tooltipText) {
        component.setToolTipText(tooltipText);
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (component.isEnabled() && !component.getToolTipText().isEmpty()) {
                    ToolTipManager.sharedInstance().mouseEntered(e);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ToolTipManager.sharedInstance().mouseExited(e);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SocialMediaForm());
    }
}
