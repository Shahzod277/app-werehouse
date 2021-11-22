package uz.developer.appwerehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developer.appwerehouse.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Integer id);
}

