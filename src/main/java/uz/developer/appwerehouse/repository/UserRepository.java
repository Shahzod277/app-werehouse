package uz.developer.appwerehouse.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.developer.appwerehouse.entity.User;
import uz.developer.appwerehouse.payload.UserDto;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select *from Users u inner join Werehouse w on u.id=w.id ", nativeQuery = true)
    List<UserDto> getAllUser();

    boolean existsByPhoneNumberAndIdNot(String phoneNumber, Integer id);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
