package ro.sda.spring.service;
import org.springframework.stereotype.Service;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;
import java.util.List;
@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public void addProduct(String name, String description){
        productRepository.addProduct(new Product(name, description));
        System.out.println("Product " + name + " created.");
    }
    public List<Product> getAllProducts(){
        List<Product> productList = productRepository.getAllProducts();
        System.out.println("ALl products retrieved.");
        return productList;
    }
}
