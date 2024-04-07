package brack.bernardo.projeto4.service;

import brack.bernardo.projeto4.domain.product.Product;
import brack.bernardo.projeto4.repository.ProductRepository;
import brack.bernardo.projeto4.utils.ProductValidator;

import java.util.List;
import java.util.Optional;

public class ProductService implements Service<Product>{
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Product> list() {
        return repository.list();
    }

    @Override
    public void save(Product toSave) {
        if(!ProductValidator.isValid(toSave)) {
            System.err.println("Error: product to save is invalid!");
            return;
        }
        repository.save(toSave);
    }

    @Override
    public void update(Product toUpdate) {
        if(!ProductValidator.isValid(toUpdate)) {
            System.err.println("Error: product to update is invalid!");
            return;
        }
        repository.update(toUpdate);
    }

    @Override
    public void delete(Product toDelete) {
        if(toDelete == null) {
            System.err.println("Error: product to delete not found!");
            return;
        }
        if(toDelete.id() < 0) {
            System.err.println("Error: product to delete not found!");
            return;
        }
        repository.delete(toDelete);
    }

    @Override
    public Optional<Product> getById(Long id) {
        if(id == null) {
            System.err.println("Error: product id invalid!");
            return Optional.empty();
        }
        if(id < 0) {
            System.err.println("Error: product id invalid!");
            return Optional.empty();
        }
        return repository.getById(id);
    }
}
