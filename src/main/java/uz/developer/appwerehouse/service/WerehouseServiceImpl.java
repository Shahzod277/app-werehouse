package uz.developer.appwerehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appwerehouse.entity.Werehouse;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.WerehouseDto;
import uz.developer.appwerehouse.repository.WerehouseRespository;

import java.util.List;
import java.util.Optional;

@Service
public class WerehouseServiceImpl implements WerehouseService {
    @Autowired
    WerehouseRespository werehouseRespository;

    @Override
    public Result getAllWerehouse() {
        List<Werehouse> all = werehouseRespository.findAll();
        if (all.isEmpty()) {
            return new Result("werehouse not found ", 404, null);
        }
        return new Result("all werehouse", 202, all);
    }

    @Override
    public Result getWerehouse(Integer id) {
        Optional<Werehouse> byId = werehouseRespository.findById(id);
        if (byId.isPresent()) {
            return new Result("one Werehouse ", 202, byId.get());
        }
        return new Result("id not found", 404, null);
    }

    @Override
    public Result addWerehouse(WerehouseDto werehouseDto) {
        boolean b = werehouseRespository.existsByName(werehouseDto.getName());
        if (b) {
            return new Result("this werehouse already added", 404, null);
        }
        Werehouse werehouse = new Werehouse();
        werehouse.setActive(werehouseDto.isActive());
        werehouse.setName(werehouseDto.getName());
        werehouseRespository.save(werehouse);
        return new Result("werhouse added", 201);
    }


    @Override
    public Result editWerehouse(Integer id, WerehouseDto werehouseDto) {
        Optional<Werehouse> optionalWerehouse = werehouseRespository.findById(werehouseDto.getId());
        if (optionalWerehouse.isPresent()) {
            Werehouse werehouse = optionalWerehouse.get();
            werehouse.setName(werehouseDto.getName());
            werehouse.setActive(werehouseDto.isActive());
            werehouseRespository.save(werehouse);
            return new Result("werehouse edited", 202);
        }
        return new Result("werehouse id not found", 404, null);
    }

    @Override
    public Result deleteWerehouse(Integer id) {
        boolean b = werehouseRespository.existsById(id);
        if (b) {
            werehouseRespository.deleteById(id);
            return new Result("werehousee deleted", 203);
        }
        return new Result("werehouse id not found ", 402, null);
    }
}
