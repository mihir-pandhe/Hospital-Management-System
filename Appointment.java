import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
                ", Date: " + dateFormat.format(date) + ", Time: " + time;
    }
}
