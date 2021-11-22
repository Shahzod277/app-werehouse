package uz.developer.appwerehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.WerehouseDto;
import uz.developer.appwerehouse.repository.WerehouseRespository;
import uz.developer.appwerehouse.service.WerehouseService;

@RestController
@RequestMapping("/werehouse")
public class WerehouseController {
    @Autowired
    WerehouseService werehouseService;

    @GetMapping("/{id}")
    public Result getWerehouse(@PathVariable Integer id) {
        return werehouseService.getWerehouse(id);
    }

    @GetMapping
    public Result getAllWerehouse() {
        return werehouseService.getAllWerehouse();
    }

    @DeleteMapping("/{id}")
    public Result deleteWerehouse(@PathVariable Integer id) {
        return werehouseService.deleteWerehouse(id);
    }

    @PostMapping
    public Result addWerehouse(@RequestBody WerehouseDto werehouseDto) {
        return werehouseService.addWerehouse(werehouseDto);
    }

    @PutMapping("/{id}")
    public Result editWerehouse(@PathVariable Integer id, @RequestBody WerehouseDto werehouseDto) {
        return werehouseService.editWerehouse(id, werehouseDto);
    }
}
