import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. Display Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. Display Appointments");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    displayPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    displayDoctors();
                    break;
                case 5:
                    scheduleAppointment();
                    break;
                case 6:
                    displayAppointments();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.nextLine();

        patients.add(new Patient(id, name, age, gender));
        System.out.println("Patient added successfully.");
    }

    private static void displayPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(id, name, specialization));
        System.out.println("Doctor added successfully.");
    }

    private static void displayDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    private static void scheduleAppointment() {
        System.out.print("Enter Appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Time (HH:MM): ");
        String time = scanner.nextLine();

        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient != null && doctor != null) {
            appointments.add(new Appointment(id, patient, doctor, date, time));
            System.out.println("Appointment scheduled successfully.");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID.");
        }
    }

    private static void displayAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
}
