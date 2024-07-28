import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class DoctorPanel extends JPanel {
    private HashMap<Integer, Doctor> doctors;
    private JTextArea displayArea;
    private JTextField idField, nameField, specializationField;

    public DoctorPanel(HashMap<Integer, Doctor> doctors) {
        this.doctors = doctors;
        setLayout(new BorderLayout());

        // Create components
        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Doctor ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Specialization:"));
        specializationField = new JTextField();
        inputPanel.add(specializationField);

        JButton addButton = new JButton("Add Doctor");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctor();
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }

    private void addDoctor() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String specialization = specializationField.getText();

            if (doctors.containsKey(id)) {
                displayArea.append("Doctor with this ID already exists.\n");
                return;
            }

            doctors.put(id, new Doctor(id, name, specialization));
            displayArea.append("Doctor added successfully.\n");
            clearFields();
        } catch (NumberFormatException e) {
            displayArea.append("Invalid input. Please enter valid data.\n");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        specializationField.setText("");
    }
}
