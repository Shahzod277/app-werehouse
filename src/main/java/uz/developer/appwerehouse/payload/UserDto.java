package uz.developer.appwerehouse.payload;

import lombok.Data;
import uz.developer.appwerehouse.entity.Werehouse;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

@Data
public class UserDto {


    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String code;

    private String password;

    private boolean active = true;


    private List<Integer> werehouseId;
}
