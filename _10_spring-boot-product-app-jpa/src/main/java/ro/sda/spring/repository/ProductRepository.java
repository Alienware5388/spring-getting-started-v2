package ro.sda.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.spring.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByPriceGreaterThanEqual(int price);
    List<Product> findProductsByPriceLessThanEqual(int price);

    Optional<Product> findProductByName (String name);

}
