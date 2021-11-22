package uz.developer.appwerehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developer.appwerehouse.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
