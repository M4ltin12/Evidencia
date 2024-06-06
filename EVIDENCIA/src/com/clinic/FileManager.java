package com.clinic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private final String doctorsFile = "src/main/resources/db/doctors.csv";
    private final String patientsFile = "src/main/resources/db/patients.csv";
    private final String appointmentsFile = "src/main/resources/db/appointments.csv";

    public List<Doctor> loadDoctors() throws IOException {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(doctorsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) { // Verificar si la línea tiene todos los datos esperados
                    Doctor doctor = new Doctor(data[0], data[1], data[2]);
                    doctors.add(doctor);
                } else {
                    System.err.println("Error: Datos de doctor inválidos: " + line);
                }
            }
        }
        return doctors;
    }

    public List<Patient> loadPatients() throws IOException {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(patientsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) { // Verificar si la línea tiene todos los datos esperados
                    Patient patient = new Patient(data[0], data[1], data[2]);
                    patients.add(patient);
                } else {
                    System.err.println("Error: Datos de paciente inválidos: " + line);
                }
            }
        }
        return patients;
    }

    public List<Appointment> loadAppointments() throws IOException {
        List<Appointment> appointments = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(appointmentsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) { // Verificar si la línea tiene todos los datos esperados
                    LocalDateTime dateTime = LocalDateTime.parse(data[3], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    Appointment appointment = new Appointment(data[0], data[1], data[2], dateTime);
                    appointments.add(appointment);
                } else {
                    System.err.println("Error: Datos de cita inválidos: " + line);
                }
            }
        }
        return appointments;
    }

    public void saveDoctors(List<Doctor> doctors) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(doctorsFile))) {
            for (Doctor doctor : doctors) {
                bw.write(doctor.getId() + "," + doctor.getName() + "," + doctor.getSpecialty());
                bw.newLine();
            }
        }
    }

    public void savePatients(List<Patient> patients) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(patientsFile))) {
            for (Patient patient : patients) {
                bw.write(patient.getId() + "," + patient.getName() + "," + patient.getCondition());
                bw.newLine();
            }
        }
    }

    public void saveAppointments(List<Appointment> appointments) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(appointmentsFile))) {
            for (Appointment appointment : appointments) {
                bw.write(appointment.getId() + "," + appointment.getDoctorId() + "," + appointment.getPatientId() + "," + appointment.getDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                bw.newLine();
            }
        }
    }
}