package newLevelProjects.p03_fleetManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRepository {
    private final Map<Integer, Vehicle> database = new HashMap<>();
    private int sequenceId = 1;

    public Vehicle save(String plateNumber, String model, double mileageKm) {
        Vehicle vehicle = new Vehicle(sequenceId, plateNumber, model, mileageKm);
        database.put(sequenceId, vehicle);
        sequenceId++;
        return vehicle;
    }

    public List<Vehicle> findAll() {
        return new ArrayList<>(database.values());
    }

    public Vehicle findById(int id) {
        return database.get(id);
    }

    public boolean deleteById(int id) {
        return database.remove(id) != null;
    }
}