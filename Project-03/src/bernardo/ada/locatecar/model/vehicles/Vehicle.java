package bernardo.ada.locatecar.model.vehicles;

import bernardo.ada.locatecar.model.rent.Rentable;
import bernardo.ada.locatecar.model.rent.Renter;

import java.time.LocalDateTime;

public abstract class Vehicle implements Rentable {
    private final String placa;
    private String nome;
    private Renter currentRenter;
    protected LocalDateTime currentRent;

    protected Vehicle(String placa, String nome) {
        this.placa = placa;
        this.nome = nome;
    }
    @Override
    public void rent(Renter owner) {
        this.currentRenter = owner;
        currentRent = LocalDateTime.now();

    }
    @Override
    public boolean isRented() {
        return currentRenter != null;
    }
    @Override
    public void unrent() {
        currentRent = null;
        this.currentRenter = null;
    }

    @Override
    public Renter rentedBy() {
        return currentRenter;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {this.nome = nome;}

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Vehicle)) {
            return false;
        }
        Vehicle v = (Vehicle) o;
        return v.getPlaca().equalsIgnoreCase(this.getPlaca()) && v.getNome().equalsIgnoreCase(this.getNome());
    }
    @Override
    public String getId() {
        return this.placa;
    }
    @Override
    public int hashCode() {
        return placa.hashCode();
    }

}
