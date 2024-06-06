package com.clinic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentSystem {
    private List<Admin> admins;
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;
    private FileManager fileManager;

    public AppointmentSystem() {
        this.admins = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.fileManager = new FileManager();
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public boolean validateAdmin(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void saveData() throws IOException {
        fileManager.saveDoctors(doctors);
        fileManager.savePatients(patients);
        fileManager.saveAppointments(appointments);
    }

    public void loadData() throws IOException {
        doctors = fileManager.loadDoctors();
        patients = fileManager.loadPatients();
        appointments = fileManager.loadAppointments();
    }
}