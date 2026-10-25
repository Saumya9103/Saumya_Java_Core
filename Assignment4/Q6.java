package Assignment4;

import java.awt.*;
import java.awt.event.*;

public class Q6 extends Frame implements ActionListener {

    TextField nameField, fatherField, ageField;
    TextArea addressArea;
    Choice courseChoice;

    CheckboxGroup genderGroup;
    Checkbox male, female;
    Checkbox drawing, singing, music, others;

    Button saveButton, clearButton;

    // Colors used in the form
    Color backgroundColor = new Color(35, 47, 62);
    Color panelColor = new Color(48, 62, 80);
    Color headingColor = new Color(255, 220, 80);
    Color buttonColor = new Color(40, 110, 230);

    Q6() {
        setTitle("Student Registration Form");
        setSize(700, 650);
        setLayout(new BorderLayout(10, 10));
        setBackground(backgroundColor);

        // ---------- Heading ----------
        Label heading = new Label(
                "STUDENT REGISTRATION FORM",
                Label.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 23));
        heading.setForeground(headingColor);
        heading.setBackground(backgroundColor);

        Panel headingPanel = new Panel(new BorderLayout());
        headingPanel.setBackground(backgroundColor);
        headingPanel.add(heading, BorderLayout.CENTER);
        headingPanel.setPreferredSize(new Dimension(700, 65));

        add(headingPanel, BorderLayout.NORTH);

        // ---------- Form Panel ----------
        Panel formPanel = new Panel(new GridBagLayout());
        formPanel.setBackground(panelColor);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 12, 10, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Name
        nameField = new TextField(25);
        addFormRow(formPanel, gbc, 0, "Name:", nameField);

        // Father Name
        fatherField = new TextField(25);
        addFormRow(formPanel, gbc, 1, "Father Name:", fatherField);

        // Age
        ageField = new TextField(25);
        addFormRow(formPanel, gbc, 2, "Age:", ageField);

        // Gender
        genderGroup = new CheckboxGroup();

        male = new Checkbox("Male", genderGroup, true);
        female = new Checkbox("Female", genderGroup, false);

        Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        genderPanel.setBackground(panelColor);
        genderPanel.add(male);
        genderPanel.add(female);

        addFormRow(formPanel, gbc, 3, "Gender:", genderPanel);

        // Course
        courseChoice = new Choice();
        courseChoice.add("Java");
        courseChoice.add("Python");
        courseChoice.add("C++");
        courseChoice.add("Web Development");
        courseChoice.add("Database Management");

        addFormRow(formPanel, gbc, 4, "Course:", courseChoice);

        // Hobbies
        drawing = new Checkbox("Drawing");
        singing = new Checkbox("Singing");
        music = new Checkbox("Music");
        others = new Checkbox("Others");

        Panel hobbyPanel = new Panel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        hobbyPanel.setBackground(panelColor);

        hobbyPanel.add(drawing);
        hobbyPanel.add(singing);
        hobbyPanel.add(music);
        hobbyPanel.add(others);

        addFormRow(formPanel, gbc, 5, "Hobbies:", hobbyPanel);

        // Address
        addressArea = new TextArea(4, 25);
        addFormRow(formPanel, gbc, 6, "Address:", addressArea);

        // ---------- Buttons ----------
        saveButton = new Button("Save Details");
        clearButton = new Button("Clear All");

        saveButton.setBackground(buttonColor);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));

        clearButton.setBackground(new Color(200, 65, 65));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));

        saveButton.addActionListener(this);
        clearButton.addActionListener(this);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(backgroundColor);
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        // Put the form and buttons in the center
        Panel centerPanel = new Panel(new BorderLayout(10, 10));
        centerPanel.setBackground(backgroundColor);
        centerPanel.add(formPanel, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // ---------- Window Closing ----------
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Adds a label and its corresponding input component in aligned columns
    void addFormRow(Panel panel, GridBagConstraints gbc,
                    int row, String text, Component component) {

        Label label = new Label(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 14));

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.25;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        panel.add(component, gbc);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveButton) {

            String name = nameField.getText().trim();
            String father = fatherField.getText().trim();
            String ageText = ageField.getText().trim();
            String address = addressArea.getText().trim();

            // Check required fields
            if (name.isEmpty() || father.isEmpty()
                    || ageText.isEmpty() || address.isEmpty()) {

                showMessage("Please fill in all the details.");
                return;
            }

            int age;

            try {
                age = Integer.parseInt(ageText);

                if (age <= 0) {
                    showMessage("Age must be a positive number.");
                    return;
                }

            } catch (NumberFormatException ex) {
                showMessage("Please enter a valid age.");
                return;
            }

            String gender =
                    genderGroup.getSelectedCheckbox().getLabel();

            String course = courseChoice.getSelectedItem();

            // Collect selected hobbies
            String hobbies = "";

            if (drawing.getState())
                hobbies += "Drawing, ";

            if (singing.getState())
                hobbies += "Singing, ";

            if (music.getState())
                hobbies += "Music, ";

            if (others.getState())
                hobbies += "Others, ";

            // Remove the last comma and space
            if (hobbies.isEmpty()) {
                hobbies = "None";
            } else {
                hobbies = hobbies.substring(0, hobbies.length() - 2);
            }

            // Prepare registration details
            String details =
                    "Registration Successful!\n\n"
                            + "Name: " + name + "\n"
                            + "Father Name: " + father + "\n"
                            + "Age: " + age + "\n"
                            + "Gender: " + gender + "\n"
                            + "Course: " + course + "\n"
                            + "Hobbies: " + hobbies + "\n"
                            + "Address: " + address;

            showMessage(details);
        }

        else if (e.getSource() == clearButton) {

            nameField.setText("");
            fatherField.setText("");
            ageField.setText("");
            addressArea.setText("");

            genderGroup.setSelectedCheckbox(male);
            courseChoice.select(0);

            drawing.setState(false);
            singing.setState(false);
            music.setState(false);
            others.setState(false);
        }
    }

    // Displays a popup message
    void showMessage(String message) {

        Dialog dialog = new Dialog(
                this, "Registration Details", true
        );

        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setBackground(backgroundColor);

        TextArea detailsArea = new TextArea(
                message, 10, 40,
                TextArea.SCROLLBARS_VERTICAL_ONLY
        );

        detailsArea.setEditable(false);
        dialog.add(detailsArea, BorderLayout.CENTER);

        Button okButton = new Button("OK");
        okButton.addActionListener(e -> dialog.dispose());

        Panel panel = new Panel();
        panel.add(okButton);

        dialog.add(panel, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new Q6();
    }
}
