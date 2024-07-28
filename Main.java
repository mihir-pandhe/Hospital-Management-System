import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static HashMap<Integer, Patient> patients = new HashMap<>();
    private static HashMap<Integer, Doctor> doctors = new HashMap<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        loadData();

        while (true) {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. Display Doctors");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. Display Appointments");
            System.out.println("7. Search Patient by ID");
            System.out.println("8. Search Doctor by ID");
            System.out.println("9. Report All Patients");
            System.out.println("10. Report All Doctors");
            System.out.println("11. Report All Appointments");
            System.out.println("12. Save and Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

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
                    searchPatientById();
                    break;
                case 8:
                    searchDoctorById();
                    break;
                case 9:
                    reportAllPatients();
                    break;
                case 10:
                    reportAllDoctors();
                    break;
                case 11:
                    reportAllAppointments();
                    break;
                case 12:
                    saveData();
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addPatient() {
        try {
            System.out.print("Enter Patient ID: ");
            int id = getIntInput();
            scanner.nextLine();
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Patient Age: ");
            int age = getIntInput();
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
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            for (Patient patient : patients.values()) {
                System.out.println(patient);
            }
        }
    }

    private static void addDoctor() {
        try {
            System.out.print("Enter Doctor ID: ");
            int id = getIntInput();
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
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor doctor : doctors.values()) {
                System.out.println(doctor);
            }
        }
    }

    private static void scheduleAppointment() {
        try {
            System.out.print("Enter Appointment ID: ");
            int id = getIntInput();
            scanner.nextLine();
            System.out.print("Enter Patient ID: ");
            int patientId = getIntInput();
            System.out.print("Enter Doctor ID: ");
            int doctorId = getIntInput();
            scanner.nextLine();
            System.out.print("Enter Date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            System.out.print("Enter Time (HH:mm): ");
            String timeStr = scanner.nextLine();

            Patient patient = patients.get(patientId);
            Doctor doctor = doctors.get(doctorId);

            if (patient != null && doctor != null) {
                Date date = dateFormat.parse(dateStr);
                appointments.add(new Appointment(id, patient, doctor, date, timeStr));
                System.out.println("Appointment scheduled successfully.");
            } else {
                System.out.println("Invalid patient or doctor ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        } catch (ParseException e) {
            System.out.println("Invalid date or time format. Please try again.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private static void searchPatientById() {
        System.out.print("Enter Patient ID to search: ");
        int id = getIntInput();
        Patient patient = patients.get(id);

        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    private static void searchDoctorById() {
        System.out.print("Enter Doctor ID to search: ");
        int id = getIntInput();
        Doctor doctor = doctors.get(id);

        if (doctor != null) {
            System.out.println(doctor);
        } else {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }

    private static void reportAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            for (Patient patient : patients.values()) {
                System.out.println(patient);
            }
        }
    }

    private static void reportAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor doctor : doctors.values()) {
                System.out.println(doctor);
            }
        }
    }

    private static void reportAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("hospital_data.dat"))) {
            oos.writeObject(patients);
            oos.writeObject(doctors);
            oos.writeObject(appointments);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hospital_data.dat"))) {
            Object obj = ois.readObject();
            if (obj instanceof HashMap<?, ?>) {
                @SuppressWarnings("unchecked")
                HashMap<Integer, Patient> patientsTemp = (HashMap<Integer, Patient>) obj;
                patients = patientsTemp;
            }

            obj = ois.readObject();
            if (obj instanceof HashMap<?, ?>) {
                @SuppressWarnings("unchecked")
                HashMap<Integer, Doctor> doctorsTemp = (HashMap<Integer, Doctor>) obj;
                doctors = doctorsTemp;
            }

            obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                @SuppressWarnings("unchecked")
                ArrayList<Appointment> appointmentsTemp = (ArrayList<Appointment>) obj;
                appointments = appointmentsTemp;
            }

            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting with empty data.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading data: Class not found.");
        }
    }
}
