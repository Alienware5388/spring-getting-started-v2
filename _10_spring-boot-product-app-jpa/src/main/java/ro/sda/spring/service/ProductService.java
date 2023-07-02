package ro.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sda.spring.exception.ProductAppException;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product p) {
        productRepository.save(p);
        log.info("Product added to the database.");
    }

    public List<Product> findAllProducts() {
        List<Product> result = productRepository.findAll();
        log.info("All products retrieved");
        return result;
    }

    public Product findById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            log.info("Successfully retrieved product with id {}", id);
            return productOptional.get();
        }
        throw new ProductAppException("Product not found!");
    }
}
