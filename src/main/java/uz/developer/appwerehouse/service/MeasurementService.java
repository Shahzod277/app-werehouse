package uz.developer.appwerehouse.service;

import uz.developer.appwerehouse.payload.MeasurementDto;
import uz.developer.appwerehouse.payload.Result;


public interface MeasurementService {
    Result addMeasurement(MeasurementDto measurementDto);

    Result editMeasurement(Integer id, MeasurementDto measurementDto);

    Result deleteMeasurement(Integer id);

    Result getAllMeasurement();

    Result getOneMeasurement(Integer id);
}
