package bernardo.ada.locatecar.model.factory;

import bernardo.ada.locatecar.model.factory.exception.VehicleFactoryException;
import bernardo.ada.locatecar.model.vehicles.Vehicle;
import bernardo.ada.locatecar.model.vehicles.VehicleMedio;
import bernardo.ada.locatecar.model.vehicles.VehiclePequeno;
import bernardo.ada.locatecar.model.vehicles.VehicleSUV;

public class VehicleFactory {
    public static Vehicle createVehicle(String name, String tag, String type) throws VehicleFactoryException {
        return switch (type.toUpperCase()) {
            case "P" -> new VehiclePequeno(tag, name);
            case "M" -> new VehicleMedio(tag, name);
            case "SUV" -> new VehicleSUV(tag, name);
            default -> throw new VehicleFactoryException("Invalid vehicle type!");
        };
    }
}
