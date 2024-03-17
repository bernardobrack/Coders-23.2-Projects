package bernardo.ada.locatecar.model.rent;

import java.time.LocalDateTime;

public interface Rentable {

    String getId();
    void rent(Renter owner);
    void unrent();
    boolean isRented();
    Renter rentedBy();
    Double getDailyPrice();
    LocalDateTime getCurrentRentStartDate();
}
