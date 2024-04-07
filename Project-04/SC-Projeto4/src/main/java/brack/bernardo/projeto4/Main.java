package brack.bernardo.projeto4;

import brack.bernardo.projeto4.connection.ConnectionSingleton;
import brack.bernardo.projeto4.constants.Constants;
import brack.bernardo.projeto4.domain.product.Product;
import brack.bernardo.projeto4.files.FileHandler;
import brack.bernardo.projeto4.service.ProductService;
import brack.bernardo.projeto4.repository.ProductRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Product> productList;
        try {
            productList = readFile();
        } catch (IOException e) {
            System.err.println("Error while reading csv file!");
            return;
        }
        Optional<Connection> connectionOptional = ConnectionSingleton.getConnection();
        if(connectionOptional.isEmpty()) {
            System.err.println("Error while trying to connect to the database!");
            return;
        }
        new App(productList, new ProductService(new ProductRepository(ConnectionSingleton.getConnection().get()))).start();
    }
    private static List<Product> readFile() throws IOException{
        Predicate<String> filter = s -> Constants.pattern.matcher(s).matches();
        Function<String, Product> converter = getConverter();
        FileHandler<Product> fileHandler = new FileHandler<>(filter, converter);
        return fileHandler.read("products.csv");

    }
    private static Function<String, Product> getConverter() {
        return (String line) -> {
            String[] separatedLine = line.split(",");
            String name = separatedLine[0];
            Integer quantity = Integer.parseInt(separatedLine[1]);
            String category = separatedLine[2];
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(separatedLine[3]));
            return new Product(null, name, quantity, category, price);
        };
    }


}
