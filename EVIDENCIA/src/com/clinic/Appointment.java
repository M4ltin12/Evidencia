package com.clinic;

import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private String doctorId;
    private String patientId;
    private LocalDateTime dateTime;

    public Appointment(String id, String doctorId, String patientId, LocalDateTime dateTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}