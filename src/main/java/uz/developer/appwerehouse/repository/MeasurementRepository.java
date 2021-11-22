package uz.developer.appwerehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.developer.appwerehouse.entity.Measurement;
import uz.developer.appwerehouse.payload.MeasurementDto;

import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    boolean existsByName(String name);

    @Query(value = "select id, name ,active from Measurement m where m.id=id  ", nativeQuery = true)
    Optional<MeasurementDto> getOneMeasurement(Integer id);
//@Query(value = "update Measurement m set m.name=name,m.active=active where m.id=id",nativeQuery = true)
    //  public Optional<MeasurementDto> editMeasurement(Integer id);

    //    @Query(value = "select m.name, m.id,m.active from Measurement m where m.id<>id and m.name<>name",nativeQuery = true)
//    public Optional<MeasurementDto> getMeasurementIdisnotAnd
    boolean existsByNameAndIdNot(String name, Integer id);
}
