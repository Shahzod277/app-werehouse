package uz.developer.appwerehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developer.appwerehouse.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    boolean existsByName(String name);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByNameAndIdNot(String name, Integer id);
    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);
}
