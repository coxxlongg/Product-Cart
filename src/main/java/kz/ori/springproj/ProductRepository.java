package kz.ori.springproj;


import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void init() {
        products.add(new Product(1L, "Product 1", 10.0));
        products.add(new Product(2L, "Product 2", 20.0));
        products.add(new Product(3L, "Product 3", 30.0));
        products.add(new Product(4L, "Product 4", 40.0));
        products.add(new Product(5L, "Product 5", 50.0));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
