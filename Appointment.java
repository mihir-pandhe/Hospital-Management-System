public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(int id, Patient patient, Doctor doctor, String date, String time) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }
    @Override
    public String toString() {
        return "Appointment ID: " + id + ", Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Date: " + date + ", Time: " + time;
    }
}