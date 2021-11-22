package uz.developer.appwerehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private String massege;
    private Integer code;

    private Object date;

    public Result(String massege, Integer code) {
        this.massege = massege;
        this.code = code;
    }
}
