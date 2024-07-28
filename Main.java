import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    private static HashMap<Integer, Patient> patients = new HashMap<>();
    private static HashMap<Integer, Doctor> doctors = new HashMap<>();
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
        try {
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

            if (patients.containsKey(id)) {
                System.out.println("Patient with this ID already exists.");
                return;
            }

            patients.put(id, new Patient(id, name, age, gender));
            System.out.println("Patient added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        }
    }

    private static void displayPatients() {
        for (Patient patient : patients.values()) {
            System.out.println(patient);
        }
    }

    private static void addDoctor() {
        try {
            System.out.print("Enter Doctor ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Doctor Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Doctor Specialization: ");
            String specialization = scanner.nextLine();

            if (doctors.containsKey(id)) {
                System.out.println("Doctor with this ID already exists.");
                return;
            }

            doctors.put(id, new Doctor(id, name, specialization));
            System.out.println("Doctor added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        }
    }

    private static void displayDoctors() {
        for (Doctor doctor : doctors.values()) {
            System.out.println(doctor);
        }
    }

    private static void scheduleAppointment() {
        try {
            System.out.print("Enter Appointment ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Patient ID: ");
            int patientId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Doctor ID: ");
            int doctorId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Date (yyyy-mm-dd): ");
            String dateStr = scanner.nextLine();
            System.out.print("Enter Time (hh:mm): ");
            String time = scanner.nextLine();

            Patient patient = patients.get(patientId);
            Doctor doctor = doctors.get(doctorId);
            if (patient != null && doctor != null) {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                appointments.add(new Appointment(id, patient, doctor, date, time));
                System.out.println("Appointment scheduled successfully.");
            } else {
                System.out.println("Invalid patient or doctor ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void displayAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}
