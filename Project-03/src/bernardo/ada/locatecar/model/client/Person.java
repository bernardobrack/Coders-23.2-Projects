package bernardo.ada.locatecar.model.client;

import bernardo.ada.locatecar.model.rent.Rentable;
import bernardo.ada.locatecar.model.rent.strategy.PersonRentCalculator;
import bernardo.ada.locatecar.utils.identifier.DefaultIdentifierValidator;
import bernardo.ada.locatecar.utils.identifier.IdentifierValidator;

import java.util.Objects;
import java.util.Set;

public class Person extends Client {

    public Person(String identificador, String name, Set<Rentable> rented) throws InstantiationException {
        super(identificador, name, rented);
        this.rentCalculator = new PersonRentCalculator();
    }

    @Override
    public boolean validateId() {
        IdentifierValidator validator = new DefaultIdentifierValidator();
        return validator.validate(this.getId());
    }

    @Override
    public String getType() {
        return "cpf";
    }


    @Override
    public Double calculateRent(Rentable rentable) throws Exception{
        if(Objects.equals(rentable.rentedBy(), this)) {
            return this.rentCalculator.calcRent(rentable);
        }
        throw new Exception("Veículo especificado não foi alugado pela pessoa em questão!");

    }
}
