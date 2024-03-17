package bernardo.ada.locatecar.controller.interfaces;

import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;

public interface RentControllerI {
    void unrent(String tag) throws ItemNotFoundException, RepositoryException;
    void rent(String clientId, String vehicleId) throws ItemNotFoundException, RepositoryException;
    Double calculateRent(String clientId, String vehicleTag) throws ItemNotFoundException, Exception;
}
