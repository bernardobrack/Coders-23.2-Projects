package brack.bernardo.projeto4.utils;

import brack.bernardo.projeto4.domain.product.Product;

import java.math.BigDecimal;

public class ProductValidator {
    public static boolean isValid(Product product) {
        if(product == null) return false;
        if(product.name() == null || product.name().trim().isEmpty()) {
            return false;
        }
        if(product.category() == null || product.category().trim().isEmpty()) {
            return false;
        }
        if(product.price() == null || product.price().compareTo(BigDecimal.ZERO) < 0) return false;
        return !(product.quantity() == null || product.quantity() < 0);
    }
}
