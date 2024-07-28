import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class AppointmentPanel extends JPanel {
    private JTextField idField;
    private JTextField patientIdField;
    private JTextField doctorIdField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextArea displayArea;
    private HashMap<Integer, Patient> patients;
    private HashMap<Integer, Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private SimpleDateFormat dateFormat;

    public AppointmentPanel(HashMap<Integer, Patient> patients, HashMap<Integer, Doctor> doctors,
            ArrayList<Appointment> appointments) {
        setLayout(new BorderLayout());

        this.patients = patients;
        this.doctors = doctors;
        this.appointments = appointments;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Appointment ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Patient ID:"));
        patientIdField = new JTextField();
        inputPanel.add(patientIdField);

        inputPanel.add(new JLabel("Doctor ID:"));
        doctorIdField = new JTextField();
        inputPanel.add(doctorIdField);

        inputPanel.add(new JLabel("Date (yyyy-MM-dd):"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Time (HH:mm):"));
        timeField = new JTextField();
        inputPanel.add(timeField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Schedule Appointment");
        JButton displayButton = new JButton("Display Appointments");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleAppointment();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAppointments();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);

        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private void scheduleAppointment() {
        try {
            int id = Integer.parseInt(idField.getText());
            int patientId = Integer.parseInt(patientIdField.getText());
            int doctorId = Integer.parseInt(doctorIdField.getText());
            String dateStr = dateField.getText();
            String timeStr = timeField.getText();

            Patient patient = patients.get(patientId);
            Doctor doctor = doctors.get(doctorId);

            if (patient != null && doctor != null) {
                Date date = dateFormat.parse(dateStr);
                Appointment appointment = new Appointment(id, patient, doctor, date, timeStr);
                appointments.add(appointment);
                JOptionPane.showMessageDialog(this, "Appointment scheduled successfully.");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid patient or doctor ID.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers for IDs.");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    private void displayAppointments() {
        if (appointments.isEmpty()) {
            displayArea.setText("No appointments available.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Appointment appointment : appointments) {
                sb.append(appointment).append("\n");
            }
            displayArea.setText(sb.toString());
        }
    }

    private void clearFields() {
        idField.setText("");
        patientIdField.setText("");
        doctorIdField.setText("");
        dateField.setText("");
        timeField.setText("");
    }
}
