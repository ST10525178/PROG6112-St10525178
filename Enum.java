public enum FinanceTerm {
    SHORT(1, 0.05),   // 1 year, 5% interest
    MEDIUM(3, 0.10),  // 3 years, 10% interest
    LONG(5, 0.15);    // 5 years, 15% interest

    private int years;
    private double rate;

    FinanceTerm(int years, double rate) {
        this.years = years;
        this.rate = rate;
    }

    public int getYears() { return years; }
    public double getRate() { return rate; }
}

