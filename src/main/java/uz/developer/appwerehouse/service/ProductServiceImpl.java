package uz.developer.appwerehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appwerehouse.entity.Product;
import uz.developer.appwerehouse.payload.ClientDto;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Result getOneProduct(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            return new Result("id not found", 401, null);
        }
        return new Result(".", 201, byId.get());
    }

    @Override
    public Result getAllProduct() {

        List<Product> all = productRepository.findAll();
        if (all.isEmpty()) {
            return new Result("empty this table", 405, null);
        }
        return new Result("all product", 203, all);
    }

    @Override
    public Result deleteProduct(Integer id) {
        boolean b = productRepository.existsById(id);
        if (!b) {
            return new Result("id not found ",405,null);
        }
        return new Result("delete profuct",204,null);
    }

    @Override
    public Result editProduct(Integer id, ClientDto clientDto) {
        return null;
    }

    @Override
    public Result addProduct(ClientDto clientDto) {
        return null;
    }
}
