public class FinanceCalculator {
    public static void calculate(Car car, FinanceTerm term) {
        double interest = car.getPrice() * term.getRate();
        double totalRepayment = car.getPrice() + interest;
        double monthlyInstallment = totalRepayment / (term.getYears() * 12);

        System.out.println("\nFinance Quotation for " + car.getModel());
        System.out.println("Term: " + term.getYears() + " years");
        System.out.println("Interest: R" + interest);
        System.out.println("Total Repayment: R" + totalRepayment);
        System.out.println("Monthly Installment: R" + monthlyInstallment);
    }
}

