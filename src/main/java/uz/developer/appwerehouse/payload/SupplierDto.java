package uz.developer.appwerehouse.payload;

import lombok.Data;

@Data
public class SupplierDto {
    private Integer id;

    private String name;

    private String phoneNumber;

    private boolean active = true;

}
