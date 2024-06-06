package com.clinic;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AppointmentSystem system = new AppointmentSystem();

        // Añadir algunos administradores
        system.addAdmin(new Admin("admin", "password"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce ID de admin:");
        String adminId = scanner.nextLine();
        System.out.println("Introduce contraseña:");
        String password = scanner.nextLine();

        if (!system.validateAdmin(adminId, password)) {
            System.out.println("Credenciales inválidas!");
            return;
        }

        System.out.println("Acceso concedido.");

        try {
            system.loadData();
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }

        // Bucle del menú
        boolean running = true;
        while (running) {
            System.out.println("1. Añadir Doctor");
            System.out.println("2. Añadir Paciente");
            System.out.println("3. Crear Cita");
            System.out.println("4. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            switch (choice) {
                case 1:
                    System.out.println("Introduce ID del Doctor:");
                    String doctorId = scanner.nextLine();
                    System.out.println("Introduce nombre del Doctor:");
                    String doctorName = scanner.nextLine();
                    System.out.println("Introduce especialidad del Doctor:");
                    String doctorSpecialty = scanner.nextLine();
                    Doctor doctor = new Doctor(doctorId, doctorName, doctorSpecialty);
                    system.addDoctor(doctor);
                    System.out.println("Doctor añadido exitosamente.");
                    break;
                case 2:
                    System.out.println("Introduce ID del Paciente:");
                    String patientId = scanner.nextLine();
                    System.out.println("Introduce nombre del Paciente:");
                    String patientName = scanner.nextLine();
                    System.out.println("Introduce condición del Paciente:");
                    String patientCondition = scanner.nextLine();
                    Patient patient = new Patient(patientId, patientName, patientCondition);
                    system.addPatient(patient);
                    System.out.println("Paciente añadido exitosamente.");
                    break;
                case 3:
                    System.out.println("Introduce ID de la Cita:");
                    String appointmentId = scanner.nextLine();
                    System.out.println("Introduce ID del Doctor:");
                    String appDoctorId = scanner.nextLine();
                    System.out.println("Introduce ID del Paciente:");
                    String appPatientId = scanner.nextLine();
                    System.out.println("Introduce fecha y hora de la Cita (yyyy-MM-ddTHH:mm):");
                    String dateTimeStr = scanner.nextLine();
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    Appointment appointment = new Appointment(appointmentId, appDoctorId, appPatientId, dateTime);
                    system.addAppointment(appointment);
                    System.out.println("Cita creada exitosamente.");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        try {
            system.saveData();
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }

        System.out.println("Saliendo del sistema...");
    }
}