import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array of cars
        Car[] cars = {
            new Car("CA12345", "Toyota", "Corolla", 350000, "Sedan"),
            new Car("CA67890", "Haval", "H6", 450000, "SUV"),
            new Car("CA54321", "Volkswagen", "Tiguan", 500000, "SUV"),
            new Car("CA98765", "BMW", "320i", 650000, "Sedan"),
            new Car("CA11111", "Ford", "Everest", 700000, "SUV")
        };

        int choice;
        do {
            System.out.println("\nCAR FINANCE SYSTEM");
            System.out.println("1. View Available Cars");
            System.out.println("2. Apply for Car Finance");
            System.out.println("3. View Finance Terms");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nAvailable Cars:");
                    for (int i = 0; i < cars.length; i++) {
                        System.out.print((i+1) + ". ");
                        cars[i].displayCar();
                    }
                }
                case 2 -> {
                    System.out.print("Select car number: ");
                    int carChoice = sc.nextInt() - 1;
                    if (carChoice >= 0 && carChoice < cars.length) {
                        System.out.println("Choose Finance Term: 1=SHORT, 2=MEDIUM, 3=LONG");
                        int termChoice = sc.nextInt();
                        FinanceTerm term = switch (termChoice) {
                            case 1 -> FinanceTerm.SHORT;
                            case 2 -> FinanceTerm.MEDIUM;
                            case 3 -> FinanceTerm.LONG;
                            default -> FinanceTerm.SHORT;
                        };
                        FinanceCalculator.calculate(cars[carChoice], term);
                    } else {
                        System.out.println("Invalid car selection.");
                    }
                }
                case 3 -> {
                    System.out.println("\nFinance Terms:");
                    System.out.println("SHORT = 1 year, 5% interest");
                    System.out.println("MEDIUM = 3 years, 10% interest");
                    System.out.println("LONG = 5 years, 15% interest");
                }
                case 4 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }
}

