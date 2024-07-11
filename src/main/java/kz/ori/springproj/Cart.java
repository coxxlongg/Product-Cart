package kz.ori.springproj;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> products = new ArrayList<>();

    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(products::add);
    }

    public void removeProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}

