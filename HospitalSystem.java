import java.util.ArrayList;

public class HospitalSystem {
    private ArrayList<Patient> patients = new ArrayList<>();
    private Patient[][] beds = new Patient[4][5]; // 20 beds

    // ✅ Register a new patient
    public void registerPatient(Patient p) {
        for (Patient existing : patients) {
            if (existing.getPatientID().equals(p.getPatientID())) {
                System.out.println("❌ Duplicate Patient ID not allowed!");
                return;
            }
        }
        patients.add(p);
        System.out.println("✅ Patient registered successfully.");
    }

    // 🔍 Search for a patient
    public Patient searchPatient(String id) {
        for (Patient p : patients) {
            if (p.getPatientID().equals(id)) {
                return p;
            }
        }
        return null;
    }

    // ✏️ Update patient details
    public void updatePatient(String id, String newLastName) {
        Patient p = searchPatient(id);
        if (p != null) {
            p.setLastName(newLastName);
            System.out.println("✅ Patient details updated.");
        } else {
            System.out.println("❌ Patient not found.");
        }
    }

    // 🗑️ Delete patient
    public void deletePatient(String id) {
        Patient p = searchPatient(id);
        if (p != null) {
            patients.remove(p);
            System.out.println("✅ Patient deleted.");
        } else {
            System.out.println("❌ Patient not found.");
        }
    }

    // 🛏️ Allocate bed
    public void allocateBed(Patient p) {
        if (!p.getCategory().equalsIgnoreCase("Inpatient")) {
            System.out.println("❌ Only inpatients may be allocated a bed.");
            return;
        }

        // Check if patient already has a bed
        for (Patient[] row : beds) {
            for (Patient bed : row) {
                if (bed != null && bed.getPatientID().equals(p.getPatientID())) {
                    System.out.println("❌ Patient already has a bed allocated.");
                    return;
                }
            }
        }

        // Find first available bed
        for (int i = 0; i < beds.length; i++) {
            for (int j = 0; j < beds[i].length; j++) {
                if (beds[i][j] == null) {
                    beds[i][j] = p;
                    System.out.println("✅ Bed allocated: B" + (i * 5 + j + 1));
                    return;
                }
            }
        }
        System.out.println("❌ No beds available!");
    }

    // 🧹 Release bed
    public void releaseBed(String id) {
        for (int i = 0; i < beds.length; i++) {
            for (int j = 0; j < beds[i].length; j++) {
                if (beds[i][j] != null && beds[i][j].getPatientID().equals(id)) {
                    beds[i][j] = null;
                    System.out.println("✅ Bed released for patient " + id);
                    return;
                }
            }
        }
        System.out.println("❌ Patient not found in beds.");
    }

    // 🖥️ Display bed layout
    public void displayBeds() {
        System.out.println("\n🏥 Ward Layout:");
        for (int i = 0; i < beds.length; i++) {
            for (int j = 0; j < beds[i].length; j++) {
                System.out.print((beds[i][j] == null ? "[Empty]" : "[Occupied]") + " ");
            }
            System.out.println();
        }
    }

    // 📊 Reports
    public void displayReports() {
        int totalPatients = patients.size();
        int occupiedBeds = 0;
        for (Patient[] row : beds) {
            for (Patient bed : row) {
                if (bed != null) occupiedBeds++;
            }
        }
        double occupancy = (occupiedBeds / 20.0) * 100;
        System.out.println("\n📋 Reports:");
        System.out.println("Total Registered Patients: " + totalPatients);
        System.out.println("Occupied Beds: " + occupiedBeds);
        System.out.println("Available Beds: " + (20 - occupiedBeds));
        System.out.println("Ward Occupancy: " + String.format("%.2f", occupancy) + "%");
    }

    // 🔄 Sort patients by surname
    public void sortPatientsBySurname() {
        patients.sort((p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));
        System.out.println("✅ Patients sorted by surname.");
    }

    // 🔄 Sort patients by ID
    public void sortPatientsByID() {
        patients.sort((p1, p2) -> p1.getPatientID().compareToIgnoreCase(p2.getPatientID()));
        System.out.println("✅ Patients sorted by Patient ID.");
    }

    // 🧾 Display all patients
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("❌ No patients registered.");
            return;
        }
        System.out.println("\n👥 Registered Patients:");
        for (Patient p : patients) {
            p.displayDetails();
        }
    }
}

