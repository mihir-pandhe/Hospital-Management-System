package src.view;

import src.model.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class DoctorPanel extends JPanel {
    private HashMap<Integer, Doctor> doctors;
    private JTextArea displayArea;
    private JTextField idField, nameField, specializationField, searchField;

    public DoctorPanel(HashMap<Integer, Doctor> doctors) {
        this.doctors = doctors;
        setLayout(new BorderLayout());

        displayArea = new JTextArea(20, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

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

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1, 3));

        searchPanel.add(new JLabel("Search Doctor ID:"));
        searchField = new JTextField();
        searchPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDoctor();
            }
        });

        searchPanel.add(searchButton);

        JPanel displayPanel = new JPanel();
        JButton displayAllButton = new JButton("Display All Doctors");
        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllDoctors();
            }
        });

        displayPanel.add(displayAllButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
        add(searchPanel, BorderLayout.EAST);
        add(displayPanel, BorderLayout.WEST);
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

    private void searchDoctor() {
        try {
            int id = Integer.parseInt(searchField.getText());
            Doctor doctor = doctors.get(id);

            if (doctor != null) {
                displayArea.setText(doctor.toString());
            } else {
                displayArea.setText("Doctor not found.\n");
            }
        } catch (NumberFormatException e) {
            displayArea.append("Invalid ID format.\n");
        }
    }

    private void displayAllDoctors() {
        if (doctors.isEmpty()) {
            displayArea.setText("No doctors available.\n");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Doctor doctor : doctors.values()) {
                sb.append(doctor).append("\n");
            }
            displayArea.setText(sb.toString());
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        specializationField.setText("");
        searchField.setText("");
    }
}
