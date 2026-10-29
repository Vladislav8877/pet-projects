package newLevelProjects.p03_fleetManagement;

public class Vehicle {
    private final int id;
    private String plateNumber;
    private String model;
    private double mileageKm;

    public Vehicle(int id, String plateNumber, String model, double mileageKm) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.model = model;
        this.mileageKm = mileageKm;
    }

    public void addMileage(double km) {
        Validator.checkAmount(km, "пробег");
        this.mileageKm += km;
    }

    public int getId() { return id; }
    public String getPlateNumber() { return plateNumber; }
    public String getModel() { return model; }
    public double getMileageKm() { return mileageKm; }

    @Override
    public String toString() {
        return String.format("%d. %s || %s || %.1f км", id, plateNumber, model, mileageKm);
    }
}