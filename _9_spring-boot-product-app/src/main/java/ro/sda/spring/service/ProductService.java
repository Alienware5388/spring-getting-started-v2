package ro.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product p){
        productRepository.addProduct(p);
        log.info("Product with name {} created.", p.getName());
    }

    public List<Product> getAllProducts(){
        List<Product> products = productRepository.getAllProducts();
        log.info("Total products {} retrieved", products.size());
        return products;
    }

    public Product getById(int id){
        Product prod = productRepository.getById(id);
        log.info("Product with id {} retrieved", id);
        return prod;
    }
}
