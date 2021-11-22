package uz.developer.appwerehouse.service;

import uz.developer.appwerehouse.entity.Supplier;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.SupplierDto;

public interface SupplierService {
    Result getOneSupplier(Integer id);

    Result getAllSupplier();

    Result deleteSupplier(Integer id);

    Result editSupplier(Integer id, SupplierDto supplierDto);

    Result addSupplier(SupplierDto supplierDto);
}
