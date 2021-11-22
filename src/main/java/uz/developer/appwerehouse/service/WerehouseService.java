package uz.developer.appwerehouse.service;

import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.WerehouseDto;

public interface WerehouseService {
    Result getAllWerehouse();

    Result getWerehouse(Integer id);

    Result addWerehouse(WerehouseDto werehouseDto);

    Result editWerehouse(Integer id, WerehouseDto werehouseDto);

    Result deleteWerehouse(Integer id);

}
