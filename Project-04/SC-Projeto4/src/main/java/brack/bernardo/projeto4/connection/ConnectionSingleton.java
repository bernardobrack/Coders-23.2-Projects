package brack.bernardo.projeto4.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public final class ConnectionSingleton {
    private static Connection connection;

    public static Optional<Connection> getConnection() {
        if(connection == null) {
            String url = "jdbc:mysql://localhost:3306/project4-db";
            String username = "root";
            String password = "pwd123";
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch(SQLException ex) {
                connection = null;
            }
        }
        return Optional.ofNullable(connection);

    }
}
