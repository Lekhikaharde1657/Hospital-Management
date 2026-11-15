// Hospital Management System
// Made by Lekhikaharde1657
// Concepts: Inheritance, Encapsulation, ArrayList, Scanner

import java.util.ArrayList;
import java.util.Scanner;

// Parent Class - Inheritance
class Person {
    String name;
    int age;
    Person(String n, int a) {
        name = n;
        age = a;
    }
}

// Child Class 1 - Doctor
class Doctor extends Person {
    String spec;
    int fee;
    Doctor(String n, int a, String s, int f) {
        super(n, a);
        spec = s;
        fee = f;
    }
    void show() {
        System.out.println("Doctor: " + name + " | " + spec + " | Fee: Rs." + fee);
    }
}

// Child Class 2 - Patient
class Patient extends Person {
    String disease;
    Patient(String n, int a, String d) {
        super(n, a);
        disease = d;
    }
    void show() {
        System.out.println("Patient: " + name + " | Age: " + age + " | Disease: " + disease);
    }
}

// Appointment Class
class Appointment {
    String pName, dName, date;
    Appointment(String p, String d, String dt) {
        pName = p;
        dName = d;
        date = dt;
    }
    void show() {
        System.out.println("Appointment: " + pName + " -> " + dName + " | Date: " + date);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Appointment> appoints = new ArrayList<>();

        doctors.add(new Doctor("Dr. Patil", 40, "General", 200));
        doctors.add(new Doctor("Dr. Sharma", 35, "Heart", 500));
        doctors.add(new Doctor("Dr. Desai", 30, "Child", 300));
        doctors.add(new Doctor("Dr. Joshi", 38, "Dentist", 400));

        String choice = "";
        while(!choice.equals("6")) {
            System.out.println("\n--------------------------------");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("--------------------------------");
            System.out.println("  1. Add Patient");
            System.out.println("  2. View Patients");
            System.out.println("  3. View Doctors");
            System.out.println("  4. Book Appointment");
            System.out.println("  5. View Appointments");
            System.out.println("  6. Exit");
            System.out.println("--------------------------------");
            System.out.print("Choice tak (1-6): ");
            choice = sc.nextLine().trim();

            if(choice.equals("1")) {
                System.out.println("\n--- NEW PATIENT ---");
                System.out.print("Naav tak: ");
                String n = sc.nextLine();
                System.out.print("Age tak: ");
                String ageStr = sc.nextLine();
                int a = 20;
                try { a = Integer.parseInt(ageStr); } catch(Exception e) { a = 20; }
                System.out.print("Disease tak: ");
                String d = sc.nextLine();
                patients.add(new Patient(n, a, d));
                System.out.println("Patient Add Zala!");
            }
            else if(choice.equals("2")) {
                System.out.println("\n--- PATIENTS LIST ---");
                if(patients.isEmpty()) System.out.println("Koni Patient nahi.");
                for(Patient p : patients) p.show();
            }
            else if(choice.equals("3")) {
                System.out.println("\n--- DOCTORS LIST ---");
                for(Doctor d : doctors) d.show();
            }
            else if(choice.equals("4")) {
                System.out.println("\n--- BOOK APPOINTMENT ---");
                System.out.print("Patient Naav: ");
                String pn = sc.nextLine();
                System.out.print("Doctor Naav: ");
                String dn = sc.nextLine();
                System.out.print("Date: ");
                String dt = sc.nextLine();
                appoints.add(new Appointment(pn, dn, dt));
                System.out.println("Appointment Book Zali!");
            }
            else if(choice.equals("5")) {
                System.out.println("\n--- APPOINTMENTS LIST ---");
                if(appoints.isEmpty()) System.out.println("Koni Appointment nahi.");
                for(Appointment ap : appoints) ap.show();
            }
            else if(choice.equals("6")) {
                System.out.println("\nThank You! Hospital Band Zala.");
            }
            else {
                System.out.println("Fakt 1 te 6 madhe number tak.");
            }
        }
        sc.close();
    }
}
