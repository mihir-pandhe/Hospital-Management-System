import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class PatientPanel extends JPanel {
    private HashMap<Integer, Patient> patients;
    private JTextArea displayArea;
    private JTextField idField, nameField, ageField, genderField;

    public PatientPanel(HashMap<Integer, Patient> patients) {
        this.patients = patients;
        setLayout(new BorderLayout());

        // Create components
        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Patient ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        inputPanel.add(genderField);

        JButton addButton = new JButton("Add Patient");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }

    private void addPatient() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();

            if (patients.containsKey(id)) {
                displayArea.append("Patient with this ID already exists.\n");
                return;
            }

            patients.put(id, new Patient(id, name, age, gender));
            displayArea.append("Patient added successfully.\n");
            clearFields();
        } catch (NumberFormatException e) {
            displayArea.append("Invalid input. Please enter valid data.\n");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        genderField.setText("");
    }
}
