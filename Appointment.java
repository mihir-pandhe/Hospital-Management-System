import java.util.Date;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    public Appointment(int id, Patient patient, Doctor doctor, Date date, String time) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id + ", Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + 
                ", Date: " + date + ", Time: " + time;
    }
}
