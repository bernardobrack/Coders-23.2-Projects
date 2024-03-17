package bernardo.ada.locatecar.model.rent.strategy;

import bernardo.ada.locatecar.model.rent.RentCalculable;
import bernardo.ada.locatecar.model.rent.Rentable;

import java.time.Duration;
import java.time.LocalDateTime;

public class PersonRentCalculator implements RentCalculable {
    Rentable rentable;
    Long hourGap;
    Long diarias;
    @Override
    public Double calcRent(Rentable rentable) {
        this.rentable = rentable;
        this.hourGap = getHourGap(rentable.getCurrentRentStartDate(), LocalDateTime.now());
        this.diarias = getDiarias();
        return (rentable.getDailyPrice() * diarias) * (1-calcDiscount());
    }
    public Double calcRent(Rentable rentable, LocalDateTime date) {
        this.rentable = rentable;
        this.hourGap = getHourGap(rentable.getCurrentRentStartDate(), LocalDateTime.now());
        this.diarias = getDiarias();
        return (rentable.getDailyPrice() * diarias) * (1-calcDiscount());
    }
    private Double calcDiscount() {
        if(diarias > 5) return 0.05d;
        return 0d;
    }
    private Long getDiarias() {
        return Double.valueOf(Math.ceil((double) this.hourGap/24)).longValue() + 1;
    }
    private Long getHourGap(LocalDateTime then, LocalDateTime now) {
        Duration duration = Duration.between(then, now);
        return duration.toHours();

    }
}
