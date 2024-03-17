package bernardo.ada.locatecar.model.vehicles;

import java.time.LocalDateTime;

public class VehicleMedio extends Vehicle {

    public VehicleMedio(String placa, String nome) {
        super(placa, nome);
    }

    @Override
    public Double getDailyPrice() {
        return 150d;
    }

    @Override
    public LocalDateTime getCurrentRentStartDate() {
        return currentRent;
    }
}
