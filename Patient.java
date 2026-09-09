public class Patient {
    private String patientID;
    private String firstName;
    private String lastName;
    private String category; // Inpatient, Outpatient, Emergency

    public Patient(String patientID, String firstName, String lastName, String category) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }

    // Getters and setters
    public String getPatientID() { return patientID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCategory() { return category; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void displayDetails() {
        System.out.println("ID: " + patientID + ", Name: " + firstName + " " + lastName + ", Category: " + category);
    }
}

