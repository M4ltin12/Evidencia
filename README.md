## Estructura del Proyecto

El proyecto está organizado en varios archivos Java que representan diferentes partes del sistema:

- `Admin.java`: Representa un administrador del sistema.
- `Doctor.java`: Representa un doctor en la clínica.
- `Patient.java`: Representa un paciente de la clínica.
- `Appointment.java`: Representa una cita médica.
- `AppointmentSystem.java`: Maneja la lógica principal del sistema.
- `FileManager.java`: Maneja la carga y guardado de datos en archivos CSV.
- `Main.java`: Contiene el punto de entrada del programa y la interfaz de usuario.

## Funcionalidades

- **Administración de Doctores**: Agregar, eliminar y listar doctores.
- **Administración de Pacientes**: Agregar, eliminar y listar pacientes.
- **Gestión de Citas**: Crear y listar citas médicas.
- **Autenticación de Administradores**: Validar las credenciales de los administradores.

## Uso

Para ejecutar el programa, utiliza un entorno de desarrollo Java (JDK 8 o superior) y sigue estos pasos:

1. Compila los archivos `.java`:
    ```sh
    javac -d bin src/com/clinic/*.java
    ```

2. Ejecuta el programa:
    ```sh
    java -cp bin com.clinic.Main
    ```

## Formato de Entrada

- **Usuario y Contraseña**: Debe introducirse como usuario: `admin` y contrasñea: `password`.

- **Fecha y Hora de la Cita**: Debe introducirse en el formato `yyyy-MM-ddTHH:mm`. Por ejemplo, `2024-12-12T12:00` para el 12 de diciembre de 2024 a las 12:00.

## Autores

- Martín Antonio Joaquín Landa (antony_joaquin12@hotmail.com)

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo `LICENSE`.
