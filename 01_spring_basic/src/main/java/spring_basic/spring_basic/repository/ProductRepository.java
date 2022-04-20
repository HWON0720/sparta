package spring_basic.spring_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_basic.spring_basic.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
