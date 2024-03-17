package bernardo.ada.locatecar.model.vehicles;

import java.time.LocalDateTime;

public class VehicleSUV extends Vehicle {

    public VehicleSUV(String placa, String nome) {
        super(placa, nome);
    }

    @Override
    public Double getDailyPrice() {
        return 200d;
    }

    @Override
    public LocalDateTime getCurrentRentStartDate() {
        return currentRent;
    }
}
