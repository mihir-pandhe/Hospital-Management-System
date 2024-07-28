import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private PatientPanel patientPanel;
    private DoctorPanel doctorPanel;
    private AppointmentPanel appointmentPanel;

    // Data structures
    private HashMap<Integer, Patient> patients;
    private HashMap<Integer, Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public MainFrame() {
        // Initialize data structures
        patients = new HashMap<>();
        doctors = new HashMap<>();
        appointments = new ArrayList<>();

        setTitle("Hospital Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        patientPanel = new PatientPanel(patients);
        doctorPanel = new DoctorPanel(doctors);
        appointmentPanel = new AppointmentPanel(patients, doctors, appointments);

        cardPanel.add(patientPanel, "Patients");
        cardPanel.add(doctorPanel, "Doctors");
        cardPanel.add(appointmentPanel, "Appointments");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem patientItem = new JMenuItem("Patients");
        JMenuItem doctorItem = new JMenuItem("Doctors");
        JMenuItem appointmentItem = new JMenuItem("Appointments");

        patientItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Patients");
            }
        });

        doctorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Doctors");
            }
        });

        appointmentItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Appointments");
            }
        });

        menu.add(patientItem);
        menu.add(doctorItem);
        menu.add(appointmentItem);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        add(cardPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
