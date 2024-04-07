package brack.bernardo.projeto4;

import brack.bernardo.projeto4.domain.product.Product;
import brack.bernardo.projeto4.service.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class App {
    Service<Product> productService;

    public App(List<Product> startingProducts, Service<Product> productService) {
        this.productService = productService;
        init(startingProducts);
    }

    public void start() {
        // Add new product to database, find it, update it
        productService.save(new Product(null, "Meu novo produto", 10, "Minha categoria", BigDecimal.TEN));
        List<Product> productList = productService.list();
        Optional<Product> productOptional = productList.stream()
                .filter(p -> p.name().equals("Meu novo produto"))
                .findFirst();

        System.out.print("Produto: ");
        productOptional.ifPresentOrElse(System.out::println, () -> {
            System.err.println("não encontrado!");
            return;
        });

        Product found = productOptional.get();
        productService.update(new Product(
                found.id(),
                "Super Televisão UAU",
                found.quantity(),
                "Eletrônicos",
                found.price()
        ));

        productOptional = productService.getById(found.id());
        System.out.print("Produto modificado: ");
        productOptional.ifPresentOrElse(System.out::println, () -> {
            System.err.println("Produto nao encontrado!");
            return;
        });



        // List all products
        System.out.printf("%n%nLista de todos os produtos:%n");
        productList = productService.list();
        productList.forEach(System.out::println);

        // How many products and categories?
        System.out.printf("%n%nNúmero de produtos diferentes: %d%n", productList.size());
        System.out.printf("Número total de produtos: %d%n", productList.stream().mapToInt(Product::quantity).sum());
        long numberOfCategories = countCategories(productList);
        System.out.printf("Numero de categorias: " + numberOfCategories + "%n");

        // Amount of products of each category
        System.out.printf("%n%nQuantidade de produtos por categoria:%n");
        Map<String, Long> map = productList.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.counting()
                ));

        map.forEach((String key, Long value) -> {
            System.out.printf("%s: %s%n", key,value);
        });

        // Average price
        double average = productList.stream()
                .collect(Collectors.averagingDouble(p -> p.price().doubleValue()));
        System.out.printf("%n%nMédia de preço: R$%.2f%n", average);

        // Low stock
        List<Product> lowStockProducts = productList.stream()
                .filter(p -> p.quantity() < 3).toList();
        System.out.println("Há poucos no estoque dos seguintes itens: ");
        lowStockProducts.forEach(System.out::println);

        System.err.println("NÃO SE ESQUEÇA DE DELETAR OS PRODUTOS CRIADOS DA BASE DE DADOS ANTES DE RODAR NOVAMENTE!");
    }

    private void init(List<Product> startingProducts) {
        startingProducts.forEach(product -> productService.save(product));
    }

    private long countCategories(List<Product> productList) {
        return productList
                .stream()
                .map(Product::category)
                .distinct()
                .count();
    }
}
