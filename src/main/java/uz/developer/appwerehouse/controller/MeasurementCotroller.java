package uz.developer.appwerehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developer.appwerehouse.payload.MeasurementDto;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.service.MeasurementService;
import uz.developer.appwerehouse.service.MeasurementServiceImpl;

@RestController
@RequestMapping("/measurement")
public class MeasurementCotroller {

    @Autowired
    MeasurementService measurementService;

    @PostMapping
    public Result addMeasurement(@RequestBody MeasurementDto measurementDto) {
        return measurementService.addMeasurement(measurementDto);
    }

    @GetMapping
    public Result getAllMeasurement() {
        return measurementService.getAllMeasurement();
    }

    @GetMapping("/{id}")
    public Result getOneMeasurement(@PathVariable Integer id) {
        return measurementService.getOneMeasurement(id);
    }

    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id) {
        return measurementService.deleteMeasurement(id);
    }

    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id, @RequestBody MeasurementDto measurementDto) {
        return measurementService.editMeasurement(id, measurementDto);
    }
}
