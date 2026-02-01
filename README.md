# 🏥 Hospital Management System
A Java-based console application for managing hospital patients, doctors, and appointments. Perfect for beginners learning Java, JDBC, and database integration.

---

## 📂 Project Overview
Hospital Management System is a console-based Java application designed to help users:
- Add and view patient details
- View available doctors
- Book appointments between patients and doctors
- Check if patients/doctors exist in the database
- Manage everything through an interactive menu system

---

## Project Structure
```
HospitalManagementSystem/
├── src/
│   └── hospitalmanagementsystem/          # Main package
│       ├── Patient.java                   # Patient management (addPatient, viewPatients, checkPatient)
│       ├── Doctor.java                    # Doctor management (viewDoctors, checkDoctor)
│       └── HospitalManagementSystem.java  # Main driver class with menu & database connection
├── database/
│   └── hospital.sql                 # MySQL database schema (patients, doctors, appointments tables)
├── lib/                             # JDBC connector (mysql-connector-java.jar)
└── README.md                        
```

---

## ⚙️ Quick Summary
**Inputs:** Java 11+, MySQL database, IntelliJ IDEA (recommended)  
**Outputs:** Running console application with full hospital management functionality  
**Error Modes:** Missing JDBC driver, database connection issues, uncreated tables  
**Success Indicator:** App runs locally showing main menu with options 1-5

---

## 🧩 Prerequisites
- **Java 11+** (JDK installed)
- **MySQL Server** (5.7+ recommended)
- **IntelliJ IDEA** or any Java IDE
- **MySQL JDBC Connector** (mysql-connector-java-8.x.jar)
- Git (optional)

If missing JDBC connector:
1. Download from [MySQL website](https://dev.mysql.com/downloads/connector/j/)
2. Add to project lib folder and classpath

---

## 🚀 Setup Instructions (IntelliJ IDEA)

### 1. Database Setup
```sql
-- Create database
CREATE DATABASE hospital;

-- Use database and create tables
USE hospital;

-- Patient table
CREATE TABLE patient (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10)
);

-- Doctor table  
CREATE TABLE doctor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

-- Appointments table
CREATE TABLE appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES patient(id),
    FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    PRIMARY KEY (id)
);
```

### 2. Project Setup
Run from project root in IntelliJ IDEA:
```
1. File → New → Project from Version Control (or import existing)
2. Add MySQL connector to project libraries (File → Project Structure → Libraries)
3. Configure database connection (View → Tool Windows → Database)
```

### 3. Run Application
```
Right-click HospitalManagementSystem.java → Run 'HospitalManagementSystem.main()'
```

**Main Menu Options:**
```
1. Add Patient
2. View Patients  
3. View Doctors
4. Book Appointment
5. Exit
```

---

## ✅ Tip
After setup, test database connection first:
```java
// In HospitalManagementSystem class - verify connection works
Connection conn = DriverManager.getConnection(url, username, password);
System.out.println("Database connected successfully!");
```

---

## 🧪 Common Tasks
**Compile & Run (Command Line):**
```bash
javac -cp ".;lib/mysql-connector-java-8.0.33.jar" src/hospitalmanagementsystem/*.java
java -cp ".;lib/mysql-connector-java-8.0.33.jar" hospitalmanagementsystem.HospitalManagementSystem
```

**Key Methods Used:**
- `Patient.addPatient()` - Adds patient to database  
- `Patient.viewPatients()` - Lists all patients  
- `Doctor.viewDoctors()` - Lists available doctors  
- `checkPatient(String name)` - Boolean exists check  
- `bookAppointment(int patientId, int doctorId)` - Creates appointment

---

## 🎨 Console Interface
Interactive menu-driven system using `Scanner` and `switch-case`:
- Clean numbered menu (1-5 options)
- Continuous loop until user selects "Exit" (option 5)
- Input validation through method calls

---

## 🌐 Database Notes
**Three Tables with Relationships:**
```
patients (id PK, name, age, gender)  
  ↓ patient_id (FK)
appointments (id PK, patient_id FK, doctor_id FK, appointment_date)  
  ↑ doctor_id (FK)
doctors (id PK, name, specialization)  
```

**Connection in `HospitalManagementSystem.java`:**
```java
// Update these credentials
String url = "jdbc:mysql://localhost:3306/hospital";
String username = "root";
String password = "your_password";
```

---

## 🧭 Recommended Next Steps
- Add **Admin panel** for doctor management  
- Implement **appointment viewing/cancellation**
- Add **patient search by ID/name**
- Create **GUI version** using Swing/JavaFX
- Add **JDBC connection pooling**
- Deploy as **JAR file** with embedded database (H2/SQLite)
- Add **input validation** and error handling
- Create **Maven/Gradle** build configuration

---

**Made with ❤️ using Java + MySQL**  

---
