public class Inpatient extends Patient {
    private String wardNumber;
    private String bedNumber;

    public Inpatient(String patientID, String firstName, String lastName, String category, String wardNumber, String bedNumber) {
        super(patientID, firstName, lastName, category);
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Ward: " + wardNumber + ", Bed: " + bedNumber);
    }
}

