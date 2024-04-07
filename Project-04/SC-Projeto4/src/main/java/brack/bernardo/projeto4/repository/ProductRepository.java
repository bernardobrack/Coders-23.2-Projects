package brack.bernardo.projeto4.repository;

import brack.bernardo.projeto4.domain.product.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements Repository<Product>{

    private final Connection connection;
    public ProductRepository(Connection conn) {
        this.connection = conn;
    }
    @Override
    public List<Product> list() {
        String sql = "SELECT * FROM PRODUCT;";
        List<Product> response = new ArrayList<>();
        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)) {
            while(resultSet.next()) {
                response.add(
                        new Product(
                                resultSet.getLong("ID"),
                                resultSet.getString("NAME"),
                                resultSet.getInt("QUANTITY"),
                                resultSet.getString("CATEGORY"),
                                resultSet.getBigDecimal("PRICE"))
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while reading product from database!");
        }

        return response;
    }

    @Override
    public void save(Product toSave) {
        String sql = "INSERT INTO PRODUCT(NAME, QUANTITY, CATEGORY, PRICE) VALUES ('%s', %d, '%s', %s);"
                .formatted(toSave.name(), toSave.quantity(),toSave.category(),toSave.price());
        try(Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Error while inserting product to database!");
        }
    }

    @Override
    public void update(Product toUpdate) {
        String sql = "UPDATE PRODUCT SET NAME = '%s', QUANTITY = %d, CATEGORY = '%s', PRICE = %s WHERE ID = %s;"
                .formatted(toUpdate.name(), toUpdate.quantity(),toUpdate.category(),toUpdate.price(), toUpdate.id());
        try(Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Error while inserting product to database!");
        }
    }

    @Override
    public void delete(Product toDelete) {
        String sql = "DELETE FROM PRODUCT WHERE ID = %s;"
                .formatted(toDelete.id());
        try(Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Error while inserting product to database!");
        }
    }

    @Override
    public Optional<Product> getById(Long id) {
        String sql = "SELECT * FROM PRODUCT WHERE ID = %s;".formatted(id);
        Product response = null;
        try(Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)) {
            if(resultSet.next()) {
                response = new Product(
                        resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("QUANTITY"),
                        resultSet.getString("CATEGORY"),
                        resultSet.getBigDecimal("PRICE")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error while reading product from database!");
        }
        return Optional.ofNullable(response);
    }
}
