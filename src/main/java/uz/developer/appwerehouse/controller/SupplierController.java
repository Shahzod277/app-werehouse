package uz.developer.appwerehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.SupplierDto;
import uz.developer.appwerehouse.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("/{id}")
    public Result getSupplier(@PathVariable Integer id) {
        return supplierService.getOneSupplier(id);
    }

    @GetMapping
    public Result getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    @PostMapping
    public Result addSuppllier(@RequestBody SupplierDto supplierDto) {
        return supplierService.addSupplier(supplierDto);
    }

    @PutMapping("/{id}")
    public Result editSupplier(@PathVariable Integer id, @RequestBody SupplierDto supplierDto) {
        return supplierService.editSupplier(id, supplierDto);
    }

    @DeleteMapping("/id")
    public Result deleteSupplier(@PathVariable Integer id) {
        return supplierService.deleteSupplier(id);
    }
}
