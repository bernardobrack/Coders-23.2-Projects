package bernardo.ada.locatecar.model.vehicles;

import java.time.LocalDateTime;

public class VehiclePequeno extends Vehicle {
    public VehiclePequeno(String placa, String nome) {
        super(placa, nome);
    }

    @Override
    public Double getDailyPrice() {
        return 100d;
    }

    @Override
    public LocalDateTime getCurrentRentStartDate() {
        return currentRent;
    }
}
