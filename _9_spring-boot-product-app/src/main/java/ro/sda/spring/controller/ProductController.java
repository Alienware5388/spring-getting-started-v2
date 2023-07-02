package ro.sda.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Product;
import ro.sda.spring.service.ProductService;

import java.lang.reflect.Constructor;
import java.util.List;

/*
    we annotated the class with @Slf4j in order to have a static Logger variable named "log"

    fatal
    error
    warn
    info
    debug
    trace
 */
@Slf4j
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product p){
        log.info("/product endpoint called");
        productService.addProduct(p);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        log.info("/products endpoint called");
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getById(@PathVariable int id){
        log.info("/product/{id} endpoint called");
        return productService.getById(id);
    }
}
