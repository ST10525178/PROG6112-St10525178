public class Car {
    private String registration;
    private String make;
    private String model;
    private double price;
    private String type;

    public Car(String registration, String make, String model, double price, String type) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.price = price;
        this.type = type;
    }

    public double getPrice() { return price; }
    public String getModel() { return model; }

    public void displayCar() {
        System.out.println("Registration: " + registration +
                           ", Make: " + make +
                           ", Model: " + model +
                           ", Price: R" + price +
                           ", Type: " + type);
    }
}

