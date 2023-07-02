package ro.sda.spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.spring.config.Config;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;
import ro.sda.spring.service.ProductService;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(Config.class)) {
//            var repository = ctx.getBean(ProductRepository.class);
//            repository.addProduct(new Product("IPhone14", "Like the previous one. "));
//            repository.addProduct(new Product("PSS", "Nice product "));
//            repository.addProduct(new Product("Samsung", "Good "));
//
//            List<Product> products = repository.getAllProducts();
            //we used method reference operator (resolution operator "::")
            // which combined with forEach and this means that every object from the list will be passed through
            //products.forEach(System.out::println);
//            for(Product p : products){
//                System.out.println(p);
//            }
            var productService = ctx.getBean(ProductService.class);
            productService.addProduct("IPhone 14", "Like the previous one. ");
            productService.addProduct("PS5", "Nice product ");
            productService.addProduct("Samsung", "Good ");
            List<Product> products = productService.getAllProducts();
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }
}