package src.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Patient patient;
    private Doctor doctor;
    private Date date;
    private String time;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Appointment(int id, Patient patient, Doctor doctor, Date date, String time) {
        if (patient == null || doctor == null || date == null || time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException("None of the parameters can be null or empty.");
        }
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

    public String getFormattedDate() {
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id +
                ", Patient: " + patient.getName() +
                ", Doctor: " + doctor.getName() +
                ", Date: " + getFormattedDate() +
                ", Time: " + time;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Appointment that = (Appointment) obj;
        return id == that.id &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, doctor, date, time);
    }

    public static Date parseDate(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }
}
