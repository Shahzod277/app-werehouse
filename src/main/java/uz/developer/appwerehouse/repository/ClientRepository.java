package uz.developer.appwerehouse.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.expression.spel.ast.OpAnd;
import uz.developer.appwerehouse.entity.Client;
import uz.developer.appwerehouse.payload.ClientDto;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "select * from Client  c where c.id =id ", nativeQuery = true)
    Optional<ClientDto> findbyId(Integer id);

    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);

    boolean existsByName(String name);

    boolean existsByPhoneNumber(String phoneNumber);
}
