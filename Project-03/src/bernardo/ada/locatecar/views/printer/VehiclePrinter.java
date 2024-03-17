package bernardo.ada.locatecar.views.printer;

import bernardo.ada.locatecar.model.vehicles.Vehicle;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class VehiclePrinter implements Printer<Vehicle>{

    @Override
    public void print(Vehicle obj) {
        System.out.print(obj.getPlaca() + " - " + obj.getNome()+ " - ");
        if(obj.isRented()) {
            System.out.println(obj.getCurrentRentStartDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        } else {
            System.out.println("NOT RENTED");
        }
    }

    @Override
    public void print(Collection<Vehicle> objCollection) {
        for(Vehicle v : objCollection) {
            print(v);
        }
    }
}
