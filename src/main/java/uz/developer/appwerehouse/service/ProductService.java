package uz.developer.appwerehouse.service;

import uz.developer.appwerehouse.payload.ClientDto;
import uz.developer.appwerehouse.payload.Result;

public interface ProductService {
    Result getOneProduct(Integer id);

    Result getAllProduct();

    Result deleteProduct(Integer id);

    Result editProduct(Integer id, ClientDto clientDto);

    Result addProduct(ClientDto clientDto);
}
