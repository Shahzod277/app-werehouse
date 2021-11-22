package uz.developer.appwerehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appwerehouse.entity.Supplier;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.SupplierDto;
import uz.developer.appwerehouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SuplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Result getOneSupplier(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isPresent()) {
            return new Result("one supplier", 490, optionalSupplier.get());
        }
        return new Result("not found id ", 202, null);
    }

    @Override
    public Result getAllSupplier() {
        List<Supplier> supplierList = supplierRepository.findAll();
        if (supplierList.isEmpty()) {
            return new Result("supplier not found ", 203, null);
        }
        return new Result("All supplier", 405, supplierList);
    }

    @Override
    public Result deleteSupplier(Integer id) {
        boolean existsById = supplierRepository.existsById(id);
        if (existsById) {
            supplierRepository.deleteById(id);
            return new Result("supplier deleted", 493);
        }
        return new Result("id not found", 203);
    }

    @Override
    public Result editSupplier(Integer id, SupplierDto supplierDto) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isPresent()) {
            Supplier supplier = byId.get();
            boolean exists = supplierRepository.existsByNameAndIdNot(supplierDto.getName(), id);
            if (exists) {
                return new Result("this name already has", 303, null);
            }
            supplier.setName(supplierDto.getName());
            supplier.setActive(supplierDto.isActive());
            boolean existsByPhoneNumberAndIdNot = supplierRepository.existsByPhoneNumberAndIdNot(supplierDto.getPhoneNumber(), id);
            if (existsByPhoneNumberAndIdNot) {
                return new Result("send phoneNumber has in db", 405, null);
            }
            supplier.setPhoneNumber(supplierDto.getPhoneNumber());
            supplierRepository.save(supplier);
            return new Result("supplier added", 402);
        }
        return new Result("supplier id not found ", 201, supplierDto);
    }

    @Override
    public Result addSupplier(SupplierDto supplierDto) {
        boolean existsByName = supplierRepository.existsByName(supplierDto.getName());
        if (existsByName) {
            return new Result("this supplier already added", 203, null);
        }
        Supplier supplier = new Supplier();
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplierDto.getPhoneNumber());
        if (!existsByPhoneNumber) {
            supplier.setPhoneNumber(supplierDto.getPhoneNumber());
            supplier.setName(supplierDto.getName());
            supplier.setActive(supplierDto.isActive());
            supplierRepository.save(supplier);
            return new Result("supplier added", 404);
        }
        return new Result("supplier's phone number alredy added in database", 303);
    }


}
