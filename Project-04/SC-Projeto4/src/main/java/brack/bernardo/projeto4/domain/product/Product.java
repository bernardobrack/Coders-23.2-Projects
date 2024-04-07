package brack.bernardo.projeto4.domain.product;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        Integer quantity,
        String category,
        BigDecimal price
){
    @Override
    public String toString() {
        return "%s - %d - %s - %s".formatted(name, quantity, category, price);
    }
}
