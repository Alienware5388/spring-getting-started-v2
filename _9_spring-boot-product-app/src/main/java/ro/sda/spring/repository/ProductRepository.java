package ro.sda.spring.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ro.sda.spring.model.Product;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init(){
        String sql = "CREATE TABLE IF NOT EXISTS product(id bigint auto_increment, name varchar(255), price int, description varchar(255))";
        jdbcTemplate.update(sql);
        log.info("Table product was created!");
    }

    public void addProduct(Product p){
        String sql = "INSERT INTO product(name, price, description) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, p.getName(), p.getPrice(), p.getDescription());
    }

    public List<Product> getAllProducts(){
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    public Product getById(int id){
        String sql = "SELECT * FROM product where ID = ?";
        return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
    }

    static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            p.setDescription(rs.getString("description"));
            return p;
        }
    }
}
