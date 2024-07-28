package src.model;

import java.io.Serializable;
import java.util.Objects;

public class Doctor implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty.");
        }
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id +
                ", Name: " + name +
                ", Specialization: " + specialization;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Doctor doctor = (Doctor) obj;
        return id == doctor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
