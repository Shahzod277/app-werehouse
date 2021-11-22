package uz.developer.appwerehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appwerehouse.entity.Measurement;
import uz.developer.appwerehouse.payload.MeasurementDto;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    @Override
    public Result addMeasurement(MeasurementDto measurementDto) {
        boolean existsByName = measurementRepository.existsByName(measurementDto.getName());
        if (existsByName) {
            return new Result("this measurement already added", 100, null);
        }
        Measurement measurement = new Measurement();
        measurement.setName(measurementDto.getName());
        measurement.setActive(measurementDto.isActive());
        measurementRepository.save(measurement);
        return new Result("successfull added", 400, null);
    }

    @Override
    public Result editMeasurement(Integer id, MeasurementDto measurementDto) {
        Optional<MeasurementDto> optionalMeasurementDto = measurementRepository.getOneMeasurement(id);
        if (optionalMeasurementDto.isPresent()) {
            boolean b = measurementRepository.existsByNameAndIdNot(measurementDto.getName(), id);
            if (!b) {
                Measurement editMeasurement = new Measurement();
                editMeasurement.setName(measurementDto.getName());
                editMeasurement.setActive(measurementDto.isActive());
                return new Result("Measurement successfull edited", 407, optionalMeasurementDto.get());
            } else {
                return new Result("measurement name already added", 506, null);
            }
        }
        return new Result("id not found ", 202, null);
    }


    @Override
    public Result deleteMeasurement(Integer id) {
        boolean byId = measurementRepository.existsById(id);
        if (byId) {
            measurementRepository.deleteById(id);
            return new Result("measurement successfull delete", 404, null);
        }
        return new Result("id not found", 106, null);
    }

    @Override
    public Result getAllMeasurement() {
        List<Measurement> measurementList = measurementRepository.findAll();
        if (measurementList.isEmpty()) {
            return new Result("data don't have", 101, false);
        }
        return new Result("all date", 401, measurementList);

    }


    @Override
    public Result getOneMeasurement(Integer id) {
        Optional<MeasurementDto> optionalMeasurement = measurementRepository.getOneMeasurement(id);
        return optionalMeasurement.map(measurementDto -> new Result("this id information", 403, measurementDto)).orElseGet(() -> new Result("this id date not found", 202, null));
    }

}
