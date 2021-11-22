package uz.developer.appwerehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Integer id;

    private String name;

    private String phoneNumber;

    private boolean active = true;
}
