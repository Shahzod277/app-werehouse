package uz.developer.appwerehouse.payload;

import lombok.Data;
import uz.developer.appwerehouse.entity.Attachment;

@Data
public class ProductDto {
    private Integer categoryId;

    private Attachment id;

    private String code;

    private Integer measurementId;
}
