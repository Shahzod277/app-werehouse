package uz.developer.appwerehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.developer.appwerehouse.entity.Werehouse;

import java.util.Collection;
import java.util.List;

public interface WerehouseRespository extends JpaRepository<Werehouse, Integer> {
    @Query(value = "select * from werehouse w where id in (:ids)", nativeQuery = true)
    List<Werehouse> findAllByIdIn(@Param(value = "ids") List<Integer> ids);

    boolean existsByName(String name);
}
