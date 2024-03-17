package bernardo.ada.locatecar.views.printer;

import bernardo.ada.locatecar.model.rent.Rentable;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class RentablePrinter implements Printer<Rentable>{
    @Override
    public void print(Rentable obj) {
        System.out.println(obj.getId() + " - " + obj.rentedBy().getId() + " - " + obj.getCurrentRentStartDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }

    @Override
    public void print(Collection<Rentable> objCollection) {
        for(Rentable rentable : objCollection) {
            print(rentable);
        }
    }
}
