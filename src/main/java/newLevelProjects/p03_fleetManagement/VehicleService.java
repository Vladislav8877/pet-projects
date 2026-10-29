package newLevelProjects.p03_fleetManagement;

import java.util.List;

public class VehicleService {
    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public void addVehicle(String plateNumber, String model, double mileageKm) {
        Validator.checkString(plateNumber, "гос. номер");
        Validator.checkString(model, "модель");
        if (mileageKm < 0) {
            throw new IllegalArgumentException("Ошибка: пробег не может быть отрицательным!");
        }

        Vehicle created = repository.save(plateNumber, model, mileageKm);
        System.out.println("Машина добавлена: " + created);
    }

    public void showAllVehicles() {
        List<Vehicle> vehicles = repository.findAll();

        if (vehicles.isEmpty()) {
            System.out.println("Автопарк пуст!");
            return;
        }

        System.out.println("Все машины:");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public void addMileage(int id, double km) {
        Vehicle vehicle = repository.findById(id);
        if (vehicle == null) {
            throw new ItemNotFoundException("Ошибка: машина с ID " + id + " не найдена!");
        }

        vehicle.addMileage(km);
        System.out.printf("Новый пробег у %s: %.1f км%n", vehicle.getPlateNumber(), vehicle.getMileageKm());
    }

    public void removeVehicle(int id) {
        boolean isDeleted = repository.deleteById(id);
        if (isDeleted) {
            System.out.println("Машина с ID " + id + " удалена из автопарка.");
        } else {
            throw new ItemNotFoundException("Ошибка: машина с ID " + id + " не найдена!");
        }
    }

    public void findByModel(String model) {
        Validator.checkString(model, "модель");

        List<Vehicle> vehicles = repository.findAll();
        boolean found = false;

        for (Vehicle v : vehicles) {
            if (v.getModel().equalsIgnoreCase(model)) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Машин модели \"" + model + "\" не найдено.");
        }
    }
}