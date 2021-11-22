package uz.developer.appwerehouse.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class WerehouseDto {

    private Integer id;

    private String name;

    private boolean active = true;
}
