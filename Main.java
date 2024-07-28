import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. Display Doctors");
            System.out.println("5. Exit");
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
}
