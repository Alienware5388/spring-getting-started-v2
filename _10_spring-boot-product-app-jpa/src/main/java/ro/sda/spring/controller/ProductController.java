package ro.sda.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Product;
import ro.sda.spring.service.ProductService;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product p){
        log.info("Initializing adding product flow.");
        productService.addProduct(p);
        log.info("Successfully added product.");
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        log.info("Initializing retrieving all products flow.");
        List<Product> products = productService.findAllProducts();
        log.info("Successfully retrieved all products.");
        return products;
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable long id){
        log.info("Initializing findById flow.");
        Product product = productService.findById(id);
        log.info("Successfully retrieved product with id {}", id);
        return product;
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id){
        log.info("Initializing deleteById flow.");
        productService.deleteById(id);
        log.info("Product deleted successfully.");
    }

    @PutMapping("/product")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Product p){
        log.info("Initializing update product flow.");
        productService.updateProduct(p);
        log.info("Product updated successfully.");
    }

    @GetMapping("/products")
    public void getProductsPriceGraterThan(@RequestParam int price){
        log.info("Initializing get products with price greater than flow.");
        productService.getProductsWithPriceGraterThan(price);
        log.info("Products retrieved successfully.");

    }
}
