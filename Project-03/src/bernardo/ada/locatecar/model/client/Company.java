package bernardo.ada.locatecar.model.client;

import bernardo.ada.locatecar.model.rent.Rentable;
import bernardo.ada.locatecar.model.rent.strategy.CompanyRentCalculator;
import bernardo.ada.locatecar.utils.identifier.DefaultIdentifierValidator;
import bernardo.ada.locatecar.utils.identifier.IdentifierValidator;

import java.util.Objects;
import java.util.Set;

public class Company extends Client {
    public Company(String identificador, String name, Set<Rentable> rented) throws InstantiationException {
        super(identificador, name, rented);
        this.rentCalculator = new CompanyRentCalculator();

    }

    @Override
    public boolean validateId() {
        IdentifierValidator validator = new DefaultIdentifierValidator();
        return validator.validate(this.getId());
    }

    @Override
    public String getType() {
        return "cnpj";
    }

    @Override
    public Double calculateRent(Rentable rentable) throws Exception{
        if(Objects.equals(rentable.rentedBy(), this)) {
            return rentCalculator.calcRent(rentable);
        }
        throw new Exception("Veículo especificado não está alugado pela empresa em questão!");
    }
}
