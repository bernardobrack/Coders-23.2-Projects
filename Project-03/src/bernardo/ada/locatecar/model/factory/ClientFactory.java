package bernardo.ada.locatecar.model.factory;

import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.model.client.Company;
import bernardo.ada.locatecar.model.client.Person;
import bernardo.ada.locatecar.model.factory.exception.ClientFactoryException;

import java.util.HashSet;


public class ClientFactory {
    public static Client createClient(String identifier, String name, String type) throws ClientFactoryException, InstantiationException {
        return switch (type.toUpperCase()) {
            case "CPF" -> new Person(identifier, name, new HashSet<>());
            case "CNPJ" -> new Company(identifier, name, new HashSet<>());
            default -> throw new ClientFactoryException("Invalid vehicle type!");
        };
    }
}
