import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalSystem hs = new HospitalSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Admission System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Allocate Bed");
            System.out.println("6. Release Bed");
            System.out.println("7. Display Beds");
            System.out.println("8. Reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    String id = sc.next();
                    System.out.print("Enter First Name: ");
                    String fn = sc.next();
                    System.out.print("Enter Last Name: ");
                    String ln = sc.next();
                    System.out.print("Enter Category: ");
                    String cat = sc.next();
                    hs.registerPatient(new Patient(id, fn, ln, cat));
                }
                case 2 -> {
                    System.out.print("Enter Patient ID: ");
                    Patient p = hs.searchPatient(sc.next());
                    if (p != null) p.displayDetails();
                    else System.out.println("Patient not found.");
                }
                case 3 -> {
                    System.out.print("Enter Patient ID: ");
                    String id = sc.next();
                    System.out.print("Enter new Last Name: ");
                    hs.updatePatient(id, sc.next());
                }
                case 4 -> {
                    System.out.print("Enter Patient ID to delete: ");
                    hs.deletePatient(sc.next());
                }
                case 5 -> {
                    System.out.print("Enter Patient ID to allocate bed: ");
                    Patient p = hs.searchPatient(sc.next());
                    if (p != null) hs.allocateBed(p);
                    else System.out.println("Patient not found.");
                }
                case 6 -> {
                    System.out.print("Enter Patient ID to release bed: ");
                    hs.releaseBed(sc.next());
                }
                case 7 -> hs.displayBeds();
                case 8 -> hs.displayReports();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}


