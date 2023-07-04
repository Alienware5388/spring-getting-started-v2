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
        if (productRepository.findProductByName(p.getName())) {
            log.info("A product with the same name already exists in the database");
        } else {
            productRepository.save(p);
            log.info("Product added to the database.");
        }
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

    public void deleteById(long id){
        productRepository.deleteById(id);
        log.info("Product with id {} has been deleted.", id);
    }

    public void updateProduct(Product p){
        log.info("Attempting to find product with id {}", p.getId());
        // we use this to check if the product with this id exists (if not exists this method will throw an exception)
        findById(p.getId());
        // Product p with this id is already in the database and as long as the ids are the same,
        // we overwrite the initial column values with the values that came from the controller
        productRepository.save(p);
    }

    public List<Product> getProductsWithPriceGraterThan(int price) {
        log.info("Attempting to find products with price greater or equal than {}", price);
        return productRepository.findProductsByPriceGreaterThanEqual(price);
    }

    public List<Product> getProductsWithPriceSmallerThan(int price) {
        log.info("Attempting to find products with price smaller or equal than {}", price);
        return productRepository.findProductsByPriceLessThanEqual(price);
    }

//    public boolean findProductByName(String name) {
//
//        Optional<Product> productOptional = productRepository.findProductByName(name);
//
//        if (productOptional.isPresent()) {
//            log.info("Successfully retrieved product with name {}", name);
//            return true;
//        }
//        throw new ProductAppException("Product not found!");
//    }

}
