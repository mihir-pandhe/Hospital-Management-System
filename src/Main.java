package src;

import src.model.Patient;
import src.model.Doctor;
import src.model.Appointment;
import src.view.PatientPanel;
import src.view.DoctorPanel;
import src.view.AppointmentPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Patient> patients = new HashMap<>();
        HashMap<Integer, Doctor> doctors = new HashMap<>();
        ArrayList<Appointment> appointments = new ArrayList<>();

        JFrame frame = new JFrame("Hospital Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        PatientPanel patientPanel = new PatientPanel(patients);
        DoctorPanel doctorPanel = new DoctorPanel(doctors);
        AppointmentPanel appointmentPanel = new AppointmentPanel(patients, doctors, appointments);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Patients", patientPanel);
        tabbedPane.addTab("Doctors", doctorPanel);
        tabbedPane.addTab("Appointments", appointmentPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
