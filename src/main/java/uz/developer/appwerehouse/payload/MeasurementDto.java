package uz.developer.appwerehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeasurementDto {
    private Integer id;

    private String name;

    private boolean active;
}
